package com.smahjoub.avroconsumer.configuration;

import com.google.inject.Inject;
import com.smahjoub.avroproducer.models.Employee;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class DefaultKafkaConsumerCreator implements IKafkaConsumerCreator {

    private final KafkaConfiguration kafkaConfiguration;


    @Inject
    public DefaultKafkaConsumerCreator(KafkaConfiguration kafkaConfig){
        kafkaConfiguration = kafkaConfig;
    }

    @Override
    public KafkaConsumer<Long, Employee> createConsumer() {
        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfiguration.getKafkaBrokers());

        props.put("group.id", "customer-consumer-group-v2");
        props.put("auto.commit.enable", "false");
        props.put("auto.offset.reset", "earliest");

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.setProperty("schema.registry.url",  kafkaConfiguration.getSchemaRegistry());
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);

        return new KafkaConsumer<>(props);
    }
}
