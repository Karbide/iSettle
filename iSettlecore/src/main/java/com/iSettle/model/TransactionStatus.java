package com.iSettle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
public class TransactionStatus implements Serializable {

    @Id
    @GeneratedValue
    private Long status;
    private String status_display_name;
    private boolean active;
    private Date update_time;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatus_display_name() {
        return status_display_name;
    }

    public void setStatus_display_name(String status_display_name) {
        this.status_display_name = status_display_name;
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
