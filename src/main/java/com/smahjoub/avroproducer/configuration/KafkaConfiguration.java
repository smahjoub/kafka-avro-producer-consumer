package com.smahjoub.avroproducer.configuration;

public class KafkaConfiguration {

    private String clientId = "AvroProducer";

    private String kafkaBrokers = "localhost.finaxys.com:6667";

    private String topicName = "NEW_EMPLOYEES";

    private String schemaRegistry = "http://localhost.finaxys.com:8081";

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
