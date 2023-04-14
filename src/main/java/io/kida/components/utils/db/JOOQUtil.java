package io.kida.components.utils.db;

import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.kida.components.constants.CommonConstants;
import io.kida.components.utils.yaml.YamlUtil;

public class JOOQUtil {

    private static final String HOST = YamlUtil.getStringValue("datasource.host");
    private static final String DATABASE = YamlUtil.getStringValue("datasource.database-name");
    private static final String USE_UNICODE = YamlUtil.getStringValue("datasource.use-unicode");
    private static final String CHARACTER_ENCODING = YamlUtil.getStringValue("datasource.character-encoding");
    private static final String SERVER_TIMEZONE = YamlUtil.getStringValue("datasource.server-timezone");
    private static final String URL_HEAD = YamlUtil.getStringValue("datasource.url-head");
    private static final String DRIVER_CLASS_NAME = YamlUtil.getStringValue("datasource.driver-class-name");
    private static final String PASSWORD = YamlUtil.getStringValue("datasource.password");
    private static final String USERNAME = YamlUtil.getStringValue("datasource.username");
    private static final String CONNECTION_TEST_QUERY =
        YamlUtil.getStringValue("datasource.hikari.connection-test-query");
    private static final String POOL_NAME = YamlUtil.getStringValue("datasource.hikari.pool-name");

    private static final int MINIMUM_IDLE = YamlUtil.getIntegerValue("datasource.hikari.minimum-idle");
    private static final int PORT = YamlUtil.getIntegerValue("datasource.port");
    private static final int MAXIMUM_POOL_SIZE = YamlUtil.getIntegerValue("datasource.hikari.maximum-pool-size");
    private static final int IDLE_TIMEOUT = YamlUtil.getIntegerValue("datasource.hikari.idle-timeout");
    private static final int CONNECTION_TIMEOUT = YamlUtil.getIntegerValue("datasource.hikari.connection-timeout");
    private static final int PREP_STMT_CACHE_SIZE = YamlUtil.getIntegerValue("datasource.hikari.prep-stmt-cache-size");
    private static final int PREP_STMT_CACHE_SQL_LIMIT =
        YamlUtil.getIntegerValue("datasource.hikari.prep-stmt-cache-sql-limit");

    private static final boolean SSL = YamlUtil.getBooleanValue("datasource.ssl-enable");
    private static final boolean IS_AUTO_COMMIT = YamlUtil.getBooleanValue("datasource.hikari.is-auto-commit");
    private static final boolean ALLOW_POOL_SUSPENSION =
        YamlUtil.getBooleanValue("datasource.hikari.allow-pool-suspension");
    private static final boolean CACHE_PREP_STMTS = YamlUtil.getBooleanValue("datasource.hikari.cache-prep-stmts");
    private static final boolean USE_SERVER_PREP_STMTS =
        YamlUtil.getBooleanValue("datasource.hikari.use-server-prep-stmts");
    private static final boolean USE_LOCAL_SESSION_STATE =
        YamlUtil.getBooleanValue("datasource.hikari.use-local-session-state");
    private static final boolean REWRITE_BATCHED_STATEMENTS =
        YamlUtil.getBooleanValue("datasource.hikari.rewrite-batched-statements");
    private static final boolean CACHE_RESULT_SET_METADATA =
        YamlUtil.getBooleanValue("datasource.hikari.cache-result-set-metadata");
    private static final boolean CACHE_SERVER_CONFIGURATION =
        YamlUtil.getBooleanValue("datasource.hikari.cache-server-configuration");
    private static final boolean ELIDE_SET_AUTO_COMMITS =
        YamlUtil.getBooleanValue("datasource.hikari.elide-set-auto-commits");
    private static final boolean MAINTAIN_TIME_STATS =
        YamlUtil.getBooleanValue("datasource.hikari.maintain-time-stats");
    private static final boolean ALLOW_PUBLIC_KEY_RETRIEVAL =
        YamlUtil.getBooleanValue("datasource.hikari.allow-public-key-retrieval");

    private static final String URL =
        URL_HEAD + "//" + HOST + ":" + PORT + CommonConstants.HTTP_SLASH + DATABASE + "?useUnicode=" + USE_UNICODE
            + "&characterEncoding=" + CHARACTER_ENCODING + "&useSSL=" + SSL + "&serverTimezone=" + SERVER_TIMEZONE;

    private JOOQUtil() {}

    /**
     * 
     * @MethodName: getConfiguration
     * @Description: 获取配置实例并设置jooq当前对应数据库
     * @author yuanzhenhui
     * @return Configuration
     * @date 2023-04-13 04:31:36
     */
    public Configuration getConfiguration() {
        Configuration configuration = new DefaultConfiguration();
        configuration.set(SQLDialect.MYSQL);
        configuration.set(getHikariCPDataProvider());
        return configuration;
    }

    private static class SingletonInstance {
        private static final JOOQUtil INSTANCE = new JOOQUtil();
        private static final ConnectionProvider provider = new DataSourceConnectionProvider(getHikariCPDataSource());
    }

    public static JOOQUtil getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static final ConnectionProvider getHikariCPDataProvider() {
        return SingletonInstance.provider;
    }

    /**
     * 
     * @MethodName: getHikariCPDataSource
     * @Description: 数据库连接池配置信息
     * @author yuanzhenhui
     * @return DataSource
     * @date 2023-04-13 04:31:48
     */
    private static DataSource getHikariCPDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setDriverClassName(DRIVER_CLASS_NAME);
        hikariConfig.setUsername(USERNAME);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setAutoCommit(IS_AUTO_COMMIT);
        hikariConfig.setAllowPoolSuspension(ALLOW_POOL_SUSPENSION);
        hikariConfig.setConnectionTestQuery(CONNECTION_TEST_QUERY);
        hikariConfig.setPoolName(POOL_NAME);
        hikariConfig.setMinimumIdle(MINIMUM_IDLE);
        hikariConfig.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
        hikariConfig.setIdleTimeout(IDLE_TIMEOUT);
        hikariConfig.setConnectionTimeout(CONNECTION_TIMEOUT);
        hikariConfig.addDataSourceProperty("cachePrepStmts", CACHE_PREP_STMTS);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", PREP_STMT_CACHE_SIZE);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", PREP_STMT_CACHE_SQL_LIMIT);
        hikariConfig.addDataSourceProperty("useServerPrepStmts", USE_SERVER_PREP_STMTS);
        hikariConfig.addDataSourceProperty("useLocalSessionState", USE_LOCAL_SESSION_STATE);
        hikariConfig.addDataSourceProperty("useSsl", SSL);
        hikariConfig.addDataSourceProperty("serverTimezone", SERVER_TIMEZONE);
        hikariConfig.addDataSourceProperty("rewriteBatchedStatements", REWRITE_BATCHED_STATEMENTS);
        hikariConfig.addDataSourceProperty("cacheResultSetMetadata", CACHE_RESULT_SET_METADATA);
        hikariConfig.addDataSourceProperty("cacheServerConfiguration", CACHE_SERVER_CONFIGURATION);
        hikariConfig.addDataSourceProperty("elideSetAutoCommits", ELIDE_SET_AUTO_COMMITS);
        hikariConfig.addDataSourceProperty("maintainTimeStats", MAINTAIN_TIME_STATS);
        hikariConfig.addDataSourceProperty("allowPublicKeyRetrieval", ALLOW_PUBLIC_KEY_RETRIEVAL);
        return new HikariDataSource(hikariConfig);
    }

}
