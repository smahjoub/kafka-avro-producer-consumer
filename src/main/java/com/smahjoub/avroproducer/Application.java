package com.smahjoub.avroproducer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smahjoub.avroproducer.injection.AvroProducerModule;
import com.smahjoub.avroproducer.services.IKafkaProducer;
import org.apache.log4j.Logger;

public class Application {

    static final Logger logger = Logger.getLogger(Application.class);


    public static void main(String[] args) {

        logger.info("Starting avro kafka producer");

        final AvroProducerModule injectorModule = new AvroProducerModule();
        final Injector injector = Guice.createInjector(injectorModule);
        final IKafkaProducer kafkaProducer = injector.getInstance(IKafkaProducer.class);

        kafkaProducer.run();
    }
}
