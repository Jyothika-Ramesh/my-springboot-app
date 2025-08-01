package com.springapps.projecta.controller;

import com.springapps.projecta.service.ProjectBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project-a")
public class ProjectAController {

    @Autowired
    private ProjectBClient projectBClient;

    @GetMapping("/call-b")
    public ResponseEntity<String> callB() {
        String result = projectBClient.callProjectB();
        return ResponseEntity.ok(result);
    }
}
