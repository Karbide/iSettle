package com.iSettle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
public class TransactionMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trn_id;
    private boolean active;
    private String currency_code;
    private Date create_time;
    private Date update_time;

    public Long getTrn_id() {
        return trn_id;
    }

    public void setTrn_id(Long trn_id) {
        this.trn_id = trn_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
