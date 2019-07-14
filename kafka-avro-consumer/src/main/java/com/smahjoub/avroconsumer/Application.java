package com.smahjoub.avroconsumer;

import com.smahjoub.avroconsumer.injection.AvroConsumerModule;
import com.smahjoub.avroconsumer.service.IKafkaConsumer;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.Logger;

public class Application {

    static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {

        logger.info("Starting avro kafka consumer");

        final AvroConsumerModule injectorModule = new AvroConsumerModule();
        final Injector injector = Guice.createInjector(injectorModule);
        final IKafkaConsumer kafkaConsumer = injector.getInstance(IKafkaConsumer.class);

        kafkaConsumer.run();
    }
}
