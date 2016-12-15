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
public class TransactionCategory implements Serializable {

    @Id
    @GeneratedValue
    private int category;
    private String category_display_name;
    private boolean active;
    private Date update_time;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCategory_display_name() {
        return category_display_name;
    }

    public void setCategory_display_name(String category_display_name) {
        this.category_display_name = category_display_name;
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
