package com.earthquake.core.controller;

import com.earthquake.core.model.Models;
import com.earthquake.core.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controllers {

    private Services services;
    private Models models;
    @Autowired
    public Controllers(Services services, Models models ) {
        this.services = services;
        this.models = models;
    }
    @PostMapping("/analyzData")
    @ResponseBody
    public ResponseEntity<String> loginAuthentication(@RequestParam("x") String x, @RequestParam("y") String y) {
        System.out.println("POSTING x:" + x + "\ny:" + y);
        return ResponseEntity.status(OK).body("404-TESTING RN");
    }
    @GetMapping("/analyzeDatas")
    @ResponseBody
    public ResponseEntity<String> x(@RequestParam("x") String x, @RequestParam("y") String y) {
        System.out.println("GETTING x:" + x + "\ny:" + y);
        return ResponseEntity.status(UNAUTHORIZED).body("404-TESTING RN");
    }
}

