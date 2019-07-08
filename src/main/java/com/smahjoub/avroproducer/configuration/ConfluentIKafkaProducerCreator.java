package com.smahjoub.avroproducer.configuration;


import com.smahjoub.avroproducer.models.Employee;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;


import com.google.inject.Inject;
import java.util.Properties;

public class ConfluentIKafkaProducerCreator implements IKafkaProducerCreator {

    private final KafkaConfiguration kafkaConfiguration;


    @Inject
    public ConfluentIKafkaProducerCreator(KafkaConfiguration kafkaConfig){
        kafkaConfiguration = kafkaConfig;
    }

    public Producer<Long, Employee> createProducer() {
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfiguration.getKafkaBrokers());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaConfiguration.getClientId());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,KafkaAvroSerializer.class.getName());
        props.put("schema.registry.url", "http://localhost.finaxys.com:8081");

        return new KafkaProducer<>(props);
    }
}
