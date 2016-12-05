package com.karbide.iSettle.repository;

import com.karbide.iSettle.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

        @Query("select u from UserDetails u where u.acc_id in (?1)")
        public List<UserDetails> findByAcc_id(List<Long> acc_id);

}
