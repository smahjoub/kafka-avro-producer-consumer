package com.smahjoub.avroproducer.configuration;

import com.smahjoub.avroproducer.models.Employee;
import org.apache.kafka.clients.producer.Producer;

public interface IKafkaProducerCreator {

    Producer<Long, Employee> createProducer();
}
