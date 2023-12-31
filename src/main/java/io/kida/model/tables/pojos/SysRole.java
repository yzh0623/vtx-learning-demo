/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 角色表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRole implements VertxPojo, Serializable {

    private static final long serialVersionUID = 476961027;

    private Long          roleId;
    private String        roleCode;
    private String        roleName;
    private Integer       aliveFlag;
    private Long          addUserId;
    private LocalDateTime addTime;
    private Long          oprUserId;
    private LocalDateTime oprTime;
    private Integer       roleType;

    public SysRole() {}

    public SysRole(SysRole value) {
        this.roleId = value.roleId;
        this.roleCode = value.roleCode;
        this.roleName = value.roleName;
        this.aliveFlag = value.aliveFlag;
        this.addUserId = value.addUserId;
        this.addTime = value.addTime;
        this.oprUserId = value.oprUserId;
        this.oprTime = value.oprTime;
        this.roleType = value.roleType;
    }

    public SysRole(
        Long          roleId,
        String        roleCode,
        String        roleName,
        Integer       aliveFlag,
        Long          addUserId,
        LocalDateTime addTime,
        Long          oprUserId,
        LocalDateTime oprTime,
        Integer       roleType
    ) {
        this.roleId = roleId;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.aliveFlag = aliveFlag;
        this.addUserId = addUserId;
        this.addTime = addTime;
        this.oprUserId = oprUserId;
        this.oprTime = oprTime;
        this.roleType = roleType;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public SysRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public SysRole setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public SysRole setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public Integer getAliveFlag() {
        return this.aliveFlag;
    }

    public SysRole setAliveFlag(Integer aliveFlag) {
        this.aliveFlag = aliveFlag;
        return this;
    }

    public Long getAddUserId() {
        return this.addUserId;
    }

    public SysRole setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
        return this;
    }

    public LocalDateTime getAddTime() {
        return this.addTime;
    }

    public SysRole setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
        return this;
    }

    public Long getOprUserId() {
        return this.oprUserId;
    }

    public SysRole setOprUserId(Long oprUserId) {
        this.oprUserId = oprUserId;
        return this;
    }

    public LocalDateTime getOprTime() {
        return this.oprTime;
    }

    public SysRole setOprTime(LocalDateTime oprTime) {
        this.oprTime = oprTime;
        return this;
    }

    public Integer getRoleType() {
        return this.roleType;
    }

    public SysRole setRoleType(Integer roleType) {
        this.roleType = roleType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysRole (");

        sb.append(roleId);
        sb.append(", ").append(roleCode);
        sb.append(", ").append(roleName);
        sb.append(", ").append(aliveFlag);
        sb.append(", ").append(addUserId);
        sb.append(", ").append(addTime);
        sb.append(", ").append(oprUserId);
        sb.append(", ").append(oprTime);
        sb.append(", ").append(roleType);

        sb.append(")");
        return sb.toString();
    }

    public SysRole(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysRole fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setRoleId(json.getLong("ROLE_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_ID","java.lang.Long",e);
        }
        try {
            setRoleCode(json.getString("ROLE_CODE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_CODE","java.lang.String",e);
        }
        try {
            setRoleName(json.getString("ROLE_NAME"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_NAME","java.lang.String",e);
        }
        try {
            setAliveFlag(json.getInteger("ALIVE_FLAG"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ALIVE_FLAG","java.lang.Integer",e);
        }
        try {
            setAddUserId(json.getLong("ADD_USER_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ADD_USER_ID","java.lang.Long",e);
        }
        try {
            // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ADD_TIME","java.time.LocalDateTime",e);
        }
        try {
            setOprUserId(json.getLong("OPR_USER_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPR_USER_ID","java.lang.Long",e);
        }
        try {
            // Omitting unrecognized type java.time.LocalDateTime for column OPR_TIME!
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPR_TIME","java.time.LocalDateTime",e);
        }
        try {
            setRoleType(json.getInteger("ROLE_TYPE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ROLE_TYPE","java.lang.Integer",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("ROLE_ID",getRoleId());
        json.put("ROLE_CODE",getRoleCode());
        json.put("ROLE_NAME",getRoleName());
        json.put("ALIVE_FLAG",getAliveFlag());
        json.put("ADD_USER_ID",getAddUserId());
        // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        json.put("OPR_USER_ID",getOprUserId());
        // Omitting unrecognized type java.time.LocalDateTime for column OPR_TIME!
        json.put("ROLE_TYPE",getRoleType());
        return json;
    }

}
