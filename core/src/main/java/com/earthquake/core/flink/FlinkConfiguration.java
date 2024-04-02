//package com.earthquake.core.flink;
//
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FlinkConfiguration {
//    public static void main(String[] args) {
//        SpringApplication.run(FlinkConfiguration.class, args);
//    }
//    @Bean
//    public StreamExecutionEnvironment flinkStreamExecutionEnvironment() {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(4);
//        return env;
////        return StreamExecutionEnvironment.getExecutionEnvironment();
//    }
//}
