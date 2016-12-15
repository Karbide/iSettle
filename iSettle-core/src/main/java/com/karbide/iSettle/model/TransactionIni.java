package com.karbide.iSettle.model;

/**
 * Created by deepeshuniyal on 06/12/16.
 */
public class TransactionIni {

    private Long user_id;
    private String ph_no;
    private float amt;
    private boolean trn_visible;
    private  int trn_remind_days;
    private String trn_pic;
    private String trn_notes;
    private int currency_code;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
    }

    public boolean isTrn_visible() {
        return trn_visible;
    }

    public void setTrn_visible(boolean trn_visible) {
        this.trn_visible = trn_visible;
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

    public void setTrn_notes(String trn_notes)
    {
        this.trn_notes = trn_notes;
    }

    public int getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(int currency_code) {
        this.currency_code = currency_code;
    }
}
