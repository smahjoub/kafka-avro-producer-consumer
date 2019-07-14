package com.smahjoub.avroproducer.configuration;

public class KafkaConfiguration {

    private String clientId = "AvroProducer";

    private String kafkaBrokers = "localhost:9092";

    private String topicName = "NEW_EMPLOYEES";

    private String schemaRegistry = "localhost:8081";

    public KafkaConfiguration(){

    }

    public String getClientId() {
        return clientId;
    }


    public String getKafkaBrokers() {
        return kafkaBrokers;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getSchemaRegistry() {
        return schemaRegistry;
    }
}
