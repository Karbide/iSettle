package com.karbide.iSettle.service.impl;

import com.karbide.iSettle.dto.AccountTransactionDto;
import com.karbide.iSettle.dto.AmountCurrencyMap;
import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.dto.UserDetailsFBInfoDto;
import com.karbide.iSettle.model.AccountTransaction;
import com.karbide.iSettle.model.PhNoAccIdMap;
import com.karbide.iSettle.model.UserDetails;
import com.karbide.iSettle.repository.AccountTransactionRepository;
import com.karbide.iSettle.repository.PhNoAccIdMapRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import com.karbide.iSettle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
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
    @Autowired
    private PhNoAccIdMapRepository phNoAccIdMapRepository;

    @Override
    public UserAccountDto getUserData(Long userId) {
        UserDetails userDetails = userDetailsRepository.findOne(userId);
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        List<AccountTransaction> accountTransactionsSrc = accountTransactionRepository.findBySrc_acc_id(userDetails.getAcc_id(),integers);
        integers = new ArrayList<>();
        integers.add(3);
        integers.add(4);
        List<AccountTransaction> accountTransactionsTgt = accountTransactionRepository.findBySrc_acc_id(userDetails.getAcc_id(),integers);
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setUserDetailsFBInfoDtos(new ArrayList<UserDetailsFBInfoDto>());
        if(accountTransactionsSrc != null) {

            for (AccountTransaction accountTransaction1 : accountTransactionsSrc) {
                UserDetailsFBInfoDto userDetailsFBInfoDto = new UserDetailsFBInfoDto();
                userDetailsFBInfoDto.setAcc_id(accountTransaction1.getTgt_acc_id());
                int index = userAccountDto.getUserDetailsFBInfoDtos().indexOf(userDetailsFBInfoDto);
                if (index > -1) {
                    UserDetailsFBInfoDto  userDetailsFBInfoDto1 = userAccountDto.getUserDetailsFBInfoDtos().get(index);
                    AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                    amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrency_code());
                    index = userDetailsFBInfoDto1.getAmountCurrencyMapsGive().indexOf(amountCurrencyMap);
                    if(userDetailsFBInfoDto1!=null && index>-1){
                        amountCurrencyMap = userDetailsFBInfoDto1.getAmountCurrencyMapsGive().get(index);
                        amountCurrencyMap.setAmt( amountCurrencyMap.getAmt()+accountTransaction1.getAmt());
                    }
                    else{
                        amountCurrencyMap.setAmt(accountTransaction1.getAmt());
                        userDetailsFBInfoDto1.getAmountCurrencyMapsGive().add(amountCurrencyMap);
                    }

                } else {
                    AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                    amountCurrencyMap.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrency_code());
                    List<AmountCurrencyMap> amountCurrencyMapsGive = new ArrayList<AmountCurrencyMap>();
                    amountCurrencyMapsGive.add(amountCurrencyMap);
                    UserDetailsFBInfoDto userDetailsFBInfoDto1 = new UserDetailsFBInfoDto();
                    userDetailsFBInfoDto1.setAmountCurrencyMapsGive(amountCurrencyMapsGive);
                    userDetailsFBInfoDto1.setAcc_id(accountTransaction1.getTgt_acc_id());
                    setFBDetails(userDetailsFBInfoDto1);
                    userAccountDto.getUserDetailsFBInfoDtos().add(userDetailsFBInfoDto1);
                }
            }

        }


        if(accountTransactionsTgt != null) {

            for (AccountTransaction accountTransaction1 : accountTransactionsTgt) {
                UserDetailsFBInfoDto userDetailsFBInfoDto = new UserDetailsFBInfoDto();
                userDetailsFBInfoDto.setAcc_id(accountTransaction1.getSrc_acc_id());
                int index = userAccountDto.getUserDetailsFBInfoDtos().indexOf(userDetailsFBInfoDto);
                if (index > -1) {
                    UserDetailsFBInfoDto  userDetailsFBInfoDto1 = userAccountDto.getUserDetailsFBInfoDtos().get(index);
                    AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                    amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrency_code());
                    index = userDetailsFBInfoDto1.getAmountCurrencyMapsTake().indexOf(amountCurrencyMap);
                    if(userDetailsFBInfoDto1!=null && index>-1){
                        amountCurrencyMap = userDetailsFBInfoDto1.getAmountCurrencyMapsTake().get(index);
                        amountCurrencyMap.setAmt( amountCurrencyMap.getAmt()+accountTransaction1.getAmt());
                    }
                    else{
                        amountCurrencyMap.setAmt(accountTransaction1.getAmt());
                        userDetailsFBInfoDto1.getAmountCurrencyMapsTake().add(amountCurrencyMap);
                    }

                } else {
                    AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                    amountCurrencyMap.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrency_code());
                    List<AmountCurrencyMap> amountCurrencyMapsTake = new ArrayList<AmountCurrencyMap>();
                    amountCurrencyMapsTake.add(amountCurrencyMap);
                    UserDetailsFBInfoDto userDetailsFBInfoDto1 = new UserDetailsFBInfoDto();
                    userDetailsFBInfoDto1.setAmountCurrencyMapsTake(amountCurrencyMapsTake);
                    userDetailsFBInfoDto1.setAmountCurrencyMapsTake(amountCurrencyMapsTake);
                    userDetailsFBInfoDto1.setAcc_id(accountTransaction1.getSrc_acc_id());
                    setFBDetails(userDetailsFBInfoDto1);
                    userAccountDto.getUserDetailsFBInfoDtos().add(userDetailsFBInfoDto1);

                }
            }

        }
        return userAccountDto;
    }

    public void setFBDetails(UserDetailsFBInfoDto userDetailsFBInfoDto1) {
        UserDetails userDetailses = userDetailsRepository.findByAcc_id(userDetailsFBInfoDto1.getAcc_id());
        if(userDetailses!=null){
            userDetailsFBInfoDto1.setUserId(userDetailses.getId());
            userDetailsFBInfoDto1.setName(userDetailses.getName());
            userDetailsFBInfoDto1.setPh_no(userDetailses.getPh_no());
            userDetailsFBInfoDto1.setPicture(userDetailses.getPicture());
        }
        else {
            PhNoAccIdMap phNoAccIdMap =phNoAccIdMapRepository.findByAccId(userDetailsFBInfoDto1.getAcc_id());
            userDetailsFBInfoDto1.setPh_no(phNoAccIdMap.getPh_no());
        }
    }
    /*public UserAccountDto getUserData1(Long userId) {
        UserDetails userDetails = userDetailsRepository.findOne(userId);
        List<AccountTransaction> accountTransactionsSrc = null;//accountTransactionRepository.findBySrc_acc_id(userDetails.getAcc_id());
        List<AccountTransaction> accountTransactionsTgt = null;//accountTransactionRepository.findByTgt_acc_id(userDetails.getAcc_id());
        List<AccountTransactionDto> accountTransactionsAll = new ArrayList<>();
        List<AccountTransactionDto> accountTransactionsAllSrc = new ArrayList<>();
        List<AccountTransactionDto> accountTransactionsAllTgt = new ArrayList<>();
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setAmountCurrencyMapsGive(new ArrayList<AmountCurrencyMap>());
        userAccountDto.setAmountCurrencyMapsTake(new ArrayList<AmountCurrencyMap>());
        List<Long> userAcc_id = new ArrayList<>();
        if(accountTransactionsSrc != null){

            for(AccountTransaction accountTransaction1 : accountTransactionsSrc) {
                AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                int index = userAccountDto.getAmountCurrencyMapsGive().indexOf(amountCurrencyMap);
                if(index>-1){
                    AmountCurrencyMap amountCurrencyMap1 = userAccountDto.getAmountCurrencyMapsGive().get(index);
                    amountCurrencyMap1.setAmt(amountCurrencyMap1.getAmt()+accountTransaction1.getAmt());
                }
                else
                {
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap1.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                    userAccountDto.getAmountCurrencyMapsGive().add(amountCurrencyMap1);
                }
                userAcc_id.add(accountTransaction1.getTgt_acc_id());
                //accountTransactionsAll.addAll(accountTransactionsSrc);

                AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
                accountTransactionDto.setId_src_tgt(accountTransaction1.getTgt_acc_id());
                accountTransactionDto.setAmt(accountTransaction1.getAmt());
                accountTransactionDto.setCategory_display_name(accountTransaction1.getTransactionCategory().getCategory_display_name());
                accountTransactionDto.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                accountTransactionDto.setStatus_display_name(accountTransaction1.getTransactionStatus().getStatus_display_name());
                accountTransactionDto.setTrn_notes(accountTransaction1.getTrn_notes());
                accountTransactionDto.setTrn_pic(accountTransaction1.getTrn_pic());
                accountTransactionsAllSrc.add(accountTransactionDto);
            }
        }
        if(accountTransactionsTgt != null) {

            for (AccountTransaction accountTransaction1 : accountTransactionsTgt) {
                AmountCurrencyMap amountCurrencyMap = new AmountCurrencyMap();
                amountCurrencyMap.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                int index = userAccountDto.getAmountCurrencyMapsTake().indexOf(amountCurrencyMap);
                if (index > -1) {
                    AmountCurrencyMap amountCurrencyMap1 = userAccountDto.getAmountCurrencyMapsTake().get(index);
                    amountCurrencyMap1.setAmt(amountCurrencyMap1.getAmt() + accountTransaction1.getAmt());
                } else {
                    AmountCurrencyMap amountCurrencyMap1 = new AmountCurrencyMap();
                    amountCurrencyMap1.setAmt(accountTransaction1.getAmt());
                    amountCurrencyMap1.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                    userAccountDto.getAmountCurrencyMapsTake().add(amountCurrencyMap1);
                }
                userAcc_id.add(accountTransaction1.getSrc_acc_id());
                //accountTransactionsAll.addAll(accountTransactionsTgt);

                AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
                accountTransactionDto.setId_src_tgt(accountTransaction1.getSrc_acc_id());
                accountTransactionDto.setAmt(accountTransaction1.getAmt());
                accountTransactionDto.setCategory_display_name(accountTransaction1.getTransactionCategory().getCategory_display_name());
                accountTransactionDto.setCurrency_code(accountTransaction1.getCurrencyMaster().getCurrency_code());
                accountTransactionDto.setStatus_display_name(accountTransaction1.getTransactionStatus().getStatus_display_name());
                accountTransactionDto.setTrn_notes(accountTransaction1.getTrn_notes());
                accountTransactionDto.setTrn_pic(accountTransaction1.getTrn_pic());
                accountTransactionsAllTgt.add(accountTransactionDto);

            }
        }

        //remove the transactionId from tgt
        if(accountTransactionsAllSrc == null) {
            accountTransactionsAll = accountTransactionsAllTgt;
        }
        else if(accountTransactionsAllTgt == null) {
            accountTransactionsAll = accountTransactionsAllSrc;
        }
        else {
            accountTransactionsAllTgt.removeAll(accountTransactionsAllSrc);
            accountTransactionsAllSrc.addAll(accountTransactionsAllTgt);
            accountTransactionsAll = accountTransactionsAllSrc;
        }

        ///////////////////userAccountDto.setAccountTransactionsDto(accountTransactionsAll);
        List<UserDetails> userDetailses = userDetailsRepository.findByAcc_id(userAcc_id);
        List<UserDetailsFBInfoDto> userDetailsFBInfoDtos=new ArrayList<>();
        for(UserDetails userDetails1:userDetailses){
            UserDetailsFBInfoDto userDetailsFBInfoDto = new UserDetailsFBInfoDto();
            userDetailsFBInfoDto.setUserId(userDetails1.getId());
            if(userDetailsFBInfoDtos.indexOf(userDetailsFBInfoDto)>-1){
                continue;
            }
            userDetailsFBInfoDto.setName(userDetails1.getName());
            userDetailsFBInfoDto.setPicture(userDetails1.getPicture());
            userDetailsFBInfoDtos.add(userDetailsFBInfoDto);
        }
        userAccountDto.setUserDetailsFBInfoDtos(userDetailsFBInfoDtos);
        return userAccountDto;
    }*/

}
