package com.earthquake.core.controller;

import com.earthquake.core.model.Models;
import com.earthquake.core.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
public class Controllers {

    private Services services;
    private Models models;
    @Autowired
    public Controllers(Services services, Models models ) {
        this.services = services;
        this.models = models;
    }
    @PostMapping("/x")
    @ResponseBody
    public ResponseEntity<String> loginAuthentication(@RequestParam("x") String username, @RequestParam("y") String password) {
        return ResponseEntity.status(UNAUTHORIZED).body("404");
    }
}
