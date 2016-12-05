package com.karbide.iSettle.dto;


/**
 * Created by deepeshuniyal on 03/12/16.
 */
public class AccountTransactionDto{

    private Long id_src_tgt;
    private float amt;
    private String trn_pic;
    private String trn_notes;
    private String type_display_name;
    private String category_display_name;
    private String status_display_name;
    private int currency_code;


    public Long getId_src_tgt() {
        return id_src_tgt;
    }

    public void setId_src_tgt(Long id_stc_tgt) {
        this.id_src_tgt = id_stc_tgt;
    }

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
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

    public String getType_display_name() {
        return type_display_name;
    }

    public void setType_display_name(String type_display_name) {
        this.type_display_name = type_display_name;
    }

    public String getCategory_display_name() {
        return category_display_name;
    }

    public void setCategory_display_name(String category_display_name) {
        this.category_display_name = category_display_name;
    }

    public String getStatus_display_name() {
        return status_display_name;
    }

    public void setStatus_display_name(String status_display_name) {
        this.status_display_name = status_display_name;
    }

    public int getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(int currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTransactionDto that = (AccountTransactionDto) o;

        if (getCurrency_code() != that.getCurrency_code()) return false;
        return getId_src_tgt() != null ? getId_src_tgt().equals(that.getId_src_tgt()) : that.getId_src_tgt() == null;

    }

    @Override
    public int hashCode() {
        int result = getId_src_tgt() != null ? getId_src_tgt().hashCode() : 0;
        result = 31 * result + getCurrency_code();
        return result;
    }
}
