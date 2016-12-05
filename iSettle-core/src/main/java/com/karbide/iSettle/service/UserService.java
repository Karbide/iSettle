package com.karbide.iSettle.service;

import com.karbide.iSettle.dto.UserAccountDto;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
public interface UserService {
    public UserAccountDto getUserData(Long userId);
}
