package com.smahjoub.avroconsumer.service;

import com.smahjoub.avroconsumer.configuration.IKafkaConsumerCreator;
import com.google.inject.Inject;
import com.smahjoub.avroconsumer.configuration.KafkaConfiguration;
import com.smahjoub.avroproducer.models.Employee;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Collections;

public class DefaultConsumer implements IKafkaConsumer {

    static final Logger logger = Logger.getLogger(DefaultConsumer.class);

    private final IKafkaConsumerCreator kafkaConsumerCreator;
    private final KafkaConfiguration kafkaConfiguration;

    @Inject
    public DefaultConsumer(IKafkaConsumerCreator kafkaConsumerCreatorSrv,
                           KafkaConfiguration kafkaConfig){
        kafkaConsumerCreator = kafkaConsumerCreatorSrv;
        kafkaConfiguration = kafkaConfig;
    }

    @Override
    public void run() {
        final Consumer<Long, Employee> consumer = kafkaConsumerCreator.createConsumer();

        final String topic = kafkaConfiguration.getTopicName();
        consumer.subscribe(Collections.singleton(topic));

        logger.info("Waiting for data...");
        while (true){
            ConsumerRecords<Long, Employee> records = consumer.poll(Duration.ofSeconds(1000));

            for (ConsumerRecord<Long, Employee> record : records){
                Employee employee = record.value();

                logger.info("Received employee records  with dev code"  + employee.getName());
            }

            consumer.commitSync();
        }
    }
}
