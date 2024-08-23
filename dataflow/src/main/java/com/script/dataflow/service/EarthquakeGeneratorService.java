package com.script.dataflow.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EarthquakeGeneratorService {
    public String generate() {
        Random random = new Random();

        double latitude = random.nextDouble() * 180 - 90;       //  -90   <->   90
        double longitude = random.nextDouble() * 360 - 180;     //  -180  <->   180
        double intensity = random.nextDouble() * 10;             //  0     <->   10
        double timestamp = System.currentTimeMillis();

        System.out.println("Latitude: " + latitude + ", Longitude: " + longitude + ", Intensity: " + intensity + ", Timestamp:" + timestamp );

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude);
        jsonObject.put("intensity", intensity);
        jsonObject.put("timestamp", timestamp);

        return jsonObject.toString();
    }
}
