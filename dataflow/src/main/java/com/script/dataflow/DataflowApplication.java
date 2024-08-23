package com.script.dataflow;

import com.script.dataflow.service.KafkaEarthquakeMessageGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataflowApplication implements CommandLineRunner {
	private final KafkaEarthquakeMessageGenerator generate;

    public DataflowApplication(KafkaEarthquakeMessageGenerator generate) {
        this.generate = generate;
    }

    public static void main(String[] args) {
		SpringApplication.run(DataflowApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
		generate.earthquakeDataGenerator();
    }
}
