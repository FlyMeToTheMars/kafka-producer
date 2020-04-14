package com.jimi.producer;

import com.alibaba.fastjson.JSON;
import com.jimi.mode.*;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class TestProducer {
    private static Logger log = Logger.getLogger(TestProducer.class);
    private static Properties props = new Properties();
    private static final long BASE=868620190220000l;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        //execNewProducer();
        //execImei("867696586535952");
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        execGpsHis(0,"topic.gps.his",producer);
    }

    private static  void execImei(String imei){
        ReportDistance reportDistance = Util.getReportDistance().get(0);
        System.out.println(JSON.toJSONString(reportDistance).getBytes().length+" distance");

        ReportAlarm reportAlarm = Util.getAlarmInfo().get(0);
        System.out.println(JSON.toJSONString(reportAlarm).getBytes().length+" alarm");

        ReportAcc reportAcc = Util.getReportAcc().get(0);
        System.out.println(JSON.toJSONString(reportAcc).getBytes().length+" acc");

        ReportStop reportStop = Util.getReportStop().get(0);
        System.out.println(JSON.toJSONString(reportStop).getBytes().length+" stop");

        ReportTrack reportTrack = Util.getReportTrack().get(0);
        System.out.println(JSON.toJSONString(reportTrack).getBytes().length+" track");
        /*org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        try {
            forSend(System.currentTimeMillis(),"report.distance", report.getImei(), JSON.toJSONString(report), producer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static void execNewProducer(){
        ExecutorService execu = newFixedThreadPool(5);
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuAlarmInfo(0, "foreign.topic.offLine.alarm",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportStop(0, "foreign.topic.offLine.stop",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportTrack( 0, "foreign.topic.offLine.track",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportDistance(0, "foreign.topic.offLine.disSum",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuAcc( 0, "foreign.topic.offLine.acc",producer);
            }
        });
    }

    private static void execproducer() {
        ExecutorService execu = newFixedThreadPool(5);
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuAlarmInfo(0, "alarm",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportStop(0, "stop",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportTrack( 0, "track",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuReportDistance(0, "distance",producer);
            }
        });
        execu.execute(new Runnable() {
            @Override
            public void run() {
                execuAcc( 0, "acc",producer);
            }
        });

    }

    private static void execuReportDistance(int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) {
        //org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());

        try {
            List<ReportDistance> list = Util.getReportDistance();
            //String dis ="8676965865359522019-01-30 11:30:0015915.3446242004942019-01-30 11:31:162019-01-30 11:03:432019-01-30 11:29:53";

            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*6)+8;
                if(count%10 == 0)
                log.info("report [distance] count: " + count);
                for (ReportDistance report : list) {
                    report.setImei(BASE+(long)(Math.random()*10l)+"");
                    Thread.sleep(sleep);
                    forSend(System.currentTimeMillis(),topic, report.getImei(), JSON.toJSONString(report), producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), dis, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void execuReportTrack(int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) {
        //org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        //String track="8676965865359522019-01-29 23:54:412019-01-29 23:59:57100.44308421.959684云南省西双版纳傣族自治州勐海县嘎海路,温馨窗帘东南63米100.45150221.955387云南省西双版纳傣族自治州勐海县沿河路78号,勐海县检察院南148米337431538.56ACC002019-01-30 00:00:000024000";

        try {

            List<ReportTrack> list = Util.getReportTrack();

            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*11)+20;
                if(count%10 == 0)
                log.info("report *track* count: " + count);
                for (ReportTrack report : list) {
                    report.setImei(BASE+(long)(Math.random()*10l)+"");
                    Thread.sleep(sleep);
                    forSend(System.currentTimeMillis(),topic, report.getImei(), JSON.toJSONString(report), producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), track, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void execuReportStop(int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) {
        //org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
       // String stop = "8676965865359522019-01-30 22:56:192019-01-30 23:59:573818104.99407125.515624贵州省黔西南布依族苗族自治州普安县S313,新世纪大酒店西77米0TIME2019-01-31 00:00:000NULL";

        try {
            List<ReportStop> list = Util.getReportStop();

            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*11)+20;
                if(count%10 == 0)
                log.info("report |stop| count: " + count);
                for (ReportStop report : list) {
                    report.setImei(BASE+(long)(Math.random()*10l)+"");
                    Thread.sleep(sleep);
                    forSend(System.currentTimeMillis(),topic, report.getImei(), JSON.toJSONString(report), producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), stop, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void execuAlarmInfo( int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) {
        //org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        //String alarm = "867696586535952stayAlert2019-01-29 23:45:01NULL46.795862134.0115382019-01-30 00:00:00NULLDEVICENULLNULLNULLNULL";

        try {
            List<ReportAlarm> list = Util.getAlarmInfo();

            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*6)+5;
                if(count%10 == 0)
                log.info("alarm -info- count: " + count);
                for (ReportAlarm report : list) {
                    report.setImei(BASE+(long)(Math.random()*10l)+"");
                    Thread.sleep(sleep);
                    forSend(System.currentTimeMillis(),topic, report.getImei(), JSON.toJSONString(report), producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), alarm, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void execuAcc(int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) {
        //org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(getProperties());
        //String acc = "86769658653595202019-01-24 00:00:212019-02-03 23:59:5895037700HB2019-02-04 00:00:00";

        try {
            List<ReportAcc> list = Util.getReportAcc();
            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*7)+10;
                if(count%10 == 0)
                log.info("reprot acc - count: " + count);
                for (ReportAcc report : list) {
                    report.setImei(BASE+(long)(Math.random()*10l)+"");
                    Thread.sleep(sleep);

                    forSend(System.currentTimeMillis(),topic, report.getImei(), JSON.toJSONString(report), producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), acc, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void execGpsHis(int count, String topic,org.apache.kafka.clients.producer.KafkaProducer<String, String> producer){
        try {
            List<String> list = Util.getGpsHis();
            int sleep = 0;
            while (true) {
                sleep = (int)(Math.random()*7)+10;
                if(count%10 == 0)
                    log.info("reprot acc - count: " + count);
                for (String report : list) {
                    //Thread.sleep(sleep);
                    forSend(System.currentTimeMillis(),topic, BASE+(long)(Math.random()*10l)+"", report, producer);
                    //forSend(System.currentTimeMillis(),topic, report.getImei(), acc, producer);
                }
                count++;
            }
        } catch ( InterruptedException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        producer.close();
    }

    private static void forSend(final long start,final String topic,final String key, final String msg, org.apache.kafka.clients.producer.KafkaProducer<String, String> producer) throws InterruptedException {
        //Thread.sleep(2);
        try {
            producer.send(
                    new ProducerRecord<String, String>(topic, key, msg), new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if (exception != null) {
                                log.info("数据发送失败:" + exception.getMessage());
                                log.error(sdf.format(new Date(start))+" 耗时："+(System.currentTimeMillis()-start)+" ["+topic+"] imei:"+key+" =>message : " + msg);
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
        props.put("bootstrap.servers", "jimidatanode001:9092");
        //props.put("bootstrap.servers", "172.16.1.225:9092,172.16.1.226:9092");
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
        //props.put("send.buffer.bytes", 1024000);
        //props.put("receive.buffer.bytes", 1024000);
        // 发送缓存区内存大小
        props.put("buffer.memory", 67108864);
        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;

    }
}