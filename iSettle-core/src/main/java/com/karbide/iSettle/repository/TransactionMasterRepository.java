package com.karbide.iSettle.repository;

import com.karbide.iSettle.model.TransactionMaster;
import com.karbide.iSettle.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Repository
public interface TransactionMasterRepository extends JpaRepository<TransactionMaster, Long> {

}
