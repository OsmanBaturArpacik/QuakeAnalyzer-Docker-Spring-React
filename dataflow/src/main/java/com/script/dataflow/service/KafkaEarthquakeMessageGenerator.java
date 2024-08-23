package com.script.dataflow.service;

import org.springframework.stereotype.Service;

@Service
public class KafkaEarthquakeMessageGenerator {
    private final ProducerService producerService;
    private final EarthquakeGeneratorService earthquakeGeneratorService;

    public KafkaEarthquakeMessageGenerator(ProducerService producerService, EarthquakeGeneratorService earthquakeGeneratorService) {
        this.producerService = producerService;
        this.earthquakeGeneratorService = earthquakeGeneratorService;
    }

    public void earthquakeDataGenerator() {
        new Thread(() -> {
            while (true) {
                producerService.sendMessage(earthquakeGeneratorService.generate());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }).start();
    }
}
