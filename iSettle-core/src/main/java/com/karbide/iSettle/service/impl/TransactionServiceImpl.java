package com.karbide.iSettle.service.impl;

import com.karbide.iSettle.dto.AccountTransactionDto;
import com.karbide.iSettle.dto.AmountCurrencyMap;
import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.dto.UserDetailsFBInfoDto;
import com.karbide.iSettle.model.*;
import com.karbide.iSettle.repository.AccountTransactionRepository;
import com.karbide.iSettle.repository.PhNoAccIdMapRepository;
import com.karbide.iSettle.repository.TransactionMasterRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import com.karbide.iSettle.service.TransactionService;
import com.karbide.iSettle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by deepeshuniyal on 04/12/16.
 */

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountTransactionRepository accountTransactionRepository;
    @Autowired
    private PhNoAccIdMapRepository phNoAccIdMapRepository;
    @Autowired
    private TransactionMasterRepository transactionMasterRepository;

    @Override
    public void transaction(TransactionIni transactionIni) {
        UserDetails userDetails = userDetailsRepository.findOne(transactionIni.getUser_id());
        Long bpartyAcc_id;
        UserDetails userDetails1 = userDetailsRepository.findByPhNo(transactionIni.getPh_no());
        if(userDetails1 != null){
            bpartyAcc_id = userDetails1.getAcc_id();
        }
        else {
            PhNoAccIdMap phNoAccIdMap = phNoAccIdMapRepository.findByPhno(transactionIni.getPh_no());


            if (phNoAccIdMap != null) {
                bpartyAcc_id = phNoAccIdMap.getAcc_id();
            } else {
                bpartyAcc_id = System.currentTimeMillis();
                phNoAccIdMap = new PhNoAccIdMap();
                phNoAccIdMap.setPh_no(transactionIni.getPh_no());
                phNoAccIdMap.setAcc_id(bpartyAcc_id);
                phNoAccIdMapRepository.save(phNoAccIdMap);
            }
        }

        TransactionMaster transactionMaster = new TransactionMaster();
        transactionMaster.setActive(true);
        transactionMaster.setCurrency_code(transactionIni.getCurrency_code());
        transactionMaster.setCreate_time(new Date());
        transactionMaster.setUpdate_time(new Date());
        transactionMasterRepository.save(transactionMaster);

        AccountTransaction accountTransactionSrc = new AccountTransaction();
        accountTransactionSrc.setAmt(transactionIni.getAmt());
        accountTransactionSrc.setCreate_time(new Date());
        accountTransactionSrc.setCurrency_code(transactionIni.getCurrency_code());
        accountTransactionSrc.setSrc_acc_id(userDetails.getAcc_id());
        accountTransactionSrc.setTgt_acc_id(bpartyAcc_id);
        accountTransactionSrc.setTrans_id(transactionMaster.getTrn_id());
        accountTransactionSrc.setTrn_category(1);
        accountTransactionSrc.setTrn_notes(transactionIni.getTrn_notes());
        accountTransactionSrc.setTrn_pic(transactionIni.getTrn_pic());
        accountTransactionSrc.setTrn_remind_days(transactionIni.getTrn_remind_days());
        accountTransactionSrc.setTrn_visible(transactionIni.isTrn_visible());
        accountTransactionSrc.setTrn_status(1);
        accountTransactionSrc.setTrn_type(1);
        accountTransactionSrc.setTrn_visible(true);
        accountTransactionSrc.setUpdate_time(new Date());
        accountTransactionRepository.save(accountTransactionSrc);


        AccountTransaction accountTransactionTrg = new AccountTransaction();
        accountTransactionTrg.setAmt(transactionIni.getAmt());
        accountTransactionTrg.setCreate_time(new Date());
        accountTransactionTrg.setCurrency_code(transactionIni.getCurrency_code());
        accountTransactionTrg.setSrc_acc_id(bpartyAcc_id);
        accountTransactionTrg.setTgt_acc_id(userDetails.getAcc_id());
        accountTransactionTrg.setTrans_id(transactionMaster.getTrn_id());
        accountTransactionTrg.setTrn_category(3);
        accountTransactionTrg.setTrn_notes(transactionIni.getTrn_notes());
        accountTransactionTrg.setTrn_pic(transactionIni.getTrn_pic());
        accountTransactionTrg.setTrn_remind_days(transactionIni.getTrn_remind_days());
        accountTransactionTrg.setTrn_visible(transactionIni.isTrn_visible());
        accountTransactionTrg.setTrn_status(1);
        accountTransactionTrg.setTrn_type(1);
        accountTransactionTrg.setTrn_visible(transactionIni.isTrn_visible());
        accountTransactionTrg.setUpdate_time(new Date());
        accountTransactionRepository.save(accountTransactionTrg);
    }
}
