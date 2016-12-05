package com.karbide.iSettle.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Entity
public class UserDetails implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String login_app_id;
    private String picture;
    private Long acc_id;
    private Date last_login;
    private Long status;
    private Date create_time;
    private Date update_time;
    private String ph_no;

    private UserStatus userStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin_app_id() {
        return login_app_id;
    }

    public void setLogin_app_id(String login_app_id) {
        this.login_app_id = login_app_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public void setUpdate_time(Date update_time)
    {
        this.update_time = update_time;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "status")
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

   @PrePersist
    protected void insertDates() {
        if (create_time == null) {
            create_time = new Date();
            update_time = new Date();
            last_login = new Date();
        }
    }

    /*@PreUpdate
    protected void updateDates() {
        if (updatedTime == null) {
            updatedTime = new Date();
        }
    }*/

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login_app_id='" + login_app_id + '\'' +
                ", picture='" + picture + '\'' +
                ", acc_id=" + acc_id +
                ", last_login=" + last_login +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", ph_no='" + ph_no + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
