package com.karbide.iSettle.repository;

import com.karbide.iSettle.model.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import  java.util.List;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Long> {

    @Query("select u from AccountTransaction u where u.src_acc_id= ?1")
    List<AccountTransaction> findBySrc_acc_id(Long src_acc_id);
    @Query("select u from AccountTransaction u where u.tgt_acc_id= ?1")
    List<AccountTransaction> findByTgt_acc_id(Long tgt_acc_id);
}
