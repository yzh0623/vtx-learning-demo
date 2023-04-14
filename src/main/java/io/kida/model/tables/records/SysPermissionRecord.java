/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.kida.model.tables.SysPermission;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysPermissionRecord extends UpdatableRecordImpl<SysPermissionRecord> implements VertxPojo, Record6<Long, Long, String, Integer, Integer, String> {

    private static final long serialVersionUID = -253186254;

    /**
     * Setter for <code>tools.sys_permission.PERMISSION_ID</code>. 权限表主键
     */
    public SysPermissionRecord setPermissionId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.PERMISSION_ID</code>. 权限表主键
     */
    public Long getPermissionId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tools.sys_permission.P_PERMISSION_ID</code>. 父权限编号,顶级权限的父权限编码为0
     */
    public SysPermissionRecord setPPermissionId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.P_PERMISSION_ID</code>. 父权限编号,顶级权限的父权限编码为0
     */
    public Long getPPermissionId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>tools.sys_permission.PERMISSION_NAME</code>. 权限名称
     */
    public SysPermissionRecord setPermissionName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.PERMISSION_NAME</code>. 权限名称
     */
    public String getPermissionName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tools.sys_permission.PERMISSION_TYPE</code>. 权限类型.1:左菜单导航目录,2:左菜单导航链接,3:按钮,4:链接
     */
    public SysPermissionRecord setPermissionType(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.PERMISSION_TYPE</code>. 权限类型.1:左菜单导航目录,2:左菜单导航链接,3:按钮,4:链接
     */
    public Integer getPermissionType() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>tools.sys_permission.SHOW_FLAG</code>. 是否显示.1:显示,0:隐藏
     */
    public SysPermissionRecord setShowFlag(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.SHOW_FLAG</code>. 是否显示.1:显示,0:隐藏
     */
    public Integer getShowFlag() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>tools.sys_permission.REMARK</code>. 备注
     */
    public SysPermissionRecord setRemark(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_permission.REMARK</code>. 备注
     */
    public String getRemark() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String, Integer, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, String, Integer, Integer, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SysPermission.SYS_PERMISSION.PERMISSION_ID;
    }

    @Override
    public Field<Long> field2() {
        return SysPermission.SYS_PERMISSION.P_PERMISSION_ID;
    }

    @Override
    public Field<String> field3() {
        return SysPermission.SYS_PERMISSION.PERMISSION_NAME;
    }

    @Override
    public Field<Integer> field4() {
        return SysPermission.SYS_PERMISSION.PERMISSION_TYPE;
    }

    @Override
    public Field<Integer> field5() {
        return SysPermission.SYS_PERMISSION.SHOW_FLAG;
    }

    @Override
    public Field<String> field6() {
        return SysPermission.SYS_PERMISSION.REMARK;
    }

    @Override
    public Long component1() {
        return getPermissionId();
    }

    @Override
    public Long component2() {
        return getPPermissionId();
    }

    @Override
    public String component3() {
        return getPermissionName();
    }

    @Override
    public Integer component4() {
        return getPermissionType();
    }

    @Override
    public Integer component5() {
        return getShowFlag();
    }

    @Override
    public String component6() {
        return getRemark();
    }

    @Override
    public Long value1() {
        return getPermissionId();
    }

    @Override
    public Long value2() {
        return getPPermissionId();
    }

    @Override
    public String value3() {
        return getPermissionName();
    }

    @Override
    public Integer value4() {
        return getPermissionType();
    }

    @Override
    public Integer value5() {
        return getShowFlag();
    }

    @Override
    public String value6() {
        return getRemark();
    }

    @Override
    public SysPermissionRecord value1(Long value) {
        setPermissionId(value);
        return this;
    }

    @Override
    public SysPermissionRecord value2(Long value) {
        setPPermissionId(value);
        return this;
    }

    @Override
    public SysPermissionRecord value3(String value) {
        setPermissionName(value);
        return this;
    }

    @Override
    public SysPermissionRecord value4(Integer value) {
        setPermissionType(value);
        return this;
    }

    @Override
    public SysPermissionRecord value5(Integer value) {
        setShowFlag(value);
        return this;
    }

    @Override
    public SysPermissionRecord value6(String value) {
        setRemark(value);
        return this;
    }

    @Override
    public SysPermissionRecord values(Long value1, Long value2, String value3, Integer value4, Integer value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysPermissionRecord
     */
    public SysPermissionRecord() {
        super(SysPermission.SYS_PERMISSION);
    }

    /**
     * Create a detached, initialised SysPermissionRecord
     */
    public SysPermissionRecord(Long permissionId, Long pPermissionId, String permissionName, Integer permissionType, Integer showFlag, String remark) {
        super(SysPermission.SYS_PERMISSION);

        set(0, permissionId);
        set(1, pPermissionId);
        set(2, permissionName);
        set(3, permissionType);
        set(4, showFlag);
        set(5, remark);
    }

    public SysPermissionRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysPermissionRecord fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setPermissionId(json.getLong("PERMISSION_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PERMISSION_ID","java.lang.Long",e);
        }
        try {
            setPPermissionId(json.getLong("P_PERMISSION_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("P_PERMISSION_ID","java.lang.Long",e);
        }
        try {
            setPermissionName(json.getString("PERMISSION_NAME"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PERMISSION_NAME","java.lang.String",e);
        }
        try {
            setPermissionType(json.getInteger("PERMISSION_TYPE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PERMISSION_TYPE","java.lang.Integer",e);
        }
        try {
            setShowFlag(json.getInteger("SHOW_FLAG"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("SHOW_FLAG","java.lang.Integer",e);
        }
        try {
            setRemark(json.getString("REMARK"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("REMARK","java.lang.String",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("PERMISSION_ID",getPermissionId());
        json.put("P_PERMISSION_ID",getPPermissionId());
        json.put("PERMISSION_NAME",getPermissionName());
        json.put("PERMISSION_TYPE",getPermissionType());
        json.put("SHOW_FLAG",getShowFlag());
        json.put("REMARK",getRemark());
        return json;
    }

}