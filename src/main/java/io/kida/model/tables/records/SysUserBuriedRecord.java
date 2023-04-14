/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.kida.model.tables.SysUserBuried;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户信息埋点表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUserBuriedRecord extends UpdatableRecordImpl<SysUserBuriedRecord> implements VertxPojo, Record12<String, String, String, String, String, String, String, String, Long, String, String, Long> {

    private static final long serialVersionUID = 808010547;

    /**
     * Setter for <code>tools.sys_user_buried.ID</code>. 主键UUID
     */
    public SysUserBuriedRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.ID</code>. 主键UUID
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>tools.sys_user_buried.IP</code>. IP地址
     */
    public SysUserBuriedRecord setIp(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.IP</code>. IP地址
     */
    public String getIp() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tools.sys_user_buried.URI</code>. 访问地址
     */
    public SysUserBuriedRecord setUri(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.URI</code>. 访问地址
     */
    public String getUri() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tools.sys_user_buried.SYS_CODE</code>. 系统编码（例如：abc）
     */
    public SysUserBuriedRecord setSysCode(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.SYS_CODE</code>. 系统编码（例如：abc）
     */
    public String getSysCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tools.sys_user_buried.SSXT</code>. 模块（后续用于统计）
     */
    public SysUserBuriedRecord setSsxt(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.SSXT</code>. 模块（后续用于统计）
     */
    public String getSsxt() {
        return (String) get(4);
    }

    /**
     * Setter for <code>tools.sys_user_buried.BUZZ_ID</code>. 业务id
     */
    public SysUserBuriedRecord setBuzzId(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.BUZZ_ID</code>. 业务id
     */
    public String getBuzzId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tools.sys_user_buried.ACCESS_DATE</code>. 访问时间
     */
    public SysUserBuriedRecord setAccessDate(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.ACCESS_DATE</code>. 访问时间
     */
    public String getAccessDate() {
        return (String) get(6);
    }

    /**
     * Setter for <code>tools.sys_user_buried.TYPE</code>. 访问端口：pc\wechat\app
     */
    public SysUserBuriedRecord setType(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.TYPE</code>. 访问端口：pc\wechat\app
     */
    public String getType() {
        return (String) get(7);
    }

    /**
     * Setter for <code>tools.sys_user_buried.DURATION_TIME</code>. 持续时间（ms）
     */
    public SysUserBuriedRecord setDurationTime(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.DURATION_TIME</code>. 持续时间（ms）
     */
    public Long getDurationTime() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>tools.sys_user_buried.OPER_TYPE</code>. 操作类型：view（浏览）、click（操作）
     */
    public SysUserBuriedRecord setOperType(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.OPER_TYPE</code>. 操作类型：view（浏览）、click（操作）
     */
    public String getOperType() {
        return (String) get(9);
    }

    /**
     * Setter for <code>tools.sys_user_buried.ANALYSIS_LABEL</code>. 分析标签（随意输入，后续用于统计）
     */
    public SysUserBuriedRecord setAnalysisLabel(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.ANALYSIS_LABEL</code>. 分析标签（随意输入，后续用于统计）
     */
    public String getAnalysisLabel() {
        return (String) get(10);
    }

    /**
     * Setter for <code>tools.sys_user_buried.UID</code>. 用户id
     */
    public SysUserBuriedRecord setUid(Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_buried.UID</code>. 用户id
     */
    public Long getUid() {
        return (Long) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<String, String, String, String, String, String, String, String, Long, String, String, Long> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<String, String, String, String, String, String, String, String, Long, String, String, Long> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SysUserBuried.SYS_USER_BURIED.ID;
    }

    @Override
    public Field<String> field2() {
        return SysUserBuried.SYS_USER_BURIED.IP;
    }

    @Override
    public Field<String> field3() {
        return SysUserBuried.SYS_USER_BURIED.URI;
    }

    @Override
    public Field<String> field4() {
        return SysUserBuried.SYS_USER_BURIED.SYS_CODE;
    }

    @Override
    public Field<String> field5() {
        return SysUserBuried.SYS_USER_BURIED.SSXT;
    }

    @Override
    public Field<String> field6() {
        return SysUserBuried.SYS_USER_BURIED.BUZZ_ID;
    }

    @Override
    public Field<String> field7() {
        return SysUserBuried.SYS_USER_BURIED.ACCESS_DATE;
    }

    @Override
    public Field<String> field8() {
        return SysUserBuried.SYS_USER_BURIED.TYPE;
    }

    @Override
    public Field<Long> field9() {
        return SysUserBuried.SYS_USER_BURIED.DURATION_TIME;
    }

    @Override
    public Field<String> field10() {
        return SysUserBuried.SYS_USER_BURIED.OPER_TYPE;
    }

    @Override
    public Field<String> field11() {
        return SysUserBuried.SYS_USER_BURIED.ANALYSIS_LABEL;
    }

    @Override
    public Field<Long> field12() {
        return SysUserBuried.SYS_USER_BURIED.UID;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getIp();
    }

    @Override
    public String component3() {
        return getUri();
    }

    @Override
    public String component4() {
        return getSysCode();
    }

    @Override
    public String component5() {
        return getSsxt();
    }

    @Override
    public String component6() {
        return getBuzzId();
    }

    @Override
    public String component7() {
        return getAccessDate();
    }

    @Override
    public String component8() {
        return getType();
    }

    @Override
    public Long component9() {
        return getDurationTime();
    }

    @Override
    public String component10() {
        return getOperType();
    }

    @Override
    public String component11() {
        return getAnalysisLabel();
    }

    @Override
    public Long component12() {
        return getUid();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getIp();
    }

    @Override
    public String value3() {
        return getUri();
    }

    @Override
    public String value4() {
        return getSysCode();
    }

    @Override
    public String value5() {
        return getSsxt();
    }

    @Override
    public String value6() {
        return getBuzzId();
    }

    @Override
    public String value7() {
        return getAccessDate();
    }

    @Override
    public String value8() {
        return getType();
    }

    @Override
    public Long value9() {
        return getDurationTime();
    }

    @Override
    public String value10() {
        return getOperType();
    }

    @Override
    public String value11() {
        return getAnalysisLabel();
    }

    @Override
    public Long value12() {
        return getUid();
    }

    @Override
    public SysUserBuriedRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value2(String value) {
        setIp(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value3(String value) {
        setUri(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value4(String value) {
        setSysCode(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value5(String value) {
        setSsxt(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value6(String value) {
        setBuzzId(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value7(String value) {
        setAccessDate(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value8(String value) {
        setType(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value9(Long value) {
        setDurationTime(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value10(String value) {
        setOperType(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value11(String value) {
        setAnalysisLabel(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord value12(Long value) {
        setUid(value);
        return this;
    }

    @Override
    public SysUserBuriedRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, Long value9, String value10, String value11, Long value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysUserBuriedRecord
     */
    public SysUserBuriedRecord() {
        super(SysUserBuried.SYS_USER_BURIED);
    }

    /**
     * Create a detached, initialised SysUserBuriedRecord
     */
    public SysUserBuriedRecord(String id, String ip, String uri, String sysCode, String ssxt, String buzzId, String accessDate, String type, Long durationTime, String operType, String analysisLabel, Long uid) {
        super(SysUserBuried.SYS_USER_BURIED);

        set(0, id);
        set(1, ip);
        set(2, uri);
        set(3, sysCode);
        set(4, ssxt);
        set(5, buzzId);
        set(6, accessDate);
        set(7, type);
        set(8, durationTime);
        set(9, operType);
        set(10, analysisLabel);
        set(11, uid);
    }

    public SysUserBuriedRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysUserBuriedRecord fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setId(json.getString("ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ID","java.lang.String",e);
        }
        try {
            setIp(json.getString("IP"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("IP","java.lang.String",e);
        }
        try {
            setUri(json.getString("URI"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("URI","java.lang.String",e);
        }
        try {
            setSysCode(json.getString("SYS_CODE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("SYS_CODE","java.lang.String",e);
        }
        try {
            setSsxt(json.getString("SSXT"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("SSXT","java.lang.String",e);
        }
        try {
            setBuzzId(json.getString("BUZZ_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("BUZZ_ID","java.lang.String",e);
        }
        try {
            setAccessDate(json.getString("ACCESS_DATE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ACCESS_DATE","java.lang.String",e);
        }
        try {
            setType(json.getString("TYPE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("TYPE","java.lang.String",e);
        }
        try {
            setDurationTime(json.getLong("DURATION_TIME"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("DURATION_TIME","java.lang.Long",e);
        }
        try {
            setOperType(json.getString("OPER_TYPE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPER_TYPE","java.lang.String",e);
        }
        try {
            setAnalysisLabel(json.getString("ANALYSIS_LABEL"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ANALYSIS_LABEL","java.lang.String",e);
        }
        try {
            setUid(json.getLong("UID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("UID","java.lang.Long",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("ID",getId());
        json.put("IP",getIp());
        json.put("URI",getUri());
        json.put("SYS_CODE",getSysCode());
        json.put("SSXT",getSsxt());
        json.put("BUZZ_ID",getBuzzId());
        json.put("ACCESS_DATE",getAccessDate());
        json.put("TYPE",getType());
        json.put("DURATION_TIME",getDurationTime());
        json.put("OPER_TYPE",getOperType());
        json.put("ANALYSIS_LABEL",getAnalysisLabel());
        json.put("UID",getUid());
        return json;
    }

}
