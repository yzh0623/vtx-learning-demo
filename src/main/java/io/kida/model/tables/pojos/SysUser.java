/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 用户表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUser implements VertxPojo, Serializable {

    private static final long serialVersionUID = 507091902;

    private Long          userId;
    private String        userAccount;
    private String        userPassword;
    private String        userName;
    private String        phone;
    private LocalDateTime addTime;
    private LocalDateTime loginTime;
    private String        loginIp;
    private Integer       status;
    private String        wxId;
    private String        imgUrl;
    private String        mail;

    public SysUser() {}

    public SysUser(SysUser value) {
        this.userId = value.userId;
        this.userAccount = value.userAccount;
        this.userPassword = value.userPassword;
        this.userName = value.userName;
        this.phone = value.phone;
        this.addTime = value.addTime;
        this.loginTime = value.loginTime;
        this.loginIp = value.loginIp;
        this.status = value.status;
        this.wxId = value.wxId;
        this.imgUrl = value.imgUrl;
        this.mail = value.mail;
    }

    public SysUser(
        Long          userId,
        String        userAccount,
        String        userPassword,
        String        userName,
        String        phone,
        LocalDateTime addTime,
        LocalDateTime loginTime,
        String        loginIp,
        Integer       status,
        String        wxId,
        String        imgUrl,
        String        mail
    ) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.phone = phone;
        this.addTime = addTime;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.status = status;
        this.wxId = wxId;
        this.imgUrl = imgUrl;
        this.mail = mail;
    }

    public Long getUserId() {
        return this.userId;
    }

    public SysUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public SysUser setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public SysUser setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserName() {
        return this.userName;
    }

    public SysUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public SysUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDateTime getAddTime() {
        return this.addTime;
    }

    public SysUser setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
        return this;
    }

    public LocalDateTime getLoginTime() {
        return this.loginTime;
    }

    public SysUser setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
        return this;
    }

    public String getLoginIp() {
        return this.loginIp;
    }

    public SysUser setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public Integer getStatus() {
        return this.status;
    }

    public SysUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getWxId() {
        return this.wxId;
    }

    public SysUser setWxId(String wxId) {
        this.wxId = wxId;
        return this;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public SysUser setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getMail() {
        return this.mail;
    }

    public SysUser setMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysUser (");

        sb.append(userId);
        sb.append(", ").append(userAccount);
        sb.append(", ").append(userPassword);
        sb.append(", ").append(userName);
        sb.append(", ").append(phone);
        sb.append(", ").append(addTime);
        sb.append(", ").append(loginTime);
        sb.append(", ").append(loginIp);
        sb.append(", ").append(status);
        sb.append(", ").append(wxId);
        sb.append(", ").append(imgUrl);
        sb.append(", ").append(mail);

        sb.append(")");
        return sb.toString();
    }

    public SysUser(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public SysUser fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setUserId(json.getLong("USER_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("USER_ID","java.lang.Long",e);
        }
        try {
            setUserAccount(json.getString("USER_ACCOUNT"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("USER_ACCOUNT","java.lang.String",e);
        }
        try {
            setUserPassword(json.getString("USER_PASSWORD"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("USER_PASSWORD","java.lang.String",e);
        }
        try {
            setUserName(json.getString("USER_NAME"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("USER_NAME","java.lang.String",e);
        }
        try {
            setPhone(json.getString("PHONE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PHONE","java.lang.String",e);
        }
        try {
            // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ADD_TIME","java.time.LocalDateTime",e);
        }
        try {
            // Omitting unrecognized type java.time.LocalDateTime for column LOGIN_TIME!
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("LOGIN_TIME","java.time.LocalDateTime",e);
        }
        try {
            setLoginIp(json.getString("LOGIN_IP"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("LOGIN_IP","java.lang.String",e);
        }
        try {
            setStatus(json.getInteger("STATUS"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("STATUS","java.lang.Integer",e);
        }
        try {
            setWxId(json.getString("WX_ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("WX_ID","java.lang.String",e);
        }
        try {
            setImgUrl(json.getString("IMG_URL"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("IMG_URL","java.lang.String",e);
        }
        try {
            setMail(json.getString("MAIL"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("MAIL","java.lang.String",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("USER_ID",getUserId());
        json.put("USER_ACCOUNT",getUserAccount());
        json.put("USER_PASSWORD",getUserPassword());
        json.put("USER_NAME",getUserName());
        json.put("PHONE",getPhone());
        // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        // Omitting unrecognized type java.time.LocalDateTime for column LOGIN_TIME!
        json.put("LOGIN_IP",getLoginIp());
        json.put("STATUS",getStatus());
        json.put("WX_ID",getWxId());
        json.put("IMG_URL",getImgUrl());
        json.put("MAIL",getMail());
        return json;
    }

}
