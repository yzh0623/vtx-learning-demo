package io.kida;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.kida.model.tables.pojos.SysUserBuried;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.json.Json;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;

@RunWith(VertxUnitRunner.class)
public class SysUserBuriedTest {

    private static final Logger logger = LogManager.getLogger(SysUserBuriedTest.class);

    private Vertx vertx;
    private HttpClient client;
    private SysUserBuried sub;

    private static final int port = 8091;

    private String[] ssxtArr = {"abc", "def", "ghi", "jkl", "mno"};
    private String ipPrefix = "192.168.100.";
    private String urlPrefix = "https://www.baidu.com/";
    private String[] typeArr = {"pc", "weapp"};

    private static int counter = 0;

    @Before
    public void setup() {
        vertx = Vertx.vertx();

        HttpClientOptions options = new HttpClientOptions().setKeepAlive(true).setConnectTimeout(1000)
            .setIdleTimeout(1000).setMaxWaitQueueSize(5000).setMaxPoolSize(10000);
        client = vertx.createHttpClient(options);
    }

    @Test
    public void testApplication(TestContext context) {
        routerTest();
    }

    @SuppressWarnings("deprecation")
    public void routerTest() {
        int i = 0;
        for (; i < 50; i++) {
            sub = new SysUserBuried();
            sub.setSsxt(ssxtArr[new Random().nextInt(ssxtArr.length)]);
            sub.setIp(ipPrefix + new Random().nextInt(250));
            sub.setType(typeArr[new Random().nextInt(typeArr.length)]);
            sub.setUid(Long.valueOf(String.valueOf(new Random().nextInt(10))));
            sub.setUri(urlPrefix + new Random().nextInt(300));
            client.post(port, "127.0.0.1", "/vtx/sendBuriedPointInfo", resp -> {
                logger.info(" ------- sendAccess complete,status code " + resp.statusCode() + "------- ");
                counter++;
            }).exceptionHandler(Throwable::printStackTrace).putHeader("Content-Type", "application/json")
                .setChunked(true).end(Json.encode(sub));

        }

        while (true) {
            if (counter == i) {
                break;
            }
        }
    }

}
