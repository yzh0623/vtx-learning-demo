/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


/**
 * 品种与企业对应数据
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataVarietyEnterprice implements VertxPojo, Serializable {

    private static final long serialVersionUID = 39732938;

    private String variety;
    private String enterprice;
    private String enterpriceRole;
    private String email;
    private String contactPhone;
    private String companyAddress;
    private String contactName;
    private String varietyType;

    public DataVarietyEnterprice() {}

    public DataVarietyEnterprice(DataVarietyEnterprice value) {
        this.variety = value.variety;
        this.enterprice = value.enterprice;
        this.enterpriceRole = value.enterpriceRole;
        this.email = value.email;
        this.contactPhone = value.contactPhone;
        this.companyAddress = value.companyAddress;
        this.contactName = value.contactName;
        this.varietyType = value.varietyType;
    }

    public DataVarietyEnterprice(
        String variety,
        String enterprice,
        String enterpriceRole,
        String email,
        String contactPhone,
        String companyAddress,
        String contactName,
        String varietyType
    ) {
        this.variety = variety;
        this.enterprice = enterprice;
        this.enterpriceRole = enterpriceRole;
        this.email = email;
        this.contactPhone = contactPhone;
        this.companyAddress = companyAddress;
        this.contactName = contactName;
        this.varietyType = varietyType;
    }

    public String getVariety() {
        return this.variety;
    }

    public DataVarietyEnterprice setVariety(String variety) {
        this.variety = variety;
        return this;
    }

    public String getEnterprice() {
        return this.enterprice;
    }

    public DataVarietyEnterprice setEnterprice(String enterprice) {
        this.enterprice = enterprice;
        return this;
    }

    public String getEnterpriceRole() {
        return this.enterpriceRole;
    }

    public DataVarietyEnterprice setEnterpriceRole(String enterpriceRole) {
        this.enterpriceRole = enterpriceRole;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public DataVarietyEnterprice setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public DataVarietyEnterprice setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public DataVarietyEnterprice setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    public String getContactName() {
        return this.contactName;
    }

    public DataVarietyEnterprice setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getVarietyType() {
        return this.varietyType;
    }

    public DataVarietyEnterprice setVarietyType(String varietyType) {
        this.varietyType = varietyType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DataVarietyEnterprice (");

        sb.append(variety);
        sb.append(", ").append(enterprice);
        sb.append(", ").append(enterpriceRole);
        sb.append(", ").append(email);
        sb.append(", ").append(contactPhone);
        sb.append(", ").append(companyAddress);
        sb.append(", ").append(contactName);
        sb.append(", ").append(varietyType);

        sb.append(")");
        return sb.toString();
    }

    public DataVarietyEnterprice(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public DataVarietyEnterprice fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setVariety(json.getString("variety"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("variety","java.lang.String",e);
        }
        try {
            setEnterprice(json.getString("enterprice"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("enterprice","java.lang.String",e);
        }
        try {
            setEnterpriceRole(json.getString("enterprice_role"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("enterprice_role","java.lang.String",e);
        }
        try {
            setEmail(json.getString("email"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("email","java.lang.String",e);
        }
        try {
            setContactPhone(json.getString("contact_phone"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("contact_phone","java.lang.String",e);
        }
        try {
            setCompanyAddress(json.getString("company_address"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("company_address","java.lang.String",e);
        }
        try {
            setContactName(json.getString("contact_name"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("contact_name","java.lang.String",e);
        }
        try {
            setVarietyType(json.getString("variety_type"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("variety_type","java.lang.String",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("variety",getVariety());
        json.put("enterprice",getEnterprice());
        json.put("enterprice_role",getEnterpriceRole());
        json.put("email",getEmail());
        json.put("contact_phone",getContactPhone());
        json.put("company_address",getCompanyAddress());
        json.put("contact_name",getContactName());
        json.put("variety_type",getVarietyType());
        return json;
    }

}
