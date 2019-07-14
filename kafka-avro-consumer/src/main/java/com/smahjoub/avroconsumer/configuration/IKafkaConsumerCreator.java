package com.smahjoub.avroconsumer.configuration;

import com.smahjoub.avroproducer.models.Employee;
import org.apache.kafka.clients.consumer.KafkaConsumer;


public interface IKafkaConsumerCreator {

    KafkaConsumer<Long, Employee> createConsumer();

}
