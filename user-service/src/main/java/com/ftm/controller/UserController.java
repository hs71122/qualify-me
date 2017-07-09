package com.ftm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by awharshana on 7/9/2017.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/test")
    public String testUserReturn(){
        return "Test User";
    }
}
