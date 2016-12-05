package com.karbide.iSettle.service.impl;

import com.karbide.iSettle.dto.AmountCurrencyMap;
import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.dto.UserDetailsFBInfoDto;
import com.karbide.iSettle.model.AccountTransaction;
import com.karbide.iSettle.model.UserDetails;
import com.karbide.iSettle.repository.AccountTransactionRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import com.karbide.iSettle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepeshuniyal on 04/12/16.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private AccountTransactionRepository accountTransactionRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserAccountDto getUserData(Long userId) {
        UserDetails userDetails = userDetailsRepository.findOne(userId);
        List<AccountTransaction> accountTransactionsSrc = accountTransactionRepository.findBySrc_acc_id(userDetails.getAcc_id());
        List<AccountTransaction> accountTransactionsTgt = accountTransactionRepository.findByTgt_acc_id(userDetails.getAcc_id());
        List<AccountTransaction> accountTransactionsAll = new ArrayList<>();
        UserAccountDto userAccountDto = new UserAccountDto();
        List<Long> userAcc_id = new ArrayList<>();
        if(accountTransactionsSrc != null){

            for(AccountTransaction accountTransaction1 : accountTransactionsSrc) {
                AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                int index = userAccountDto.getAmountCurrencyMapsGive().indexOf(amountCurrencyMap);
                if(index>-1){
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(amountCurrencyMap1.getAmt()+accountTransaction1.getAmt());
                }
                else
                {
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap1.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                }
                userAcc_id.add(accountTransaction1.getTgt_acc_id());
                accountTransactionsAll.addAll(accountTransactionsSrc);
            }
        }
        if(accountTransactionsTgt != null) {

            for (AccountTransaction accountTransaction1 : accountTransactionsTgt) {
                AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                int index = userAccountDto.getAmountCurrencyMapsGive().indexOf(amountCurrencyMap);
                if (index > -1) {
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(amountCurrencyMap1.getAmt() + accountTransaction1.getAmt());
                } else {
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap1.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                }
                userAcc_id.add(accountTransaction1.getSrc_acc_id());
                accountTransactionsAll.addAll(accountTransactionsTgt);

            }
        }
        userAccountDto.setAccountTransactions(accountTransactionsAll);
        List<UserDetails> userDetailses = userDetailsRepository.findByAcc_id(userAcc_id);
        List<UserDetailsFBInfoDto> userDetailsFBInfoDtos=new ArrayList<>();
        for(UserDetails userDetails1:userDetailses){
            UserDetailsFBInfoDto userDetailsFBInfoDto = new UserDetailsFBInfoDto();
            userDetailsFBInfoDto.setName(userDetails1.getName());
            userDetailsFBInfoDto.setPicture(userDetails1.getPicture());
        }
        userAccountDto.setUserDetailsFBInfoDtos(userDetailsFBInfoDtos);
        return userAccountDto;
    }

}
