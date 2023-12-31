/*
 * This file is generated by jOOQ.
 */
package io.kida.model;


import io.kida.model.tables.CmmItembank;
import io.kida.model.tables.DataAssociation;
import io.kida.model.tables.DataPrescription;
import io.kida.model.tables.DataVarietyEnterprice;
import io.kida.model.tables.Md5Change;
import io.kida.model.tables.SysAbnormalLog;
import io.kida.model.tables.SysDataDict;
import io.kida.model.tables.SysOperRecord;
import io.kida.model.tables.SysPermission;
import io.kida.model.tables.SysPermissionConfig;
import io.kida.model.tables.SysRole;
import io.kida.model.tables.SysRolePermission;
import io.kida.model.tables.SysUser;
import io.kida.model.tables.SysUserBuried;
import io.kida.model.tables.SysUserRole;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tools extends SchemaImpl {

    private static final long serialVersionUID = 945487224;

    /**
     * The reference instance of <code>tools</code>
     */
    public static final Tools TOOLS = new Tools();

    /**
     * 中医药达人题目爬取
     */
    public final CmmItembank CMM_ITEMBANK = CmmItembank.CMM_ITEMBANK;

    /**
     * 数据关联
     */
    public final DataAssociation DATA_ASSOCIATION = DataAssociation.DATA_ASSOCIATION;

    /**
     * 方剂数据
     */
    public final DataPrescription DATA_PRESCRIPTION = DataPrescription.DATA_PRESCRIPTION;

    /**
     * 品种与企业对应数据
     */
    public final DataVarietyEnterprice DATA_VARIETY_ENTERPRICE = DataVarietyEnterprice.DATA_VARIETY_ENTERPRICE;

    /**
     * md5转换明文表
     */
    public final Md5Change MD5_CHANGE = Md5Change.MD5_CHANGE;

    /**
     * 异常日志表
     */
    public final SysAbnormalLog SYS_ABNORMAL_LOG = SysAbnormalLog.SYS_ABNORMAL_LOG;

    /**
     * 数据字典表
     */
    public final SysDataDict SYS_DATA_DICT = SysDataDict.SYS_DATA_DICT;

    /**
     * 系统操作记录表
     */
    public final SysOperRecord SYS_OPER_RECORD = SysOperRecord.SYS_OPER_RECORD;

    /**
     * 权限表
     */
    public final SysPermission SYS_PERMISSION = SysPermission.SYS_PERMISSION;

    /**
     * 权限配置表
     */
    public final SysPermissionConfig SYS_PERMISSION_CONFIG = SysPermissionConfig.SYS_PERMISSION_CONFIG;

    /**
     * 角色表
     */
    public final SysRole SYS_ROLE = SysRole.SYS_ROLE;

    /**
     * 角色权限关联表
     */
    public final SysRolePermission SYS_ROLE_PERMISSION = SysRolePermission.SYS_ROLE_PERMISSION;

    /**
     * 用户表
     */
    public final SysUser SYS_USER = SysUser.SYS_USER;

    /**
     * 用户信息埋点表
     */
    public final SysUserBuried SYS_USER_BURIED = SysUserBuried.SYS_USER_BURIED;

    /**
     * 用户角色关联表
     */
    public final SysUserRole SYS_USER_ROLE = SysUserRole.SYS_USER_ROLE;

    /**
     * No further instances allowed
     */
    private Tools() {
        super("tools", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            CmmItembank.CMM_ITEMBANK,
            DataAssociation.DATA_ASSOCIATION,
            DataPrescription.DATA_PRESCRIPTION,
            DataVarietyEnterprice.DATA_VARIETY_ENTERPRICE,
            Md5Change.MD5_CHANGE,
            SysAbnormalLog.SYS_ABNORMAL_LOG,
            SysDataDict.SYS_DATA_DICT,
            SysOperRecord.SYS_OPER_RECORD,
            SysPermission.SYS_PERMISSION,
            SysPermissionConfig.SYS_PERMISSION_CONFIG,
            SysRole.SYS_ROLE,
            SysRolePermission.SYS_ROLE_PERMISSION,
            SysUser.SYS_USER,
            SysUserBuried.SYS_USER_BURIED,
            SysUserRole.SYS_USER_ROLE);
    }
}
