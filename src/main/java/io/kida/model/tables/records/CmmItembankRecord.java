/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.UnexpectedJsonValueType;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.kida.model.tables.CmmItembank;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 中医药达人题目爬取
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmmItembankRecord extends UpdatableRecordImpl<CmmItembankRecord> implements VertxPojo, Record12<Long, String, String, String, String, String, String, String, LocalDateTime, String, Integer, Integer> {

    private static final long serialVersionUID = -2072320853;

    /**
     * Setter for <code>tools.cmm_itembank.ID</code>.
     */
    public CmmItembankRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tools.cmm_itembank.QUESTION_TITLE</code>.
     */
    public CmmItembankRecord setQuestionTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.QUESTION_TITLE</code>.
     */
    public String getQuestionTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_A</code>.
     */
    public CmmItembankRecord setOptionA(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_A</code>.
     */
    public String getOptionA() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_B</code>.
     */
    public CmmItembankRecord setOptionB(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_B</code>.
     */
    public String getOptionB() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_C</code>.
     */
    public CmmItembankRecord setOptionC(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_C</code>.
     */
    public String getOptionC() {
        return (String) get(4);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_D</code>.
     */
    public CmmItembankRecord setOptionD(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_D</code>.
     */
    public String getOptionD() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_E</code>.
     */
    public CmmItembankRecord setOptionE(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_E</code>.
     */
    public String getOptionE() {
        return (String) get(6);
    }

    /**
     * Setter for <code>tools.cmm_itembank.OPTION_F</code>.
     */
    public CmmItembankRecord setOptionF(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.OPTION_F</code>.
     */
    public String getOptionF() {
        return (String) get(7);
    }

    /**
     * Setter for <code>tools.cmm_itembank.ADD_TIME</code>.
     */
    public CmmItembankRecord setAddTime(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.ADD_TIME</code>.
     */
    public LocalDateTime getAddTime() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>tools.cmm_itembank.ACTICLE_NAME</code>.
     */
    public CmmItembankRecord setActicleName(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.ACTICLE_NAME</code>.
     */
    public String getActicleName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>tools.cmm_itembank.PAGE_NUM</code>.
     */
    public CmmItembankRecord setPageNum(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.PAGE_NUM</code>.
     */
    public Integer getPageNum() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>tools.cmm_itembank.SUBJECT_NUM</code>.
     */
    public CmmItembankRecord setSubjectNum(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>tools.cmm_itembank.SUBJECT_NUM</code>.
     */
    public Integer getSubjectNum() {
        return (Integer) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<Long, String, String, String, String, String, String, String, LocalDateTime, String, Integer, Integer> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Long, String, String, String, String, String, String, String, LocalDateTime, String, Integer, Integer> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CmmItembank.CMM_ITEMBANK.ID;
    }

    @Override
    public Field<String> field2() {
        return CmmItembank.CMM_ITEMBANK.QUESTION_TITLE;
    }

    @Override
    public Field<String> field3() {
        return CmmItembank.CMM_ITEMBANK.OPTION_A;
    }

    @Override
    public Field<String> field4() {
        return CmmItembank.CMM_ITEMBANK.OPTION_B;
    }

    @Override
    public Field<String> field5() {
        return CmmItembank.CMM_ITEMBANK.OPTION_C;
    }

    @Override
    public Field<String> field6() {
        return CmmItembank.CMM_ITEMBANK.OPTION_D;
    }

    @Override
    public Field<String> field7() {
        return CmmItembank.CMM_ITEMBANK.OPTION_E;
    }

    @Override
    public Field<String> field8() {
        return CmmItembank.CMM_ITEMBANK.OPTION_F;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return CmmItembank.CMM_ITEMBANK.ADD_TIME;
    }

    @Override
    public Field<String> field10() {
        return CmmItembank.CMM_ITEMBANK.ACTICLE_NAME;
    }

    @Override
    public Field<Integer> field11() {
        return CmmItembank.CMM_ITEMBANK.PAGE_NUM;
    }

    @Override
    public Field<Integer> field12() {
        return CmmItembank.CMM_ITEMBANK.SUBJECT_NUM;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getQuestionTitle();
    }

    @Override
    public String component3() {
        return getOptionA();
    }

    @Override
    public String component4() {
        return getOptionB();
    }

    @Override
    public String component5() {
        return getOptionC();
    }

    @Override
    public String component6() {
        return getOptionD();
    }

    @Override
    public String component7() {
        return getOptionE();
    }

    @Override
    public String component8() {
        return getOptionF();
    }

    @Override
    public LocalDateTime component9() {
        return getAddTime();
    }

    @Override
    public String component10() {
        return getActicleName();
    }

    @Override
    public Integer component11() {
        return getPageNum();
    }

    @Override
    public Integer component12() {
        return getSubjectNum();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getQuestionTitle();
    }

    @Override
    public String value3() {
        return getOptionA();
    }

    @Override
    public String value4() {
        return getOptionB();
    }

    @Override
    public String value5() {
        return getOptionC();
    }

    @Override
    public String value6() {
        return getOptionD();
    }

    @Override
    public String value7() {
        return getOptionE();
    }

    @Override
    public String value8() {
        return getOptionF();
    }

    @Override
    public LocalDateTime value9() {
        return getAddTime();
    }

    @Override
    public String value10() {
        return getActicleName();
    }

    @Override
    public Integer value11() {
        return getPageNum();
    }

    @Override
    public Integer value12() {
        return getSubjectNum();
    }

    @Override
    public CmmItembankRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CmmItembankRecord value2(String value) {
        setQuestionTitle(value);
        return this;
    }

    @Override
    public CmmItembankRecord value3(String value) {
        setOptionA(value);
        return this;
    }

    @Override
    public CmmItembankRecord value4(String value) {
        setOptionB(value);
        return this;
    }

    @Override
    public CmmItembankRecord value5(String value) {
        setOptionC(value);
        return this;
    }

    @Override
    public CmmItembankRecord value6(String value) {
        setOptionD(value);
        return this;
    }

    @Override
    public CmmItembankRecord value7(String value) {
        setOptionE(value);
        return this;
    }

    @Override
    public CmmItembankRecord value8(String value) {
        setOptionF(value);
        return this;
    }

    @Override
    public CmmItembankRecord value9(LocalDateTime value) {
        setAddTime(value);
        return this;
    }

    @Override
    public CmmItembankRecord value10(String value) {
        setActicleName(value);
        return this;
    }

    @Override
    public CmmItembankRecord value11(Integer value) {
        setPageNum(value);
        return this;
    }

    @Override
    public CmmItembankRecord value12(Integer value) {
        setSubjectNum(value);
        return this;
    }

    @Override
    public CmmItembankRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, LocalDateTime value9, String value10, Integer value11, Integer value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CmmItembankRecord
     */
    public CmmItembankRecord() {
        super(CmmItembank.CMM_ITEMBANK);
    }

    /**
     * Create a detached, initialised CmmItembankRecord
     */
    public CmmItembankRecord(Long id, String questionTitle, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, LocalDateTime addTime, String acticleName, Integer pageNum, Integer subjectNum) {
        super(CmmItembank.CMM_ITEMBANK);

        set(0, id);
        set(1, questionTitle);
        set(2, optionA);
        set(3, optionB);
        set(4, optionC);
        set(5, optionD);
        set(6, optionE);
        set(7, optionF);
        set(8, addTime);
        set(9, acticleName);
        set(10, pageNum);
        set(11, subjectNum);
    }

    public CmmItembankRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public CmmItembankRecord fromJson(io.vertx.core.json.JsonObject json) {
        try {
            setId(json.getLong("ID"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ID","java.lang.Long",e);
        }
        try {
            setQuestionTitle(json.getString("QUESTION_TITLE"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("QUESTION_TITLE","java.lang.String",e);
        }
        try {
            setOptionA(json.getString("OPTION_A"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_A","java.lang.String",e);
        }
        try {
            setOptionB(json.getString("OPTION_B"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_B","java.lang.String",e);
        }
        try {
            setOptionC(json.getString("OPTION_C"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_C","java.lang.String",e);
        }
        try {
            setOptionD(json.getString("OPTION_D"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_D","java.lang.String",e);
        }
        try {
            setOptionE(json.getString("OPTION_E"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_E","java.lang.String",e);
        }
        try {
            setOptionF(json.getString("OPTION_F"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("OPTION_F","java.lang.String",e);
        }
        try {
            // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ADD_TIME","java.time.LocalDateTime",e);
        }
        try {
            setActicleName(json.getString("ACTICLE_NAME"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("ACTICLE_NAME","java.lang.String",e);
        }
        try {
            setPageNum(json.getInteger("PAGE_NUM"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("PAGE_NUM","java.lang.Integer",e);
        }
        try {
            setSubjectNum(json.getInteger("SUBJECT_NUM"));
        } catch (java.lang.ClassCastException e) {
            throw new UnexpectedJsonValueType("SUBJECT_NUM","java.lang.Integer",e);
        }
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("ID",getId());
        json.put("QUESTION_TITLE",getQuestionTitle());
        json.put("OPTION_A",getOptionA());
        json.put("OPTION_B",getOptionB());
        json.put("OPTION_C",getOptionC());
        json.put("OPTION_D",getOptionD());
        json.put("OPTION_E",getOptionE());
        json.put("OPTION_F",getOptionF());
        // Omitting unrecognized type java.time.LocalDateTime for column ADD_TIME!
        json.put("ACTICLE_NAME",getActicleName());
        json.put("PAGE_NUM",getPageNum());
        json.put("SUBJECT_NUM",getSubjectNum());
        return json;
    }

}