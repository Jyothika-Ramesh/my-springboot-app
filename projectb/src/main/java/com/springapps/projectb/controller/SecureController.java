package com.springapps.projectb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecureController {
    @GetMapping("/data")
    public String getSecureData() {
        return "This is secured data from Project B!";
    }
}

