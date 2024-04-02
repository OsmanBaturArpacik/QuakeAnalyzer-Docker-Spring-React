//package com.earthquake.core.flink;
//
//import com.earthquake.core.Haversine;
//import org.apache.flink.api.common.functions.FilterFunction;
//import org.apache.flink.api.java.tuple.Tuple3;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class FlinkJobRunner {
//
//    @Autowired
//    private StreamExecutionEnvironment flinkStreamExecutionEnvironment;
//
//    public void runFlinkJob(Map<String, String> payload) throws Exception {
//        String lat = payload.get("lat");
//        String lon = payload.get("lon");
//        String intensity = payload.get("intensity");
//
//        Tuple3<Double, Double, Double> inputData = new Tuple3<>(Double.parseDouble(lat), Double.parseDouble(lon), Double.parseDouble(intensity));
//
//        List<Tuple3<Double, Double, Double>> previousData = new ArrayList<>();
//        previousData.add(inputData);
//
//        DataStream<Tuple3<Double, Double, Double>> inputStream = flinkStreamExecutionEnvironment.fromCollection(previousData);
//
//        FilterFunction<Tuple3<Double, Double, Double>> filterFunction = new FilterFunction<Tuple3<Double, Double, Double>>() {
//            @Override
//            public boolean filter(Tuple3<Double, Double, Double> value) throws Exception {
//                for (Tuple3<Double, Double, Double> previous : previousData) {
//                    double latPrevious = previous.f0; // Önceki latitude
//                    double lonPrevious = previous.f1; // Önceki longitude
//
//                    double lat = value.f0;
//                    double lon = value.f1;
//                    double distance = Haversine.CalculateDistance(lat, lon, latPrevious, lonPrevious);
//
//                    if (distance <= 50) {
//                        System.out.println("50true");
//                        return true;
//                    }
//                }
//                System.out.println("50false");
//                return false;
//            }
//        };
//
//        DataStream<Tuple3<Double, Double, Double>> filteredStream = inputStream.filter(filterFunction);
//
//        filteredStream.print();
//
//        if(1!=2){
//            flinkStreamExecutionEnvironment.execute("Flink Job");
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
////
////import org.apache.flink.streaming.api.datastream.DataStream;
////import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Component;
////
////import java.util.Map;
////
////@Component
////public class FlinkJobRunner {
////
////    @Autowired
////    private StreamExecutionEnvironment flinkStreamExecutionEnvironment;
////
////    public void runFlinkJob(Map<String, String> payload) throws Exception {
////        String lat = payload.get("lat");
////        String lon = payload.get("lon");
////        String intensity = payload.get("intensity");
////
////        DataStream<String> processedStream = flinkStreamExecutionEnvironment
////                .fromElements(lat, lon, intensity)
////                .map(data -> "Lat: " + data + ", Lon: " + data + ", Intensity: " + data);
////
////        // İşlenmiş verileri yazdır
////        processedStream.print();
////
////        // Flink işlemini başlat
////        flinkStreamExecutionEnvironment.execute();
//////        DataStream<String> dataStream = flinkStreamExecutionEnvironment.fromElements("Hello", "World");
//////        dataStream.print();
//////
//////        flinkStreamExecutionEnvironment.execute();
////    }
////
////}
