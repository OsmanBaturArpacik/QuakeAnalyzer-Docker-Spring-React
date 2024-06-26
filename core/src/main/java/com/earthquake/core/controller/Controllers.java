package com.earthquake.core.controller;

import com.earthquake.core.model.Models;
import com.earthquake.core.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
public class Controllers {

    private Services services;
    private Models models;
    @Autowired
    public Controllers(Services services, Models models ) {
        this.services = services;
        this.models = models;
    }
    @PostMapping("/routerName")
    @ResponseBody
    public ResponseEntity<String> test(@RequestBody Map<String, String> payload) {
        String lat = payload.get("lat");
        String lon = payload.get("lon");
        String intensity = payload.get("intensity");

        System.out.println("lat: " + lat);
        System.out.println("lon: " + lon);
        System.out.println("intensity: " + intensity);
        System.out.println();

        return ResponseEntity.status(OK).body("Success");
    }


//    @PostMapping("/analyzData")
//    @ResponseBody
//    public ResponseEntity<String> loginAuthentication(@RequestParam("x") String x, @RequestParam("y") String y) {
//        System.out.println("POSTING x:" + x + "\ny:" + y);
//        return ResponseEntity.status(OK).body("404-TESTING RN");
//    }
//    @GetMapping("/analyzeDatas")
//    @ResponseBody
//    public ResponseEntity<String> x(@RequestParam("x") String x, @RequestParam("y") String y) {
//        System.out.println("GETTING x:" + x + "\ny:" + y);
//        return ResponseEntity.status(UNAUTHORIZED).body("404-TESTING RN");
//    }
}

