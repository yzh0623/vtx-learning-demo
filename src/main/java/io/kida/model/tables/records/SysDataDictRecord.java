/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.kida.model.tables.SysDataDict;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 数据字典表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysDataDictRecord extends UpdatableRecordImpl<SysDataDictRecord> implements VertxPojo, Record4<String, String, String, String> {

    private static final long serialVersionUID = 1759469105;

    /**
     * Setter for <code>tools.sys_data_dict.did</code>. 字典id
     */
    public SysDataDictRecord setDid(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_data_dict.did</code>. 字典id
     */
    public String getDid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>tools.sys_data_dict.parent_id</code>. 父id
     */
    public SysDataDictRecord setParentId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_data_dict.parent_id</code>. 父id
     */
    public String getParentId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tools.sys_data_dict.dcode</code>. 字典编码
     */
    public SysDataDictRecord setDcode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_data_dict.dcode</code>. 字典编码
     */
    public String getDcode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tools.sys_data_dict.dname</code>. 字典名称
     */
    public SysDataDictRecord setDname(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_data_dict.dname</code>. 字典名称
     */
    public String getDname() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SysDataDict.SYS_DATA_DICT.DID;
    }

    @Override
    public Field<String> field2() {
        return SysDataDict.SYS_DATA_DICT.PARENT_ID;
    }

    @Override
    public Field<String> field3() {
        return SysDataDict.SYS_DATA_DICT.DCODE;
    }

    @Override
    public Field<String> field4() {
        return SysDataDict.SYS_DATA_DICT.DNAME;
    }

    @Override
    public String component1() {
        return getDid();
    }

    @Override
    public String component2() {
        return getParentId();
    }

    @Override
    public String component3() {
        return getDcode();
    }

    @Override
    public String component4() {
        return getDname();
    }

    @Override
    public String value1() {
        return getDid();
    }

    @Override
    public String value2() {
        return getParentId();
    }

    @Override
    public String value3() {
        return getDcode();
    }

    @Override
    public String value4() {
        return getDname();
    }

    @Override
    public SysDataDictRecord value1(String value) {
        setDid(value);
        return this;
    }

    @Override
    public SysDataDictRecord value2(String value) {
        setParentId(value);
        return this;
    }

    @Override
    public SysDataDictRecord value3(String value) {
        setDcode(value);
        return this;
    }

    @Override
    public SysDataDictRecord value4(String value) {
        setDname(value);
        return this;
    }

    @Override
    public SysDataDictRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysDataDictRecord
     */
    public SysDataDictRecord() {
        super(SysDataDict.SYS_DATA_DICT);
    }

    /**
     * Create a detached, initialised SysDataDictRecord
     */
    public SysDataDictRecord(String did, String parentId, String dcode, String dname) {
        super(SysDataDict.SYS_DATA_DICT);

        set(0, did);
        set(1, parentId);
        set(2, dcode);
        set(3, dname);
    }

    public SysDataDictRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysDataDictRecord fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setDid(json.getString("did"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("did","java.lang.String",e);
        }
        try {
            setParentId(json.getString("parent_id"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("parent_id","java.lang.String",e);
        }
        try {
            setDcode(json.getString("dcode"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("dcode","java.lang.String",e);
        }
        try {
            setDname(json.getString("dname"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("dname","java.lang.String",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("did",getDid());
        json.put("parent_id",getParentId());
        json.put("dcode",getDcode());
        json.put("dname",getDname());
        return json;
    }

}