package com.earthquake.core.service;

import com.earthquake.core.model.EarthquakeLocationDataModel;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
    private final ActiveEarthquakeListService activeEarthquakeListService;

    public KafkaConsumerListener(ActiveEarthquakeListService activeEarthquakeListService) {
        this.activeEarthquakeListService = activeEarthquakeListService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        JSONObject jsonObject = new JSONObject(message);

        double lat = jsonObject.getDouble("latitude");
        double lon = jsonObject.getDouble("longitude");
        double intensity = jsonObject.getDouble("intensity");
        double timestamp = jsonObject.getDouble("timestamp");

        activeEarthquakeListService.addElement(new EarthquakeLocationDataModel(lat,lon,intensity,timestamp));
        System.out.println("Consumed Message: " + message);
    }
}
