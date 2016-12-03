package com.karbide.iSettle.repository;

import com.karbide.iSettle.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
}
