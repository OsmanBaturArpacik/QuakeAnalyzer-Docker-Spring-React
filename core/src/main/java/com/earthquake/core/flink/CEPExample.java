//package com.earthquake.core.flink;
//import org.apache.flink.api.java.tuple.Tuple2;
//import org.apache.flink.cep.CEP;
//import org.apache.flink.cep.PatternSelectFunction;
//import org.apache.flink.cep.PatternStream;
//import org.apache.flink.cep.pattern.Pattern;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//
//import java.util.List;
//import java.util.Map;
//
//public class CEPExample {
//
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//
//        DataStream<Tuple2<String, Integer>> inputStream = env.fromElements(
//                new Tuple2<>("a", 1),
//                new Tuple2<>("b", 2),
//                new Tuple2<>("a", 3)
//        );
//
//        Pattern<Tuple2<String, Integer>, ?> pattern = Pattern.<Tuple2<String, Integer>>begin("start")
//                .where(event -> event.f0.equals("a"))
//                .times(2);
//
//        PatternStream<Tuple2<String, Integer>> patternStream = CEP.pattern(inputStream, pattern);
//
//        DataStream<String> resultStream = patternStream.select(new PatternSelectFunction<Tuple2<String, Integer>, String>() {
//            @Override
//            public String select(Map<String, List<Tuple2<String, Integer>>> pattern) throws Exception {
//                return "Found 'a' twice in a row";
//            }
//        });
//
//        resultStream.print();
//
//        env.execute("CEP Example");
//    }
//}
