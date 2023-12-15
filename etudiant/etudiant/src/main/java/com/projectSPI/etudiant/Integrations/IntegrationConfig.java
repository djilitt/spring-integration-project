package com.projectSPI.etudiant.Integrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageChannel;

@Configuration
@IntegrationComponentScan
public class IntegrationConfig {

    @Bean
    public MessageChannel requestChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "requestChannel")
    public HttpRequestExecutingMessageHandler httpRequestHandler() {
        HttpRequestExecutingMessageHandler handler =
                new HttpRequestExecutingMessageHandler("http://localhost:8080/api/Emprunt");
        handler.setHttpMethod(HttpMethod.POST);
        handler.setExpectedResponseType(String.class);
        // Additional configurations like headers, error handling, etc.
        return handler;
    }
}
