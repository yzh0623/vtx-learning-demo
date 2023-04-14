/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


/**
 * 用户角色关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUserRole implements VertxPojo, Serializable {

    private static final long serialVersionUID = 220695081;

    private Long userId;
    private Long roleId;

    public SysUserRole() {}

    public SysUserRole(SysUserRole value) {
        this.userId = value.userId;
        this.roleId = value.roleId;
    }

    public SysUserRole(
        Long userId,
        Long roleId
    ) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public SysUserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public SysUserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysUserRole (");

        sb.append(userId);
        sb.append(", ").append(roleId);

        sb.append(")");
        return sb.toString();
    }

    public SysUserRole(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysUserRole fromJson(io.vertx.core.json.JsonObject json) {
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
