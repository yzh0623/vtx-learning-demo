/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.kida.model.tables.SysUserRole;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户角色关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUserRoleRecord extends UpdatableRecordImpl<SysUserRoleRecord> implements VertxPojo, Record2<Long, Long> {

    private static final long serialVersionUID = 1796030431;

    /**
     * Setter for <code>tools.sys_user_role.USER_ID</code>. 用户编号
     */
    public SysUserRoleRecord setUserId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_role.USER_ID</code>. 用户编号
     */
    public Long getUserId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tools.sys_user_role.ROLE_ID</code>. 角色编号
     */
    public SysUserRoleRecord setRoleId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>tools.sys_user_role.ROLE_ID</code>. 角色编号
     */
    public Long getRoleId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SysUserRole.SYS_USER_ROLE.USER_ID;
    }

    @Override
    public Field<Long> field2() {
        return SysUserRole.SYS_USER_ROLE.ROLE_ID;
    }

    @Override
    public Long component1() {
        return getUserId();
    }

    @Override
    public Long component2() {
        return getRoleId();
    }

    @Override
    public Long value1() {
        return getUserId();
    }

    @Override
    public Long value2() {
        return getRoleId();
    }

    @Override
    public SysUserRoleRecord value1(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public SysUserRoleRecord value2(Long value) {
        setRoleId(value);
        return this;
    }

    @Override
    public SysUserRoleRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysUserRoleRecord
     */
    public SysUserRoleRecord() {
        super(SysUserRole.SYS_USER_ROLE);
    }

    /**
     * Create a detached, initialised SysUserRoleRecord
     */
    public SysUserRoleRecord(Long userId, Long roleId) {
        super(SysUserRole.SYS_USER_ROLE);

        set(0, userId);
        set(1, roleId);
    }

    public SysUserRoleRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysUserRoleRecord fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setUserId(json.getLong("USER_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("USER_ID","java.lang.Long",e);
        }
        try {
            setRoleId(json.getLong("ROLE_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_ID","java.lang.Long",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("USER_ID",getUserId());
        json.put("ROLE_ID",getRoleId());
        return json;
    }

}