package io.kida.router;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.constants.CommonConstants;
import io.kida.components.routers.RouterSet;
import io.kida.components.utils.http.IPUtil;
import io.kida.components.utils.http.RespMsg;
import io.kida.components.utils.redis.RedisUtil;
import io.kida.components.utils.ref.ReflectUtil;
import io.kida.components.utils.yaml.YamlUtil;
import io.kida.components.utils.yaml.annotations.PropLoader;
import io.kida.model.tables.pojos.SysUserBuried;
import io.netty.util.internal.StringUtil;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.RedisAPI;

public class SysUserBuriedRouter extends AbstractVerticle implements RouterSet {

    private static final Logger LOGGER = LogManager.getLogger(SysUserBuriedRouter.class);

    // 系统上下文名称
    @PropLoader(key = "server.context")
    private static String context;

    // 初始化redis客户端
    private static RedisAPI redis;

    @Override
    public void start() {
        YamlUtil.propLoadSetter(this);

        // 创建redis客户端连接
        Redis.createClient(vertx, RedisUtil.getInstance().getConfiguration()).connect(onConnect -> {
            if (onConnect.succeeded()) {
                redis = RedisAPI.api(onConnect.result());
            }
        });
    }

    /**
     * 
     * @MethodName: sendBuriedPointInfo
     * @Description: restful处理类
     * @author yuanzhenhui
     * @param ctx
     *            void
     * @date 2023-04-13 05:02:52
     */
    public void sendBuriedPointInfo(RoutingContext ctx) {
        String jsonStr = ctx.getBodyAsString();
        if (!StringUtil.isNullOrEmpty(jsonStr)) {
            SysUserBuried puav = ReflectUtil.convertJson2Pojo(jsonStr, SysUserBuried.class);

            // 生成uuid
            String uuid = UUID.randomUUID().toString();
            puav.setId(uuid);

            // 获取ip
            puav.setIp(IPUtil.getIpAddr(ctx));

            // 获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            puav.setAccessDate(sdf.format(new Date()));

            redis.setnx(uuid, puav.toJson().encode(), setnxResp -> {
                if (setnxResp.failed()) {
                    LOGGER.error("func[SysUserBuriedRouter.sendBuriedPointInfo] Exception [{} - {}]",
                        new Object[] {setnxResp.cause(), setnxResp.result()});
                }
            });
        }
        HttpServerResponse hsr =
            ctx.response().putHeader(CommonConstants.HTTP_CONTENT_TYPE, CommonConstants.HTTP_APPLICATION_JSON);
        hsr.end(Json.encode(new RespMsg(1, "Message received")));
    }

    /**
     * 
     * @MethodName: router4Restful
     * @Description: 实现路由转发
     * @author yuanzhenhui
     * @param router
     * @see io.kida.components.routers.RouterSet#router4Restful(io.vertx.ext.web.Router)
     * @date 2023-04-13 05:03:12
     */
    @Override
    public void router4Restful(Router router) {
        router.post(CommonConstants.HTTP_SLASH + context + CommonConstants.HTTP_SLASH + "sendBuriedPointInfo")
            .handler(this::sendBuriedPointInfo);
    }

}
