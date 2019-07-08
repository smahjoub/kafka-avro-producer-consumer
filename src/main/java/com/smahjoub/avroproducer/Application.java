package com.smahjoub.avroproducer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smahjoub.avroproducer.injection.AvroProducerModule;
import org.apache.log4j.Logger;

public class Application {

    static final Logger logger = Logger.getLogger(Application.class);


    public static void main(String[] args) {

        logger.info("Starting avro kafka producer");

        final AvroProducerModule injectorModule = new AvroProducerModule();
        final Injector injector = Guice.createInjector(injectorModule);

    }
}
