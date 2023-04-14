package io.kida.components.configs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.constants.CommonConstants;
import io.kida.components.routers.RouterSet;
import io.kida.components.utils.ref.ReflectUtil;
import io.kida.components.utils.yaml.YamlUtil;
import io.kida.components.utils.yaml.annotations.PropLoader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;

public class RouterConfig extends AbstractVerticle {

    private static final Logger LOGGER = LogManager.getLogger(RouterConfig.class);

    @PropLoader(key = "server.port")
    private int port;
    @PropLoader(key = "server.http.header")
    private List<String> httpHeader;

    private Set<HttpMethod> hmSet = new HashSet<>();

    @PostConstruct
    public void setupHttpMethod() {
        hmSet.add(HttpMethod.GET);
        hmSet.add(HttpMethod.POST);
        hmSet.add(HttpMethod.DELETE);
        hmSet.add(HttpMethod.PATCH);
        hmSet.add(HttpMethod.OPTIONS);
        hmSet.add(HttpMethod.PUT);
    }

    /**
     * 
     * @MethodName: start
     * @Description: 配置类启动
     * @author yuanzhenhui
     * @throws Exception
     * @see io.vertx.core.AbstractVerticle#start()
     * @date 2023-04-13 04:26:30
     */
    @Override
    public void start() throws Exception {

        YamlUtil.propLoadSetter(this);

        Router router = Router.router(vertx);
        createInterface(router);
        createServer(router);
    }

    /**
     * 
     * @MethodName: createInterface
     * @Description: 创建接口
     * @author yuanzhenhui
     * @param router
     *            void
     * @date 2023-04-13 04:26:44
     */
    private void createInterface(Router router) {
        router.route().handler(BodyHandler.create());

        CorsHandler cors = CorsHandler.create("*");
        cors.allowedHeaders(setupAllowedHeaders());
        cors.allowedMethods(hmSet);
        router.route().handler(cors);
        router.route().consumes(CommonConstants.HTTP_APPLICATION_JSON);
        router.route().produces(CommonConstants.HTTP_APPLICATION_JSON);

        CopyOnWriteArraySet<Class<?>> clazzSet = ReflectUtil.getClasses(CommonConstants.ROOT_LEVEL, true);
        clazzSet.parallelStream().forEach(clazz -> {
            Set<Class<?>> interfaces = new HashSet<>(Arrays.asList(clazz.getInterfaces()));
            if (interfaces.contains(RouterSet.class)) {
                try {
                    RouterSet rs = (RouterSet)clazz.newInstance();
                    rs.router4Restful(router);
                } catch (Exception e) {
                    LOGGER.error("func[RouterConfig.createInterface] Exception [{} - {}] stackTrace[{}] ",
                        new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
                }
            }
        });
    }

    /**
     * 
     * @MethodName: createServer
     * @Description: 创建服务器接口
     * @author yuanzhenhui
     * @param router
     *            void
     * @date 2023-04-13 04:28:29
     */
    private void createServer(Router router) {
        vertx.createHttpServer(new HttpServerOptions().setSsl(false)).requestHandler(router::accept).listen(port,
            asyncResult -> {
                if (asyncResult.failed()) {
                    LOGGER.error("func[RouterConfig.createServer] Exception [{} - {}]",
                        new Object[] {asyncResult.cause(), asyncResult.result()});
                } else {
                    LOGGER.info(" ----- All RESTful interfaces are successfully registered! ----- ");
                }
            });
    }

    /**
     * 
     * @MethodName: setupAllowedHeaders
     * @Description: 允许访问的头属性
     * @author yuanzhenhui
     * @return Set<String>
     * @date 2023-04-13 04:28:45
     */
    private Set<String> setupAllowedHeaders() {
        Set<String> allowedHeaders = new HashSet<>();
        if (httpHeader != null) {
            allowedHeaders.addAll(httpHeader);
        }
        return allowedHeaders;
    }

}
