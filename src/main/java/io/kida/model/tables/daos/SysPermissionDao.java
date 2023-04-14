/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractVertxDAO;
import io.kida.model.tables.SysPermission;
import io.kida.model.tables.records.SysPermissionRecord;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO;
import io.github.jklingsporn.vertx.jooq.completablefuture.jdbc.JDBCCompletableFutureQueryExecutor;
/**
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysPermissionDao extends AbstractVertxDAO<SysPermissionRecord, io.kida.model.tables.pojos.SysPermission, Long, CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>>, CompletableFuture<io.kida.model.tables.pojos.SysPermission>, CompletableFuture<Integer>, CompletableFuture<Long>> implements io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO<SysPermissionRecord,io.kida.model.tables.pojos.SysPermission,Long> {

    /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
    public SysPermissionDao(Configuration configuration, io.vertx.core.Vertx vertx) {
        super(SysPermission.SYS_PERMISSION, io.kida.model.tables.pojos.SysPermission.class, new JDBCCompletableFutureQueryExecutor<SysPermissionRecord,io.kida.model.tables.pojos.SysPermission,Long>(configuration,io.kida.model.tables.pojos.SysPermission.class,vertx));
    }

    @Override
    protected Long getId(io.kida.model.tables.pojos.SysPermission object) {
        return object.getPermissionId();
    }

    /**
     * Find records that have <code>P_PERMISSION_ID IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>> findManyByPPermissionId(Collection<Long> values) {
        return findManyByCondition(SysPermission.SYS_PERMISSION.P_PERMISSION_ID.in(values));
    }

    /**
     * Find records that have <code>PERMISSION_NAME IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>> findManyByPermissionName(Collection<String> values) {
        return findManyByCondition(SysPermission.SYS_PERMISSION.PERMISSION_NAME.in(values));
    }

    /**
     * Find records that have <code>PERMISSION_TYPE IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>> findManyByPermissionType(Collection<Integer> values) {
        return findManyByCondition(SysPermission.SYS_PERMISSION.PERMISSION_TYPE.in(values));
    }

    /**
     * Find records that have <code>SHOW_FLAG IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>> findManyByShowFlag(Collection<Integer> values) {
        return findManyByCondition(SysPermission.SYS_PERMISSION.SHOW_FLAG.in(values));
    }

    /**
     * Find records that have <code>REMARK IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysPermission>> findManyByRemark(Collection<String> values) {
        return findManyByCondition(SysPermission.SYS_PERMISSION.REMARK.in(values));
    }

    @Override
    public JDBCCompletableFutureQueryExecutor<SysPermissionRecord,io.kida.model.tables.pojos.SysPermission,Long> queryExecutor(){
        return (JDBCCompletableFutureQueryExecutor<SysPermissionRecord,io.kida.model.tables.pojos.SysPermission,Long>) super.queryExecutor();
    }
}
