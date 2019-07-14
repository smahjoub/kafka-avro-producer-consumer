package com.smahjoub.avroproducer.services;


import com.google.inject.Inject;
import com.smahjoub.avroproducer.configuration.IKafkaProducerCreator;
import com.smahjoub.avroproducer.configuration.KafkaConfiguration;

import com.smahjoub.avroproducer.models.Employee;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;

public class RandomKafkaProducer implements IKafkaProducer {

    private final IKafkaProducerCreator kafkaProducerCreator;
    private final KafkaConfiguration kafkaConfiguration;

    @Inject
    public RandomKafkaProducer(IKafkaProducerCreator kafkaProducerCreatorSrv,
            KafkaConfiguration kafkaConfig){
        kafkaProducerCreator = kafkaProducerCreatorSrv;
        kafkaConfiguration = kafkaConfig;
    }

    @Override
    public void run() {

        Producer<Long, Employee> producer = kafkaProducerCreator.createProducer();

        final Employee randomEmployee = Employee.newBuilder()
                .setName("Saif eddine Mahjoub")
                .setAge(28)
                .setEmails(Arrays.asList("saifeddine.mahjoub@server.domain"))
                .setBoss(null)
                .build();


        producer.send(new ProducerRecord<>(kafkaConfiguration.getTopicName(), 1L, randomEmployee));

        producer.flush();
        producer.close();


    }
}
