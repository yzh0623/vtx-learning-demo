/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables;


import io.kida.model.Keys;
import io.kida.model.Tools;
import io.kida.model.tables.records.SysRoleRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 角色表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRole extends TableImpl<SysRoleRecord> {

    private static final long serialVersionUID = -1772841850;

    /**
     * The reference instance of <code>tools.sys_role</code>
     */
    public static final SysRole SYS_ROLE = new SysRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRoleRecord> getRecordType() {
        return SysRoleRecord.class;
    }

    /**
     * The column <code>tools.sys_role.ROLE_ID</code>. 角色表主键
     */
    public final TableField<SysRoleRecord, Long> ROLE_ID = createField(DSL.name("ROLE_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "角色表主键");

    /**
     * The column <code>tools.sys_role.ROLE_CODE</code>. 角色标识
     */
    public final TableField<SysRoleRecord, String> ROLE_CODE = createField(DSL.name("ROLE_CODE"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "角色标识");

    /**
     * The column <code>tools.sys_role.ROLE_NAME</code>. 角色名称
     */
    public final TableField<SysRoleRecord, String> ROLE_NAME = createField(DSL.name("ROLE_NAME"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "角色名称");

    /**
     * The column <code>tools.sys_role.ALIVE_FLAG</code>. 生效标志.1:生效;0:删除.
     */
    public final TableField<SysRoleRecord, Integer> ALIVE_FLAG = createField(DSL.name("ALIVE_FLAG"), org.jooq.impl.SQLDataType.INTEGER, this, "生效标志.1:生效;0:删除.");

    /**
     * The column <code>tools.sys_role.ADD_USER_ID</code>. 添加用户编号
     */
    public final TableField<SysRoleRecord, Long> ADD_USER_ID = createField(DSL.name("ADD_USER_ID"), org.jooq.impl.SQLDataType.BIGINT, this, "添加用户编号");

    /**
     * The column <code>tools.sys_role.ADD_TIME</code>. 添加时间
     */
    public final TableField<SysRoleRecord, LocalDateTime> ADD_TIME = createField(DSL.name("ADD_TIME"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "添加时间");

    /**
     * The column <code>tools.sys_role.OPR_USER_ID</code>. 修改用户编号
     */
    public final TableField<SysRoleRecord, Long> OPR_USER_ID = createField(DSL.name("OPR_USER_ID"), org.jooq.impl.SQLDataType.BIGINT, this, "修改用户编号");

    /**
     * The column <code>tools.sys_role.OPR_TIME</code>. 修改时间
     */
    public final TableField<SysRoleRecord, LocalDateTime> OPR_TIME = createField(DSL.name("OPR_TIME"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "修改时间");

    /**
     * The column <code>tools.sys_role.ROLE_TYPE</code>. 角色类型 1管理员 0会员 2：管理员职务相关 3:会员职务相关
     */
    public final TableField<SysRoleRecord, Integer> ROLE_TYPE = createField(DSL.name("ROLE_TYPE"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "角色类型 1管理员 0会员 2：管理员职务相关 3:会员职务相关");

    /**
     * Create a <code>tools.sys_role</code> table reference
     */
    public SysRole() {
        this(DSL.name("sys_role"), null);
    }

    /**
     * Create an aliased <code>tools.sys_role</code> table reference
     */
    public SysRole(String alias) {
        this(DSL.name(alias), SYS_ROLE);
    }

    /**
     * Create an aliased <code>tools.sys_role</code> table reference
     */
    public SysRole(Name alias) {
        this(alias, SYS_ROLE);
    }

    private SysRole(Name alias, Table<SysRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRole(Name alias, Table<SysRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("角色表"), TableOptions.table());
    }

    public <O extends Record> SysRole(Table<O> child, ForeignKey<O, SysRoleRecord> key) {
        super(child, key, SYS_ROLE);
    }

    @Override
    public Schema getSchema() {
        return Tools.TOOLS;
    }

    @Override
    public Identity<SysRoleRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE;
    }

    @Override
    public UniqueKey<SysRoleRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SysRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRoleRecord>>asList(Keys.KEY_SYS_ROLE_PRIMARY, Keys.KEY_SYS_ROLE_UK_SYS_ROLE_1, Keys.KEY_SYS_ROLE_UK_SYS_ROLE_2);
    }

    @Override
    public SysRole as(String alias) {
        return new SysRole(DSL.name(alias), this);
    }

    @Override
    public SysRole as(Name alias) {
        return new SysRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRole rename(String name) {
        return new SysRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRole rename(Name name) {
        return new SysRole(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, Integer, Long, LocalDateTime, Long, LocalDateTime, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
