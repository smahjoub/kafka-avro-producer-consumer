package com.smahjoub.avroconsumer.injection;

import com.smahjoub.avroconsumer.configuration.DefaultKafkaConsumerCreator;
import com.smahjoub.avroconsumer.configuration.IKafkaConsumerCreator;
import com.smahjoub.avroconsumer.configuration.KafkaConfiguration;
import com.google.inject.AbstractModule;
import com.smahjoub.avroconsumer.service.DefaultConsumer;
import com.smahjoub.avroconsumer.service.IKafkaConsumer;

public class AvroConsumerModule  extends AbstractModule {

    @Override
    protected void configure() {
        bind(KafkaConfiguration.class).toInstance(new KafkaConfiguration());

        bind(IKafkaConsumerCreator.class).to(DefaultKafkaConsumerCreator.class);

        bind(IKafkaConsumer.class).to(DefaultConsumer.class);

    }
}
