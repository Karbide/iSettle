package com.karbide.iSettle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
public class TransactionType implements Serializable {

    @Id
    @GeneratedValue
    private int type;
    private String type_display_name;
    private boolean active;
    private Date update_time;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType_display_name() {
        return type_display_name;
    }

    public void setType_display_name(String type_display_name) {
        this.type_display_name = type_display_name;
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
