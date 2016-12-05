package com.karbide.iSettle.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karbide.iSettle.model.AccountTransaction;

import java.util.List;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsFBInfoDto {

    private String name;
    private String picture;

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
}