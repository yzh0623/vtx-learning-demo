package io.kida.components.callback;

import io.vertx.core.Vertx;

@FunctionalInterface
public interface BootstrapCallback {

    /**
     * 
     * @MethodName: afterBootup
     * @Description: 顺利启动后执行回调
     * @author yuanzhenhui
     * @param vtx
     *            void
     * @date 2023-04-13 04:21:40
     */
    void afterBootup(Vertx vtx);
}
