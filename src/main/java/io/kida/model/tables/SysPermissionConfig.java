/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables;


import io.kida.model.Keys;
import io.kida.model.Tools;
import io.kida.model.tables.records.SysPermissionConfigRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row19;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 权限配置表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysPermissionConfig extends TableImpl<SysPermissionConfigRecord> {

    private static final long serialVersionUID = -362225735;

    /**
     * The reference instance of <code>tools.sys_permission_config</code>
     */
    public static final SysPermissionConfig SYS_PERMISSION_CONFIG = new SysPermissionConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysPermissionConfigRecord> getRecordType() {
        return SysPermissionConfigRecord.class;
    }

    /**
     * The column <code>tools.sys_permission_config.PERMISSION_CONFIG_ID</code>. 权限配置表主键
     */
    public final TableField<SysPermissionConfigRecord, Long> PERMISSION_CONFIG_ID = createField(DSL.name("PERMISSION_CONFIG_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "权限配置表主键");

    /**
     * The column <code>tools.sys_permission_config.PERMISSION_URL</code>. 链接地址.表示点击菜单或按钮触发的URL地址
     */
    public final TableField<SysPermissionConfigRecord, String> PERMISSION_URL = createField(DSL.name("PERMISSION_URL"), org.jooq.impl.SQLDataType.VARCHAR(128), this, "链接地址.表示点击菜单或按钮触发的URL地址");

    /**
     * The column <code>tools.sys_permission_config.PERMISSION_CONFIG</code>. 权限.表示访问此地址需要具备的权限
     */
    public final TableField<SysPermissionConfigRecord, String> PERMISSION_CONFIG = createField(DSL.name("PERMISSION_CONFIG"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "权限.表示访问此地址需要具备的权限");

    /**
     * The column <code>tools.sys_permission_config.SEQ_NO</code>. 序号.shiro filter由上到下执行
     */
    public final TableField<SysPermissionConfigRecord, Integer> SEQ_NO = createField(DSL.name("SEQ_NO"), org.jooq.impl.SQLDataType.INTEGER, this, "序号.shiro filter由上到下执行");

    /**
     * The column <code>tools.sys_permission_config.REMARK</code>. 备注
     */
    public final TableField<SysPermissionConfigRecord, String> REMARK = createField(DSL.name("REMARK"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "备注");

    /**
     * The column <code>tools.sys_permission_config.PERMISSION_NAME</code>. 菜单名称
     */
    public final TableField<SysPermissionConfigRecord, String> PERMISSION_NAME = createField(DSL.name("PERMISSION_NAME"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "菜单名称");

    /**
     * The column <code>tools.sys_permission_config.ICON</code>. 图标
     */
    public final TableField<SysPermissionConfigRecord, String> ICON = createField(DSL.name("ICON"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "图标");

    /**
     * The column <code>tools.sys_permission_config.PERMISSION_TYPE</code>. 0目录 1 链接
     */
    public final TableField<SysPermissionConfigRecord, Boolean> PERMISSION_TYPE = createField(DSL.name("PERMISSION_TYPE"), org.jooq.impl.SQLDataType.BIT.defaultValue(org.jooq.impl.DSL.inline("b'0'", org.jooq.impl.SQLDataType.BIT)), this, "0目录 1 链接");

    /**
     * The column <code>tools.sys_permission_config.P_PERMISSION_ID</code>. 父级id
     */
    public final TableField<SysPermissionConfigRecord, Integer> P_PERMISSION_ID = createField(DSL.name("P_PERMISSION_ID"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "父级id");

    /**
     * The column <code>tools.sys_permission_config.SYS_ID</code>. 系统平台的标识
     */
    public final TableField<SysPermissionConfigRecord, String> SYS_ID = createField(DSL.name("SYS_ID"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "系统平台的标识");

    /**
     * The column <code>tools.sys_permission_config.SORT_NO</code>. 排序号
     */
    public final TableField<SysPermissionConfigRecord, Integer> SORT_NO = createField(DSL.name("SORT_NO"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "排序号");

    /**
     * The column <code>tools.sys_permission_config.DISPLAY</code>. 是否显示 1是 0 否
     */
    public final TableField<SysPermissionConfigRecord, Integer> DISPLAY = createField(DSL.name("DISPLAY"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.INTEGER)), this, "是否显示 1是 0 否");

    /**
     * The column <code>tools.sys_permission_config.ALIVE_FLAG</code>. 生效标志.1:生效;0:删除.
     */
    public final TableField<SysPermissionConfigRecord, Integer> ALIVE_FLAG = createField(DSL.name("ALIVE_FLAG"), org.jooq.impl.SQLDataType.INTEGER, this, "生效标志.1:生效;0:删除.");

    /**
     * The column <code>tools.sys_permission_config.ADD_USER_ID</code>. 添加用户编号
     */
    public final TableField<SysPermissionConfigRecord, Long> ADD_USER_ID = createField(DSL.name("ADD_USER_ID"), org.jooq.impl.SQLDataType.BIGINT, this, "添加用户编号");

    /**
     * The column <code>tools.sys_permission_config.ADD_TIME</code>. 添加时间
     */
    public final TableField<SysPermissionConfigRecord, LocalDateTime> ADD_TIME = createField(DSL.name("ADD_TIME"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "添加时间");

    /**
     * The column <code>tools.sys_permission_config.OPR_USER_ID</code>. 修改用户编号
     */
    public final TableField<SysPermissionConfigRecord, Long> OPR_USER_ID = createField(DSL.name("OPR_USER_ID"), org.jooq.impl.SQLDataType.BIGINT, this, "修改用户编号");

    /**
     * The column <code>tools.sys_permission_config.OPR_TIME</code>. 修改时间
     */
    public final TableField<SysPermissionConfigRecord, LocalDateTime> OPR_TIME = createField(DSL.name("OPR_TIME"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "修改时间");

    /**
     * The column <code>tools.sys_permission_config.SUBSYS_CODE</code>. 系统标识
     */
    public final TableField<SysPermissionConfigRecord, String> SUBSYS_CODE = createField(DSL.name("SUBSYS_CODE"), org.jooq.impl.SQLDataType.VARCHAR(9).nullable(false), this, "系统标识");

    /**
     * The column <code>tools.sys_permission_config.CHECK_FLAG</code>.
     */
    public final TableField<SysPermissionConfigRecord, Byte> CHECK_FLAG = createField(DSL.name("CHECK_FLAG"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>tools.sys_permission_config</code> table reference
     */
    public SysPermissionConfig() {
        this(DSL.name("sys_permission_config"), null);
    }

    /**
     * Create an aliased <code>tools.sys_permission_config</code> table reference
     */
    public SysPermissionConfig(String alias) {
        this(DSL.name(alias), SYS_PERMISSION_CONFIG);
    }

    /**
     * Create an aliased <code>tools.sys_permission_config</code> table reference
     */
    public SysPermissionConfig(Name alias) {
        this(alias, SYS_PERMISSION_CONFIG);
    }

    private SysPermissionConfig(Name alias, Table<SysPermissionConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysPermissionConfig(Name alias, Table<SysPermissionConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限配置表"), TableOptions.table());
    }

    public <O extends Record> SysPermissionConfig(Table<O> child, ForeignKey<O, SysPermissionConfigRecord> key) {
        super(child, key, SYS_PERMISSION_CONFIG);
    }

    @Override
    public Schema getSchema() {
        return Tools.TOOLS;
    }

    @Override
    public Identity<SysPermissionConfigRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_PERMISSION_CONFIG;
    }

    @Override
    public UniqueKey<SysPermissionConfigRecord> getPrimaryKey() {
        return Keys.KEY_SYS_PERMISSION_CONFIG_PRIMARY;
    }

    @Override
    public List<UniqueKey<SysPermissionConfigRecord>> getKeys() {
        return Arrays.<UniqueKey<SysPermissionConfigRecord>>asList(Keys.KEY_SYS_PERMISSION_CONFIG_PRIMARY);
    }

    @Override
    public SysPermissionConfig as(String alias) {
        return new SysPermissionConfig(DSL.name(alias), this);
    }

    @Override
    public SysPermissionConfig as(Name alias) {
        return new SysPermissionConfig(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysPermissionConfig rename(String name) {
        return new SysPermissionConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysPermissionConfig rename(Name name) {
        return new SysPermissionConfig(name, null);
    }

    // -------------------------------------------------------------------------
    // Row19 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row19<Long, String, String, Integer, String, String, String, Boolean, Integer, String, Integer, Integer, Integer, Long, LocalDateTime, Long, LocalDateTime, String, Byte> fieldsRow() {
        return (Row19) super.fieldsRow();
    }
}