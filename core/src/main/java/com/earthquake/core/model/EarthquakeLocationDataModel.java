package com.earthquake.core.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class EarthquakeLocationDataModel {
    private double lat;
    private double lon;
    private double intensity;
    private double timestamp;
}
