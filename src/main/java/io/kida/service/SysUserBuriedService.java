package io.kida.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.kida.components.utils.db.JOOQUtil;
import io.kida.components.utils.redis.RedisUtil;
import io.kida.components.utils.yaml.YamlUtil;
import io.kida.components.utils.yaml.annotations.PropLoader;
import io.kida.model.tables.daos.SysUserBuriedDao;
import io.kida.model.tables.pojos.SysUserBuried;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.json.JsonObject;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.RedisAPI;
import io.vertx.redis.client.Response;

public class SysUserBuriedService extends AbstractVerticle {

    private static final Logger LOGGER = LogManager.getLogger(SysUserBuriedService.class);

    // 每个批次执行行数
    @PropLoader(key = "redis.batch-num")
    private static int batchNum;

    private static SysUserBuriedDao subDao;
    private static RedisAPI redis;

    private List<String> paramList;
    private String blockNum = "0";

    @Override
    public void start() {
        YamlUtil.propLoadSetter(this);
        subDao = new SysUserBuriedDao(JOOQUtil.getInstance().getConfiguration(), vertx);

        // 创建redis客户端连接
        Redis.createClient(vertx, RedisUtil.getInstance().getConfiguration()).connect(onConnect -> {
            if (onConnect.succeeded()) {
                redis = RedisAPI.api(onConnect.result());
            }
        });
    }

    /**
     * 
     * @MethodName: cron2SaveRedisAccess
     * @Description: 定时保存redis数据
     * @author yuanzhenhui void
     * @date 2023-04-13 05:04:00
     */
    public void cron2SaveRedisAccess() {
        LOGGER.debug("func SysUserBuriedService.cron2SaveRedisAccess has begin!! ");
        paramList = new ArrayList<>();
        paramList.add(blockNum);
        paramList.add("COUNT");
        paramList.add(String.valueOf(batchNum));
        redis.scan(paramList, this::redisScanToGet);
    }

    /**
     * 
     * @MethodName: redisScanToGet
     * @Description: redis做扫描并获取数据
     * @author yuanzhenhui
     * @param scanResp
     *            void
     * @date 2023-04-13 05:04:16
     */
    private void redisScanToGet(AsyncResult<Response> scanResp) {
        if (scanResp.succeeded()) {
            // 获取块编码
            blockNum = scanResp.result().get(0).toString();
            // 获取key数据集
            Response keyArrResp = scanResp.result().get(1);
            if (null != keyArrResp) {
                paramList = keyArrResp.stream().map(Response::toString).collect(Collectors.toList());
                // 通过mget同时获取多个key
                redis.mget(paramList, this::databaseToInsert);
            }
        } else {
            LOGGER.error("func[SysUserBuriedService.redisScanToGet] Exception [{} - {}]",
                new Object[] {scanResp.cause(), scanResp.result()});
        }
    }

    /**
     * 
     * @MethodName: databaseToInsert
     * @Description: 数据库进行插入
     * @author yuanzhenhui
     * @param mgetResp
     *            void
     * @date 2022-08-10 06:21:09
     */
    private void databaseToInsert(AsyncResult<Response> mgetResp) {
        // 异步获取成功后
        if (mgetResp.succeeded()) {
            Response mgetArrResp = mgetResp.result();
            if (null != mgetArrResp) {
                List<SysUserBuried> puaList = mgetArrResp.stream()
                    .map(mget -> new SysUserBuried(new JsonObject(mget.toString()))).collect(Collectors.toList());
                // 将获取的集合进行批量插入数据库
                if (null != puaList && !puaList.isEmpty()) {
                    subDao.insert(puaList, true).whenCompleteAsync((opt, e) -> {
                        if (null == e) {
                            redis.unlink(paramList, this::redisUnlinkDelete);
                        } else {
                            LOGGER.error(
                                "func[SysUserBuriedService.databaseToInsert mysql inserted] Exception [{} - {}] stackTrace[{}] ",
                                new Object[] {e.getCause(), e.getMessage(), Arrays.deepToString(e.getStackTrace())});
                        }
                    });
                }
            }
        }
    }

    /**
     * 
     * @MethodName: redisUnlinkDelete
     * @Description: redis服务进行unlink删除
     * @author yuanzhenhui
     * @param unlinkResp
     *            void
     * @date 2022-08-10 06:19:07
     */
    private void redisUnlinkDelete(AsyncResult<Response> unlinkResp) {
        if (unlinkResp.failed()) {
            LOGGER.error("func[SysUserBuriedService.redisUnlinkDelete redis unlink key] Exception [{} - {}]",
                new Object[] {unlinkResp.cause(), unlinkResp.result()});
        } else {
            LOGGER.debug("func SysUserBuriedService.redisUnlinkDelete has end!! ");
        }
    }
}
