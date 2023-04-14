package io.kida;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.configs.BootstrapConfig;
import io.kida.components.constants.CommonConstants;
import io.kida.service.SysUserBuriedService;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        BootstrapConfig.setupAndDeploy(vtx -> {
            LOGGER.info(" --------------- 定时器开始执行 --------------- ");
            SysUserBuriedService userAccess = new SysUserBuriedService();
            vtx.setPeriodic(CommonConstants.CRON, id -> userAccess.cron2SaveRedisAccess());
        });
    }

}
