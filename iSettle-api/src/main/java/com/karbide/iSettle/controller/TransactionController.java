package com.karbide.iSettle.controller;

import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.model.*;
import com.karbide.iSettle.repository.AccountTransactionRepository;
import com.karbide.iSettle.repository.PhNoAccIdMapRepository;
import com.karbide.iSettle.repository.TransactionMasterRepository;
import com.karbide.iSettle.repository.UserDetailsRepository;
import com.karbide.iSettle.service.TransactionService;
import com.karbide.iSettle.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by deepeshuniyal on 03/12/16.
 */
@RestController
@RequestMapping("/user")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "For the Amount Given", notes = "")
    @RequestMapping(method = RequestMethod.POST)
    public void user(@RequestBody @Valid TransactionIni transactionIni) {

        transactionService.transaction(transactionIni);
        //return new ResponseBody(HttpStatus.OK);

    }
}