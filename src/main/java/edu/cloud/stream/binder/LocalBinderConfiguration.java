package edu.cloud.stream.binder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalBinderConfiguration {

    @Bean
    public LocalBinder localBinder() {
        return new LocalBinder(new String[0], new LocalProvisioningProvider());
    }
}
