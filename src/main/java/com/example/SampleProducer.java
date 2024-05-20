package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SampleProducer 
{
    String TOPIC = "my-topic";
    String value;
    final KafkaProducer<String,String> kafkaProducer;
    ProducerRecord producerRecord;

    public SampleProducer(String value){
    
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        
        kafkaProducer = new KafkaProducer<>(properties);
        
        setValue(value);
    }

    public void setValue(String value){
        if(value==null)
            kafkaProducer.close();
        this.value=value;
        producerRecord = new ProducerRecord(TOPIC,"name",value);

        kafkaProducer.send(producerRecord);

        System.out.println("Sent "+this.value+"\n");
    }
}
