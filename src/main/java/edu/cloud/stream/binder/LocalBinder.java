package edu.cloud.stream.binder;

import edu.cloud.stream.Person;
import org.springframework.cloud.stream.binder.*;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicBoolean;

public class LocalBinder extends AbstractMessageChannelBinder<ConsumerProperties, ProducerProperties, LocalProvisioningProvider> {

    private final AtomicBoolean send = new AtomicBoolean(true);
    private MessageChannel outputChannel;

    LocalBinder(String[] headersToEmbed, LocalProvisioningProvider provisioningProvider) {
        super(headersToEmbed, provisioningProvider);
    }

    @Override
    protected MessageHandler createProducerMessageHandler(ProducerDestination destination, ProducerProperties producerProperties, MessageChannel errorChannel) {
        return message -> {
            System.out.println("Handler received: " + message);
            if (send.compareAndSet(true, false)) {
                outputChannel.send(message);
            }
        };
    }

    @Override
    protected MessageProducer createConsumerEndpoint(ConsumerDestination destination, String group, ConsumerProperties properties) {
        return new MessageProducer() {

            @Override
            public void setOutputChannel(MessageChannel outputChannel) {
                LocalBinder.this.outputChannel = outputChannel;
                outputChannel.send(
                        new GenericMessage<>(
                                new Person("Hello")));
            }

            @Override
            public MessageChannel getOutputChannel() {
                return LocalBinder.this.outputChannel;
            }
        };
    }
}
