/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


/**
 * 角色权限关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRolePermission implements VertxPojo, Serializable {

    private static final long serialVersionUID = -1022332669;

    private Long roleId;
    private Long permissionId;

    public SysRolePermission() {}

    public SysRolePermission(SysRolePermission value) {
        this.roleId = value.roleId;
        this.permissionId = value.permissionId;
    }

    public SysRolePermission(
        Long roleId,
        Long permissionId
    ) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public SysRolePermission setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getPermissionId() {
        return this.permissionId;
    }

    public SysRolePermission setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysRolePermission (");

        sb.append(roleId);
        sb.append(", ").append(permissionId);

        sb.append(")");
        return sb.toString();
    }

    public SysRolePermission(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysRolePermission fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setRoleId(json.getLong("ROLE_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_ID","java.lang.Long",e);
        }
        try {
            setPermissionId(json.getLong("PERMISSION_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PERMISSION_ID","java.lang.Long",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("ROLE_ID",getRoleId());
        json.put("PERMISSION_ID",getPermissionId());
        return json;
    }

}