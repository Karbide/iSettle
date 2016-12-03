package com.karbide.iSettle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by deepeshuniyal on 03/12/16.
 * */
@RestController
public class TestController {


    @RequestMapping("/testing")
    public ResponseEntity<?> testController(){
        return new ResponseEntity("", HttpStatus.OK);
    }
}
