package com.karbide.iSettle.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * Created by deepeshuniyal on 03/12/16.
 */

@Entity
public class UserDeviceInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userid;
    private String device_id;
    private String ph_no;
    private String device_google_code;
    private String device_imei;
    private String device_adv_id;
    private String device_brand;
    private String device_make;
    private boolean active;
    private Date create_time;
    private Date update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getDevice_google_code() {
        return device_google_code;
    }

    public void setDevice_google_code(String device_google_code) {
        this.device_google_code = device_google_code;
    }

    public String getDevice_imei() {
        return device_imei;
    }

    public void setDevice_imei(String device_imei) {
        this.device_imei = device_imei;
    }

    public String getDevice_adv_id() {
        return device_adv_id;
    }

    public void setDevice_adv_id(String device_adv_id) {
        this.device_adv_id = device_adv_id;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String device_brand) {
        this.device_brand = device_brand;
    }

    public String getDevice_make() {
        return device_make;
    }

    public void setDevice_make(String device_make) {
        this.device_make = device_make;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
