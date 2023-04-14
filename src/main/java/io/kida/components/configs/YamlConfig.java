package io.kida.components.configs;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import io.kida.components.constants.CommonConstants;
import io.kida.components.utils.yaml.constants.YamlConstants;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;

public class YamlConfig extends AbstractVerticle {

    private static final Logger LOGGER = LogManager.getLogger(YamlConfig.class);

    private static final String CONFIG_FOLDER = "configs";
    private static final String SERVER_CONFIG = "server";
    private static final String ACTIVE_CONFIG = "active";
    private static final String BOOTSTRAP_PATH = CONFIG_FOLDER + CommonConstants.HTTP_SLASH + "bootstrap.yml";

    /**
     * 
     * @MethodName: start
     * @Description: 将配置信息加载到内存
     * @author yuanzhenhui
     * @see io.vertx.core.AbstractVerticle#start()
     * @date 2023-04-13 04:29:42
     */
    @Override
    public void start() {
        // 第一次获取bootstrap文件的基本路径
        Buffer bootBfr = vertx.fileSystem().readFileBlocking(BOOTSTRAP_PATH);
        try {
            if (null != bootBfr) {

                // 读取bootstrap文件中的配置内容
                Map<?, ?> baseMap = (Map<?, ?>)new Yaml().load(bootBfr.toString());
                // 读取之后数据以Map<Object,Object>返回，这个时候需要转换成Map<String,Object>格式
                baseMap.entrySet().stream()
                    .forEach(entry -> YamlConstants.CONF_JSON.put(String.valueOf(entry.getKey()), entry.getValue()));

                // 获取bootstrap文件中有关当前环境的信息server.active这个跟springboot很相似
                String envStr = YamlConstants.CONF_JSON.getJsonObject(SERVER_CONFIG).getString(ACTIVE_CONFIG);
                // 根据配置环境名字找到对应目录下的所有文件
                vertx.fileSystem().readDir(CONFIG_FOLDER + CommonConstants.HTTP_SLASH + envStr, dirHeader -> {
                    if (dirHeader.succeeded()) {
                        // 获取到所有目录下的文件路径集合
                        List<String> fileList = dirHeader.result();
                        if (null != fileList && !fileList.isEmpty()) {
                            fileList.stream().forEach(pathName -> {
                                // 采用filesystem方式遍历这个路径集合并获取文件中的配置信息，获取方式跟bootstrap获取一致
                                Buffer pluginBfr = vertx.fileSystem().readFileBlocking(pathName);
                                if (null != pluginBfr) {
                                    Map<?, ?> pluginMap = (Map<?, ?>)new Yaml().load(pluginBfr.toString());
                                    pluginMap.entrySet().stream().forEach(entry -> YamlConstants.CONF_JSON
                                        .put(String.valueOf(entry.getKey()), entry.getValue()));
                                }
                            });
                        }
                    }
                });
            }
        } catch (Exception e) {
            LOGGER.error("func[YamlConfig.start] Exception [{} - {}]", new Object[] {e.getCause(), e.getMessage()});
        }
    }
}
