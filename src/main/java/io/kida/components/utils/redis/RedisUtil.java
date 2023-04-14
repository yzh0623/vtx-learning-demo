package io.kida.components.utils.redis;

import io.kida.components.utils.yaml.YamlUtil;
import io.vertx.redis.client.RedisOptions;

public class RedisUtil {

    // 连接池最大大小
    private static final int MAX_POOL_SIZE = YamlUtil.getIntegerValue("redis.max-pool-size");
    // 连接池最大等待
    private static final int MAX_POOL_WAITING = YamlUtil.getIntegerValue("redis.max-pool-waiting");
    // 连接池超时
    private static final int POOL_RECYCLE_TIMEOUT = YamlUtil.getIntegerValue("redis.pool-recycle-timeout");
    // 最大等待用户
    private static final int MAX_WAITING_HANDLERS = YamlUtil.getIntegerValue("redis.max-waiting-handlers");
    // 连接字符串
    private static final String CONNECTION_STRING = YamlUtil.getStringValue("redis.connection-string");

    private RedisUtil() {}

    private static class SingletonInstance {
        private static final RedisUtil INSTANCE = new RedisUtil();
    }

    public static RedisUtil getInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 
     * @MethodName: getConfiguration
     * @Description: redis配置
     * @author yuanzhenhui
     * @return RedisOptions
     * @date 2023-04-13 04:32:48
     */
    public RedisOptions getConfiguration() {
        RedisOptions options = new RedisOptions();
        options.setMaxPoolSize(MAX_POOL_SIZE);
        options.setMaxPoolWaiting(MAX_POOL_WAITING);
        options.setConnectionString(CONNECTION_STRING);
        options.setPoolRecycleTimeout(POOL_RECYCLE_TIMEOUT);
        options.setMaxWaitingHandlers(MAX_WAITING_HANDLERS);
        return options;
    }

}
