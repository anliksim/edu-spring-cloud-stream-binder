package edu.cloud.stream.binder;

import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.cloud.stream.provisioning.ProvisioningException;
import org.springframework.cloud.stream.provisioning.ProvisioningProvider;

public class LocalProvisioningProvider implements ProvisioningProvider<ConsumerProperties, ProducerProperties> {

    @Override
    public ProducerDestination provisionProducerDestination(String name, ProducerProperties properties) throws ProvisioningException {
        return new ProducerDestination() {
            @Override
            public String getName() {
                return "producer";
            }

            @Override
            public String getNameForPartition(int partition) {
                return "producer";
            }
        };
    }

    @Override
    public ConsumerDestination provisionConsumerDestination(String name, String group, ConsumerProperties properties) throws ProvisioningException {
        return () -> "consumer";
    }
}
