package com.karbide.iSettle.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
@Table(
        indexes = {
                @Index(columnList = "src_acc_id", name = "src_acc_id"),
                @Index(columnList = "tgt_acc_id", name = "tgt_acc_id")
        })
public class AccountTransaction implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private Long trans_id;
    private Long src_acc_id;
    private Long tgt_acc_id;
    private float amt;
    private String trn_type;
    private String trn_status;
    private boolean trn_visible;
    private String trn_category;
    private int trn_remind_days;
    private String trn_pic;
    private String trn_notes;
    private Date update_time;
    private Date create_time;
    private String currency_code;
    private TransactionType transactionType;
    private TransactionCategory transactionCategory;
    private TransactionStatus transactionStatus;
    private CurrencyMaster currencyMaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Long trans_id) {
        this.trans_id = trans_id;
    }

    public Long getSrc_acc_id() {
        return src_acc_id;
    }

    public void setSrc_acc_id(Long src_acc_id) {
        this.src_acc_id = src_acc_id;
    }

    public Long getTgt_acc_id() {
        return tgt_acc_id;
    }

    public void setTgt_acc_id(Long tgt_acc_id) {
        this.tgt_acc_id = tgt_acc_id;
    }

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
    }

    public String getTrn_type() {
        return trn_type;
    }

    public void setTrn_type(String trn_type) {
        this.trn_type = trn_type;
    }

    public String getTrn_status() {
        return trn_status;
    }

    public void setTrn_status(String trn_status) {
        this.trn_status = trn_status;
    }

    public boolean isTrn_visible() {
        return trn_visible;
    }

    public void setTrn_visible(boolean trn_visible) {
        this.trn_visible = trn_visible;
    }

    public String getTrn_category() {
        return trn_category;
    }

    public void setTrn_category(String trn_category) {
        this.trn_category = trn_category;
    }

    public int getTrn_remind_days() {
        return trn_remind_days;
    }

    public void setTrn_remind_days(int trn_remind_days) {
        this.trn_remind_days = trn_remind_days;
    }

    public String getTrn_pic() {
        return trn_pic;
    }

    public void setTrn_pic(String trn_pic) {
        this.trn_pic = trn_pic;
    }

    public String getTrn_notes() {
        return trn_notes;
    }

    public void setTrn_notes(String trn_notes) {
        this.trn_notes = trn_notes;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "trn_type")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "trn_category")
    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "trn_status")
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public CurrencyMaster getCurrencyMaster() {
        return currencyMaster;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "trn_status")
    public void setCurrencyMaster(CurrencyMaster currencyMaster) {
        this.currencyMaster = currencyMaster;
    }
}
