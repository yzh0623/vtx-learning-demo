/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


/**
 * 数据关联
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataAssociation implements VertxPojo, Serializable {

    private static final long serialVersionUID = -1701032867;

    private String drugName;
    private String approvalNumber;
    private String productionUnit;
    private String preparation;
    private String specifications;

    public DataAssociation() {}

    public DataAssociation(DataAssociation value) {
        this.drugName = value.drugName;
        this.approvalNumber = value.approvalNumber;
        this.productionUnit = value.productionUnit;
        this.preparation = value.preparation;
        this.specifications = value.specifications;
    }

    public DataAssociation(
        String drugName,
        String approvalNumber,
        String productionUnit,
        String preparation,
        String specifications
    ) {
        this.drugName = drugName;
        this.approvalNumber = approvalNumber;
        this.productionUnit = productionUnit;
        this.preparation = preparation;
        this.specifications = specifications;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public DataAssociation setDrugName(String drugName) {
        this.drugName = drugName;
        return this;
    }

    public String getApprovalNumber() {
        return this.approvalNumber;
    }

    public DataAssociation setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
        return this;
    }

    public String getProductionUnit() {
        return this.productionUnit;
    }

    public DataAssociation setProductionUnit(String productionUnit) {
        this.productionUnit = productionUnit;
        return this;
    }

    public String getPreparation() {
        return this.preparation;
    }

    public DataAssociation setPreparation(String preparation) {
        this.preparation = preparation;
        return this;
    }

    public String getSpecifications() {
        return this.specifications;
    }

    public DataAssociation setSpecifications(String specifications) {
        this.specifications = specifications;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DataAssociation (");

        sb.append(drugName);
        sb.append(", ").append(approvalNumber);
        sb.append(", ").append(productionUnit);
        sb.append(", ").append(preparation);
        sb.append(", ").append(specifications);

        sb.append(")");
        return sb.toString();
    }

    public DataAssociation(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public DataAssociation fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setDrugName(json.getString("drug_name"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("drug_name","java.lang.String",e);
        }
        try {
            setApprovalNumber(json.getString("approval_number"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("approval_number","java.lang.String",e);
        }
        try {
            setProductionUnit(json.getString("production_unit"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("production_unit","java.lang.String",e);
        }
        try {
            setPreparation(json.getString("preparation"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("preparation","java.lang.String",e);
        }
        try {
            setSpecifications(json.getString("specifications"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("specifications","java.lang.String",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("drug_name",getDrugName());
        json.put("approval_number",getApprovalNumber());
        json.put("production_unit",getProductionUnit());
        json.put("preparation",getPreparation());
        json.put("specifications",getSpecifications());
        return json;
    }

}
