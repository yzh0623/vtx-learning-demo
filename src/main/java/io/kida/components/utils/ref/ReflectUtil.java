package io.kida.components.utils.ref;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.esotericsoftware.reflectasm.MethodAccess;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.json.Json;

public class ReflectUtil {

    private static final Logger LOGGER = LogManager.getLogger(ReflectUtil.class);

    private static final String GETTER = "get";
    private static final String SETTER = "set";
    private static final String UTF_8 = "UTF-8";

    /**
     * 
     * @MethodName: getFields
     * @Description: 获取指定类的所有字段,排除static,final字段
     * @author yuanzhenhui
     * @param clazz
     * @return List<Field>
     * @date 2023-04-13 04:33:15
     */
    public static List<Field> getFields(Class<?> clazz) {
        List<Field> fieldResult = new ArrayList<>();
        while (clazz != Object.class) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    int modifiers = field.getModifiers();
                    // 过滤static或final字段
                    if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers)) {
                        continue;
                    }
                    fieldResult.add(field);
                }
            } catch (Exception e) {
                LOGGER.error("func[ReflectUtil.getFields] Exception [{} - {}] stackTrace[{}] ",
                    new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
            }
            clazz = clazz.getSuperclass();
        }
        return fieldResult;
    }

    /**
     * 
     * @MethodName: getSuperClassGenricType
     * @Description: 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型 如: public EmployeeDao extends BaseDao<Employee, String>
     * @author yuanzhenhui
     * @param clazz
     * @param index
     * @return Class<?>
     * @date 2023-04-13 04:33:44
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class<?>)params[index];
    }

    /**
     * 
     * @MethodName: getClasses
     * @Description: 根据包名获取包下面所有的类名
     * @author yuanzhenhui
     * @param scanPath
     * @param recursive
     * @return CopyOnWriteArraySet<Class<?>>
     * @date 2023-04-13 04:34:16
     */
    public static CopyOnWriteArraySet<Class<?>> getClasses(String scanPath, boolean recursive) {
        CopyOnWriteArraySet<Class<?>> classes = new CopyOnWriteArraySet<>();
        String packageName = scanPath;
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    findClassesInPackageByFile(packageName, URLDecoder.decode(url.getFile(), UTF_8), recursive,
                        classes);
                } else if ("jar".equals(protocol)) {
                    JarFile jar = ((JarURLConnection)url.openConnection()).getJarFile();
                    findClassesInPackageByJar(packageName, jar.entries(), packageDirName, recursive, classes);
                }
            }
        } catch (Exception e) {
            LOGGER.error("func[ReflectUtil.getClasses] Exception [{} - {}] stackTrace[{}] ",
                new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
        }
        return classes;
    }

    /**
     * 
     * @MethodName: getVerticleClasses
     * @Description: 获取Verticle类
     * @author yuanzhenhui
     * @param scanPath
     * @param recursive
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     *             CopyOnWriteArraySet<Class<Verticle>>
     * @date 2023-04-13 04:34:32
     */
    public static List<Class<Verticle>> getVerticleClasses(String scanPath, boolean recursive)
        throws IOException, ClassNotFoundException {
        List<Class<Verticle>> vcRe = null;

        String packageName = scanPath;
        String packageDirName = packageName.replace('.', '/');

        Set<Class<?>> classes = new HashSet<>();

        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                findClassesInPackageByFile(packageName, URLDecoder.decode(url.getFile(), UTF_8), recursive, classes);
            } else if ("jar".equals(protocol)) {
                JarFile jar = ((JarURLConnection)url.openConnection()).getJarFile();
                findClassesInPackageByJar(packageName, jar.entries(), packageDirName, recursive, classes);
            }
        }

        if (null != classes && !classes.isEmpty()) {
            vcRe = classes.stream().filter(AbstractVerticle.class::isAssignableFrom)
                .map(clazz -> (Class<Verticle>)clazz).collect(Collectors.toList());
        }
        return vcRe;
    }

    /**
     * 以jar的形式来获取包下的所有Class
     * 
     * @param packageName
     *            包名
     * @param entries
     *            jar枚举
     * @param packageDirName
     *            包路径
     * @param recursive
     *            是否递归
     * @param classes
     *            类集合
     * @throws ClassNotFoundException
     */
    private static void findClassesInPackageByJar(String packageName, Enumeration<JarEntry> entries,
        String packageDirName, boolean recursive, Set<Class<?>> classes) throws ClassNotFoundException {
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }
            if (name.startsWith(packageDirName)) {
                int idx = name.lastIndexOf('/');
                if (idx != -1) {
                    packageName = name.substring(0, idx).replace('/', '.');
                }
                if (((idx != -1) || recursive) && (name.endsWith(".class") && !entry.isDirectory())) {
                    classes.add(
                        Class.forName(packageName + '.' + name.substring(packageName.length() + 1, name.length() - 6)));
                }
            }
        }
    }

    /**
     * 以文件的形式来获取包下的所有Class
     * 
     * @param packageName
     *            包名称
     * @param packagePath
     *            包路径
     * @param recursive
     *            是否递归
     * @param classes
     *            类集合
     */
    private static void findClassesInPackageByFile(String packageName, String packagePath, boolean recursive,
        Set<Class<?>> classes) {
        try {
            File dir = new File(packagePath);
            if (!dir.exists() || !dir.isDirectory()) {
                LOGGER.warn("no packagename path : " + packageName + " has files");
                return;
            }
            File[] dirfiles =
                dir.listFiles(file -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class")));

            if (null != dirfiles) {
                for (File file : dirfiles) {
                    if (file.isDirectory()) {
                        findClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(),
                            recursive, classes);
                    } else {
                        classes.add(Thread.currentThread().getContextClassLoader()
                            .loadClass(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("func[ReflectUtil.findClassesInPackageByFile] Exception [{} - {}] stackTrace[{}] ",
                new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
        }
    }

    /**
     * 
     * @MethodName: convertJson2Pojo
     * @Description: 字符串转换成pojo对象
     * @author yuanzhenhui
     * @param <T>
     * @param bodyStr
     * @param clazz
     * @return T
     * @date 2022-08-10 03:41:07
     */
    public static <T> T convertJson2Pojo(String bodyStr, Class<T> clazz) {
        return Json.decodeValue(bodyStr, clazz);
    }

    /**
     * 
     * @MethodName: getValueByAsm
     * @Description: 通过ASM获取实体中的字段的值
     * @author yuanzhenhui
     * @param <T>
     * @param t
     * @param fieldName
     * @return Object
     * @date 2022-08-10 03:41:23
     */
    public static <T> Object getValueByAsm(T t, String fieldName) {
        return MethodAccess.get(t.getClass()).invoke(t,
            GETTER + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
    }

    /**
     * 
     * @MethodName: setValueByAsm
     * @Description: 通过ASM赋值到实体中
     * @author yuanzhenhui
     * @param <T>
     * @param t
     * @param fieldName
     * @param obj
     *            void
     * @date 2022-08-10 03:41:33
     */
    public static <T> void setValueByAsm(T t, String fieldName, Object obj) {
        MethodAccess.get(t.getClass()).invoke(t,
            SETTER + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), obj);
    }

    /**
     * 通过迭代获取子类与父类的所有字段
     * 
     * @param <T>
     * @param t
     * @return
     */
    public static <T> List<Field> getAllFields(T t) {
        Class<?> clazz = t.getClass();
        // 通过迭代的循环获取子类及父类中所有字段
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            // 当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            // 得到父类,然后赋给自己
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }

}
