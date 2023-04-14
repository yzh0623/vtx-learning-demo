package io.kida.components.utils.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class IPUtil {

    private static final Logger LOGGER = LogManager.getLogger(IPUtil.class);

    private static final String X_FORWARDED_FOR = "x-forwarded-for";
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String LOCALHOST_IPV4 = "127.0.0.1";
    private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:1";
    private static final String UNKNOWN = "unknown";

    /**
     * 
     * @MethodName: getIpAddr
     * @Description: 获取客户端ip地址
     * @author yuanzhenhui
     * @param ctx
     * @return String
     * @date 2023-04-13 04:32:23
     */
    public static String getIpAddr(RoutingContext ctx) {
        String ipAddress = null;
        try {
            HttpServerRequest request = ctx.request();
            ipAddress = request.getHeader(X_FORWARDED_FOR);
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(PROXY_CLIENT_IP);
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(WL_PROXY_CLIENT_IP);
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.remoteAddress().host();

                // 这里主要是获取本机的ip,可有可无
                if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.endsWith(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                }
            }

            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        } catch (UnknownHostException e) {
            LOGGER.error("func[IPUtil.getIpAddr] Exception [{} - {}]", new Object[] {e.getCause(), e.getMessage()});
        }
        return ipAddress;
    }

}
