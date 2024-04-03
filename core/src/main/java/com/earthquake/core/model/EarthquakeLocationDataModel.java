package com.earthquake.core.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class EarthquakeLocationDataModel {
    private double lat;
    private double lon;
    private double intensity;
    private double timestamp;
    public EarthquakeLocationDataModel(double lat, double lon, double intensity) {
        this.lat = lat;
        this.lon = lon;
        this.intensity = intensity;
        this.timestamp = System.currentTimeMillis();
    }
}
