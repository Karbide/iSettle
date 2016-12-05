package com.karbide.iSettle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
public class CurrencyMaster implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int currency_code;
    private String currency_display_name;
    private boolean active;
    private Date update_time;

    public int getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(int currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_display_name() {
        return currency_display_name;
    }

    public void setCurrency_display_name(String currency_display_name) {
        this.currency_display_name = currency_display_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
