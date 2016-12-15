package com.karbide.iSettle.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by deepeshuniyal on 06/12/16.
 */
@Entity
public class PhNoAccIdMap implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String ph_no;
        private Long acc_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }
}
