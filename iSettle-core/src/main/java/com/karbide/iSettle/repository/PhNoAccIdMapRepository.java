package com.karbide.iSettle.repository;

import com.karbide.iSettle.model.PhNoAccIdMap;
import com.karbide.iSettle.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Repository
public interface PhNoAccIdMapRepository extends JpaRepository<PhNoAccIdMap, Long> {

        @Query("select u from PhNoAccIdMap u where u.ph_no= ?1")
        public PhNoAccIdMap findByPhno(String ph_no);
        @Query("select u from PhNoAccIdMap u where u.acc_id= ?1")
        public PhNoAccIdMap findByAccId(Long acc_id);

}
