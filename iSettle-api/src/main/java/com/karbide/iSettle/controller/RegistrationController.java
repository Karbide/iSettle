package com.karbide.iSettle.controller;

import com.karbide.iSettle.model.PhNoAccIdMap;
import com.karbide.iSettle.model.UserDetails;
import com.karbide.iSettle.repository.PhNoAccIdMapRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PhNoAccIdMapRepository phNoAccIdMapRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Registion time Hit", notes = "Only Send the 'id=0,email,login_app_id,name,picture' paramter")
    public Long registration(@RequestBody @Valid UserDetails userDetails) {
        //Card created = service.create(card);
        LOGGER.info("Registration Request-"+userDetails);

        userDetails.setStatus(1);
        UserDetails userDetails1 = userDetailsRepository.findByLoginAppId(userDetails.getLogin_app_id());
        if(userDetails1!=null) {
            userDetails1.setUpdate_time(new Date());
            userDetails1.setLast_login(new Date());
            userDetails1.setName(userDetails.getName());
            userDetails1.setEmail(userDetails.getEmail());
            userDetails1.setPh_no(userDetails.getPh_no());
            userDetails1.setPicture(userDetails.getPicture());
            userDetails1.setLogin_app_id(userDetails.getLogin_app_id());
            userDetails1.setStatus(1);
            userDetails = userDetailsRepository.save(userDetails1);
        }
        else{

            //If this Account Id allready created for some others account
            PhNoAccIdMap phNoAccIdMap = phNoAccIdMapRepository.findByPhno(userDetails.getPh_no());
            if (phNoAccIdMap != null) {

                userDetails.setAcc_id(phNoAccIdMap.getAcc_id());
            } else {
                userDetails.setAcc_id(System.currentTimeMillis());
            }
            userDetails = userDetailsRepository.save(userDetails);
        }
        return userDetails.getId();
    }
}