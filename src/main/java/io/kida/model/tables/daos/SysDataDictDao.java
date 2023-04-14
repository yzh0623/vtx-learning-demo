/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractVertxDAO;
import io.kida.model.tables.SysDataDict;
import io.kida.model.tables.records.SysDataDictRecord;

import java.util.Collection;

import org.jooq.Configuration;
import org.jooq.Record2;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO;
import io.github.jklingsporn.vertx.jooq.completablefuture.jdbc.JDBCCompletableFutureQueryExecutor;
/**
 * 数据字典表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysDataDictDao extends AbstractVertxDAO<SysDataDictRecord, io.kida.model.tables.pojos.SysDataDict, Record2<String, String>, CompletableFuture<List<io.kida.model.tables.pojos.SysDataDict>>, CompletableFuture<io.kida.model.tables.pojos.SysDataDict>, CompletableFuture<Integer>, CompletableFuture<Record2<String, String>>> implements io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO<SysDataDictRecord,io.kida.model.tables.pojos.SysDataDict,Record2<String, String>> {

    /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
    public SysDataDictDao(Configuration configuration, io.vertx.core.Vertx vertx) {
        super(SysDataDict.SYS_DATA_DICT, io.kida.model.tables.pojos.SysDataDict.class, new JDBCCompletableFutureQueryExecutor<SysDataDictRecord,io.kida.model.tables.pojos.SysDataDict,Record2<String, String>>(configuration,io.kida.model.tables.pojos.SysDataDict.class,vertx));
    }

    @Override
    protected Record2<String, String> getId(io.kida.model.tables.pojos.SysDataDict object) {
        return compositeKeyRecord(object.getDid(), object.getParentId());
    }

    /**
     * Find records that have <code>parent_id IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysDataDict>> findManyByParentId(Collection<String> values) {
        return findManyByCondition(SysDataDict.SYS_DATA_DICT.PARENT_ID.in(values));
    }

    /**
     * Find records that have <code>dcode IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysDataDict>> findManyByDcode(Collection<String> values) {
        return findManyByCondition(SysDataDict.SYS_DATA_DICT.DCODE.in(values));
    }

    /**
     * Find records that have <code>dname IN (values)</code> asynchronously
     */
    public CompletableFuture<List<io.kida.model.tables.pojos.SysDataDict>> findManyByDname(Collection<String> values) {
        return findManyByCondition(SysDataDict.SYS_DATA_DICT.DNAME.in(values));
    }

    @Override
    public JDBCCompletableFutureQueryExecutor<SysDataDictRecord,io.kida.model.tables.pojos.SysDataDict,Record2<String, String>> queryExecutor(){
        return (JDBCCompletableFutureQueryExecutor<SysDataDictRecord,io.kida.model.tables.pojos.SysDataDict,Record2<String, String>>) super.queryExecutor();
    }
}