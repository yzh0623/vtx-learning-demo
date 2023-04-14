package io.kida.components.utils.yaml;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.utils.yaml.annotations.PropLoader;
import io.kida.components.utils.yaml.constants.YamlConstants;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class YamlUtil {

    private static final Logger LOGGER = LogManager.getLogger(YamlUtil.class);

    /**
     * 返回Integer类型配置
     * 
     * @param key
     * @return
     */
    public static Integer getIntegerValue(String key) {
        return Integer.valueOf(getStringValue(key));
    }

    /**
     * 返回Boolean类型配置
     * 
     * @param key
     * @return
     */
    public static Boolean getBooleanValue(String key) {
        return Boolean.valueOf(getStringValue(key));
    }

    /**
     * 返回String类型配置
     * 
     * @param key
     * @return
     */
    public static String getStringValue(String key) {
        return String.valueOf(getValue(key));
    }

    /**
     * 返回List类型配置
     * 
     * @param key
     * @return
     */
    public static List<?> getListValue(String key) {
        return new JsonArray(getStringValue(key)).getList();
    }

    /**
     * 返回Map类型配置
     * 
     * @param key
     * @return
     */
    public static Map<?, ?> getMapValue(String key) {
        return new JsonObject(getStringValue(key)).getMap();
    }

    /**
     * 
     * @MethodName: getValue
     * @Description: 获取Object值
     * @author yuanzhenhui
     * @param value
     * @return Object
     * @date 2022-08-11 01:38:35
     */
    public static Object getValue(String value) {
        String[] values = value.split("\\.");
        int len = values.length - 1;
        JsonObject json = null;

        // 等待configJson静态变量加载完成
        while (true) {
            if (null != YamlConstants.CONF_JSON && !YamlConstants.CONF_JSON.isEmpty()) {
                json = YamlConstants.CONF_JSON;
                break;
            }
        }

        // 使用递归遍历获取到配置信息
        for (int i = 0; i < len; i++) {
            if (json.containsKey(values[i])) {
                json = json.getJsonObject(values[i]);
            } else {
                return null;
            }
        }
        return json.getValue(values[len]);
    }

    /**
     * 
     * @MethodName: propLoadSetter
     * @Description: 使用自定义注解获取到变量内容（不需要用到reflectasm）
     * @author yuanzhenhui
     * @param <T>
     * @param t
     *            void
     * @date 2022-08-11 01:38:17
     */
    public static <T> void propLoadSetter(T t) {
        Arrays.asList(t.getClass().getDeclaredFields()).stream().filter(f -> f.isAnnotationPresent(PropLoader.class))
            .forEach(f -> {
                f.setAccessible(true);
                PropLoader pl = f.getDeclaredAnnotation(PropLoader.class);
                try {
                    Object obj = getValue(pl.key());
                    if (obj instanceof JsonArray) {
                        obj = ((JsonArray)obj).getList();
                    } else if (obj instanceof JsonObject) {
                        obj = ((JsonObject)obj).getMap();
                    }
                    f.set(t, obj);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    LOGGER.error("func[YamlUtil.propLoadSetter] Exception [{} - {}]",
                        new Object[] {e.getCause(), e.getStackTrace()});
                }
            });
    }
}
