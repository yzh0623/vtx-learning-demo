package io.kida.components.constants;

import io.kida.components.utils.yaml.YamlUtil;

public class CommonConstants {

    // 类扫描路径
    public static final String ROOT_LEVEL = "io.kida";

    // 定时器执行周期
    public static final Integer CRON = YamlUtil.getIntegerValue("server.cron");

    // 接口传输数据类型
    public static final String HTTP_APPLICATION_JSON = "application/json";
    public static final String HTTP_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_SLASH = "/";

}
