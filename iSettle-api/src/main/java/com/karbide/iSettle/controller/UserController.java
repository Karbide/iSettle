package com.karbide.iSettle.controller;

import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.model.AccountTransaction;
import com.karbide.iSettle.model.UserDetails;
import com.karbide.iSettle.repository.AccountTransactionRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import com.karbide.iSettle.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Registion time Hit", notes = "Only Send the 'email,login_app_id,name,picture' paramter")
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public UserAccountDto user(@PathVariable("userId") Long userId) {
        LOGGER.info("User GET Request userId-"+userId);
        UserAccountDto userAccountDto = userService.getUserData(userId);
        return userAccountDto;

    }
}