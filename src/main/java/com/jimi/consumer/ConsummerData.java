package com.jimi.consumer;

import com.alibaba.fastjson.JSON;
import com.jimi.mode.*;
import com.jimi.producer.Util;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ConsummerData {

    private static Logger log = Logger.getLogger(ConsummerData.class);
    private static Properties props = new Properties();
    private static final long BASE=868620190220000l;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        ExecutorService execu = newFixedThreadPool(5);
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        execu.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProp());

                // 消费者订阅的topic, 可同时订阅多个
                consumer.subscribe(Arrays.asList("topic.offLine.alarm"));
                while (true) {
                    // 读取数据，读取超时时间为100ms
                    ConsumerRecords<String, String> records = consumer.poll(100);

                    for (ConsumerRecord<String, String> record : records){
                        forSend(0,record.topic(), record.key(), record.value(),producer);

                    }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProp());

                // 消费者订阅的topic, 可同时订阅多个
                consumer.subscribe(Arrays.asList("topic.offLine.stop"));
                while (true) {
                    // 读取数据，读取超时时间为100ms
                    ConsumerRecords<String, String> records = consumer.poll(100);

                    for (ConsumerRecord<String, String> record : records){
                        forSend(0,record.topic(), record.key(), record.value(),producer);

                    }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProp());

                // 消费者订阅的topic, 可同时订阅多个
                consumer.subscribe(Arrays.asList("topic.offLine.track"));
                while (true) {
                    // 读取数据，读取超时时间为100ms
                    ConsumerRecords<String, String> records = consumer.poll(100);

                    for (ConsumerRecord<String, String> record : records){
                        forSend(0,record.topic(), record.key(), record.value(),producer);

                    }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProp());

                // 消费者订阅的topic, 可同时订阅多个
                consumer.subscribe(Arrays.asList("topic.offLine.disSum"));
                while (true) {
                    // 读取数据，读取超时时间为100ms
                    ConsumerRecords<String, String> records = consumer.poll(100);

                    for (ConsumerRecord<String, String> record : records){
                        forSend(0,record.topic(), record.key(), record.value(),producer);

                    }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        });
        /*execu.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProp());

                // 消费者订阅的topic, 可同时订阅多个
                consumer.subscribe(Arrays.asList("topic.offLine.acc"));
                while (true) {
                    // 读取数据，读取超时时间为100ms
                    ConsumerRecords<String, String> records = consumer.poll(100);

                    for (ConsumerRecord<String, String> record : records){
                        forSend(0,record.topic(), record.key(), record.value(),producer);

                    }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        });*/
         // 定义consumer

        int count =0;


    }

    public static Properties getConsumerProp(){
        Properties props = new Properties();
        // 定义kakfa 服务的地址，不需要将所有broker指定上
        props.put("bootstrap.servers", "120.77.251.74:9092");
        // 制定consumer group
        props.put("group.id", "analogdata");
        // 是否自动确认offset
        props.put("enable.auto.commit", "true");
        // 自动确认offset的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        // key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        return props;
    }




    private static void forSend(final long start,final String topic,final String key, final String msg, org.apache.kafka.clients.producer.KafkaProducer<String, String> producer)  {
        //Thread.sleep(2);
        try {
            producer.send(
                    new ProducerRecord<String, String>(topic, key, msg), new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if (exception != null) {
                                log.info("数据发送失败:" + exception.getMessage());
                                //log.error(sdf.format(new Date(start))+" 耗时："+(System.currentTimeMillis()-start)+" ["+topic+"] imei:"+key+" =>message : " + msg);
                            }
                        }
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static Properties getProperties() {

        //Kafka服务端的主机名和端口号
        props.put("bootstrap.servers", "master126:9092");

        //等待所有副本节点的应答级别
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        //消息发送最大尝试次数
        props.put("retries", 3);
        //一批消息处理大小
        props.put("batch.size", 65136);
        props.put("compression.type", "snappy");
        //提交延时
        props.put("linger.ms", 50);
        props.put("request.timeout.ms", 60000);

        props.put("reconnect.backoff.ms", 20000);
        props.put("retry.backoff.ms", 20000);

        props.put("buffer.memory", 67108864);

        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }
}
