/*
 * This file is generated by jOOQ.
 */
package io.kida.model.tables;


import io.kida.model.Keys;
import io.kida.model.Tools;
import io.kida.model.tables.records.Md5ChangeRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * md5转换明文表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Md5Change extends TableImpl<Md5ChangeRecord> {

    private static final long serialVersionUID = -601138723;

    /**
     * The reference instance of <code>tools.md5_change</code>
     */
    public static final Md5Change MD5_CHANGE = new Md5Change();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Md5ChangeRecord> getRecordType() {
        return Md5ChangeRecord.class;
    }

    /**
     * The column <code>tools.md5_change.ID</code>. id值
     */
    public final TableField<Md5ChangeRecord, Long> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "id值");

    /**
     * The column <code>tools.md5_change.MD5_CODE</code>. md5编码
     */
    public final TableField<Md5ChangeRecord, String> MD5_CODE = createField(DSL.name("MD5_CODE"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "md5编码");

    /**
     * The column <code>tools.md5_change.PLAIN_TEXT</code>. 明文
     */
    public final TableField<Md5ChangeRecord, String> PLAIN_TEXT = createField(DSL.name("PLAIN_TEXT"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "明文");

    /**
     * The column <code>tools.md5_change.STATUS</code>. 0:未转 1:已转
     */
    public final TableField<Md5ChangeRecord, Integer> STATUS = createField(DSL.name("STATUS"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "0:未转 1:已转");

    /**
     * Create a <code>tools.md5_change</code> table reference
     */
    public Md5Change() {
        this(DSL.name("md5_change"), null);
    }

    /**
     * Create an aliased <code>tools.md5_change</code> table reference
     */
    public Md5Change(String alias) {
        this(DSL.name(alias), MD5_CHANGE);
    }

    /**
     * Create an aliased <code>tools.md5_change</code> table reference
     */
    public Md5Change(Name alias) {
        this(alias, MD5_CHANGE);
    }

    private Md5Change(Name alias, Table<Md5ChangeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Md5Change(Name alias, Table<Md5ChangeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("md5转换明文表"), TableOptions.table());
    }

    public <O extends Record> Md5Change(Table<O> child, ForeignKey<O, Md5ChangeRecord> key) {
        super(child, key, MD5_CHANGE);
    }

    @Override
    public Schema getSchema() {
        return Tools.TOOLS;
    }

    @Override
    public Identity<Md5ChangeRecord, Long> getIdentity() {
        return Keys.IDENTITY_MD5_CHANGE;
    }

    @Override
    public UniqueKey<Md5ChangeRecord> getPrimaryKey() {
        return Keys.KEY_MD5_CHANGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<Md5ChangeRecord>> getKeys() {
        return Arrays.<UniqueKey<Md5ChangeRecord>>asList(Keys.KEY_MD5_CHANGE_PRIMARY);
    }

    @Override
    public Md5Change as(String alias) {
        return new Md5Change(DSL.name(alias), this);
    }

    @Override
    public Md5Change as(Name alias) {
        return new Md5Change(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Md5Change rename(String name) {
        return new Md5Change(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Md5Change rename(Name name) {
        return new Md5Change(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
