package io.kida.components.configs;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.callback.BootstrapCallback;
import io.kida.components.constants.CommonConstants;
import io.kida.components.utils.ref.ReflectUtil;
import io.kida.components.utils.yaml.YamlUtil;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class BootstrapConfig {

    private static final Logger LOGGER = LogManager.getLogger(BootstrapConfig.class);

    // 线程配置参数
    private static final String THREAD_WORKER = "thread.worker";
    private static final String THREAD_INIT_POOL_SIZE = "thread.init-pool-size";
    private static final String THREAD_EVENTLOOP_POOL_SIZE = "thread.eventloop-pool-size";
    private static final String THREAD_DEPLOY_INIT = "thread.deploy.init";
    private static final String THREAD_DEPLOY_MAX_SIZE = "thread.deploy.max-size";
    private static final String THREAD_DEPLOY_POOL_NAME = "thread.deploy.pool-name";
    private static final String VTX_VERTICLE = "Verticle";

    /**
     * 
     * @MethodName: setupAndDeploy
     * @Description: 启动部署
     * @author yuanzhenhui
     * @param callback
     *            void
     * @date 2023-04-13 04:22:29
     */
    public static void setupAndDeploy(BootstrapCallback callback) {
        // 先部署yml配置，为了能够拿到配置文件
        LOGGER.debug("In order to get the startup configuration first initialize the YamlConfig class...");
        Vertx.vertx().deployVerticle(new YamlConfig(), yaml -> {
            // 第一次配置获取成功
            if (yaml.succeeded()) {
                setupDeploy(Vertx.vertx(setupOptions()), callback);
            } else {
                LOGGER.error("func[BootstrapConfig.setupAndDeploy] Main method error Exception [{} - {}]",
                    new Object[] {yaml.cause(), yaml.cause().fillInStackTrace()});
            }
        });
    }

    /**
     * 
     * @MethodName: setupOptions
     * @Description: 线程池配置
     * @author yuanzhenhui
     * @return VertxOptions
     * @date 2023-04-13 04:23:17
     */
    private static VertxOptions setupOptions() {
        VertxOptions options = new VertxOptions();
        options.setWorkerPoolSize(YamlUtil.getIntegerValue(THREAD_WORKER));
        options.setInternalBlockingPoolSize(YamlUtil.getIntegerValue(THREAD_INIT_POOL_SIZE));
        options.setEventLoopPoolSize(YamlUtil.getIntegerValue(THREAD_EVENTLOOP_POOL_SIZE));
        return options;
    }

    /**
     * 
     * @MethodName: setupDeploy
     * @Description: 部署配置
     * @author yuanzhenhui
     * @param vtx
     * @param callback
     *            void
     * @date 2023-04-13 04:23:35
     */
    private static void setupDeploy(Vertx vtx, BootstrapCallback callback) {
        DeploymentOptions deploymentOptions = new DeploymentOptions();
        deploymentOptions.setWorker(true);
        deploymentOptions.setInstances(YamlUtil.getIntegerValue(THREAD_DEPLOY_INIT));
        deploymentOptions.setWorkerPoolSize(YamlUtil.getIntegerValue(THREAD_DEPLOY_MAX_SIZE));
        deploymentOptions.setWorkerPoolName(YamlUtil.getStringValue(THREAD_DEPLOY_POOL_NAME));

        // 在重新生成Vertx实例之后需要重新部署所有Verticle类，于是第二次获取YamlConfig类
        if (null != vtx) {
            try {
                List<Class<Verticle>> clazzSet = ReflectUtil.getVerticleClasses(CommonConstants.ROOT_LEVEL, true);
                List<CompletableFuture<Void>> futures =
                    clazzSet.stream().filter(clazz -> !clazz.getSimpleName().contains(VTX_VERTICLE))
                        .map(clazz -> CompletableFuture.runAsync(() -> vtx.deployVerticle(clazz, deploymentOptions)))
                        .collect(Collectors.toList());
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

                // 确保在vertx实例生成后再执行
                callback.afterBootup(vtx);
            } catch (ClassNotFoundException | IOException e) {
                LOGGER.error("func[BootstrapConfig.setupDeploy] Exception [{} - {}] stackTrace[{}] ",
                    new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
            }
        }
    }
}
