/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables;


import io.kida.model.Keys;
import io.kida.model.Tools;
import io.kida.model.tables.records.SysPermissionRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysPermission extends TableImpl<SysPermissionRecord> {

    private static final long serialVersionUID = -1780797707;

    /**
     * The reference instance of <code>tools.sys_permission</code>
     */
    public static final SysPermission SYS_PERMISSION = new SysPermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysPermissionRecord> getRecordType() {
        return SysPermissionRecord.class;
    }

    /**
     * The column <code>tools.sys_permission.PERMISSION_ID</code>. 权限表主键
     */
    public final TableField<SysPermissionRecord, Long> PERMISSION_ID = createField(DSL.name("PERMISSION_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "权限表主键");

    /**
     * The column <code>tools.sys_permission.P_PERMISSION_ID</code>. 父权限编号,顶级权限的父权限编码为0
     */
    public final TableField<SysPermissionRecord, Long> P_PERMISSION_ID = createField(DSL.name("P_PERMISSION_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "父权限编号,顶级权限的父权限编码为0");

    /**
     * The column <code>tools.sys_permission.PERMISSION_NAME</code>. 权限名称
     */
    public final TableField<SysPermissionRecord, String> PERMISSION_NAME = createField(DSL.name("PERMISSION_NAME"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "权限名称");

    /**
     * The column <code>tools.sys_permission.PERMISSION_TYPE</code>. 权限类型.1:左菜单导航目录,2:左菜单导航链接,3:按钮,4:链接
     */
    public final TableField<SysPermissionRecord, Integer> PERMISSION_TYPE = createField(DSL.name("PERMISSION_TYPE"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "权限类型.1:左菜单导航目录,2:左菜单导航链接,3:按钮,4:链接");

    /**
     * The column <code>tools.sys_permission.SHOW_FLAG</code>. 是否显示.1:显示,0:隐藏
     */
    public final TableField<SysPermissionRecord, Integer> SHOW_FLAG = createField(DSL.name("SHOW_FLAG"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "是否显示.1:显示,0:隐藏");

    /**
     * The column <code>tools.sys_permission.REMARK</code>. 备注
     */
    public final TableField<SysPermissionRecord, String> REMARK = createField(DSL.name("REMARK"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "备注");

    /**
     * Create a <code>tools.sys_permission</code> table reference
     */
    public SysPermission() {
        this(DSL.name("sys_permission"), null);
    }

    /**
     * Create an aliased <code>tools.sys_permission</code> table reference
     */
    public SysPermission(String alias) {
        this(DSL.name(alias), SYS_PERMISSION);
    }

    /**
     * Create an aliased <code>tools.sys_permission</code> table reference
     */
    public SysPermission(Name alias) {
        this(alias, SYS_PERMISSION);
    }

    private SysPermission(Name alias, Table<SysPermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysPermission(Name alias, Table<SysPermissionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限表"), TableOptions.table());
    }

    public <O extends Record> SysPermission(Table<O> child, ForeignKey<O, SysPermissionRecord> key) {
        super(child, key, SYS_PERMISSION);
    }

    @Override
    public Schema getSchema() {
        return Tools.TOOLS;
    }

    @Override
    public Identity<SysPermissionRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_PERMISSION;
    }

    @Override
    public UniqueKey<SysPermissionRecord> getPrimaryKey() {
        return Keys.KEY_SYS_PERMISSION_PRIMARY;
    }

    @Override
    public List<UniqueKey<SysPermissionRecord>> getKeys() {
        return Arrays.<UniqueKey<SysPermissionRecord>>asList(Keys.KEY_SYS_PERMISSION_PRIMARY);
    }

    @Override
    public SysPermission as(String alias) {
        return new SysPermission(DSL.name(alias), this);
    }

    @Override
    public SysPermission as(Name alias) {
        return new SysPermission(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysPermission rename(String name) {
        return new SysPermission(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysPermission rename(Name name) {
        return new SysPermission(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String, Integer, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
