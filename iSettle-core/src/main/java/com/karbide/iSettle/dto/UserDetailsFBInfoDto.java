package com.karbide.iSettle.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.karbide.iSettle.model.AccountTransaction;

import java.util.List;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsFBInfoDto {

    private Long userId;
    private String name;
    private String picture;
    private String ph_no;
    @JsonIgnore
    private Long acc_id;
    List<AmountCurrencyMap> amountCurrencyMapsGive;
    List<AmountCurrencyMap> amountCurrencyMapsTake;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public List<AmountCurrencyMap> getAmountCurrencyMapsGive() {
        return amountCurrencyMapsGive;
    }

    public void setAmountCurrencyMapsGive(List<AmountCurrencyMap> amountCurrencyMapsGive) {
        this.amountCurrencyMapsGive = amountCurrencyMapsGive;
    }

    public List<AmountCurrencyMap> getAmountCurrencyMapsTake() {
        return amountCurrencyMapsTake;
    }

    public void setAmountCurrencyMapsTake(List<AmountCurrencyMap> amountCurrencyMapsTake) {
        this.amountCurrencyMapsTake = amountCurrencyMapsTake;
    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailsFBInfoDto that = (UserDetailsFBInfoDto) o;

        return getAcc_id() != null ? getAcc_id().equals(that.getAcc_id()) : that.getAcc_id() == null;

    }

    @Override
    public int hashCode() {
        return getAcc_id() != null ? getAcc_id().hashCode() : 0;
    }
}
