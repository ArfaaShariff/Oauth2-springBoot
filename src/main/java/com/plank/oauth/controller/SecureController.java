package com.plank.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by plank-arfaa on 2/3/2016.
 */

@RestController
public class SecureController {
    @RequestMapping("/secure")
    public String secure(){
        return  "Hello User!";
    }
}
