package com.smahjoub.avroproducer.injection;

import com.google.inject.AbstractModule;
import com.smahjoub.avroproducer.configuration.ConfluentIKafkaProducerCreator;
import com.smahjoub.avroproducer.configuration.IKafkaProducerCreator;
import com.smahjoub.avroproducer.configuration.KafkaConfiguration;
import com.smahjoub.avroproducer.services.IKafkaProducer;
import com.smahjoub.avroproducer.services.RandomKafkaProducer;

public class AvroProducerModule extends AbstractModule {


    @Override
    protected void configure() {

        bind(KafkaConfiguration.class).toInstance(new KafkaConfiguration());

        bind(IKafkaProducerCreator.class).to(ConfluentIKafkaProducerCreator.class);

        bind(IKafkaProducer.class).to(RandomKafkaProducer.class);

    }
}
