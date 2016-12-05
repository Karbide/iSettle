package com.karbide.iSettle.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karbide.iSettle.model.AccountTransaction;

import java.util.List;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccountDto {
    List<AmountCurrencyMap> amountCurrencyMapsGive;
    List<AmountCurrencyMap> amountCurrencyMapsTake;
    List<AccountTransaction> accountTransactions;
    List<UserDetailsFBInfoDto> userDetailsFBInfoDtos;

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

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public List<UserDetailsFBInfoDto> getUserDetailsFBInfoDtos() {
        return userDetailsFBInfoDtos;
    }

    public void setUserDetailsFBInfoDtos(List<UserDetailsFBInfoDto> userDetailsFBInfoDtos) {
        this.userDetailsFBInfoDtos = userDetailsFBInfoDtos;
    }
}
