package com.smahjoub.avroconsumer.configuration;

public class KafkaConfiguration {

    private String kafkaBrokers = "localhost:9092";

    private String topicName = "NEWEMPLOYEES";

    private String schemaRegistry = "http://localhost:8081";

    public KafkaConfiguration(){

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
