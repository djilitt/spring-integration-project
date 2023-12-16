package com.projectSPI.etudiant.Integrations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;

@Configuration
@IntegrationComponentScan
public class IntegrationConfig {

    @Bean
    public MessageChannel requestChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel() {
        return new DirectChannel(); // Define a reply channel
    }

    @Bean
    @ServiceActivator(inputChannel = "requestChannel")
    public HttpRequestExecutingMessageHandler httpRequestHandler() {
        HttpRequestExecutingMessageHandler handler =
                new HttpRequestExecutingMessageHandler("http://localhost:9090/api/Emprunt");
        handler.setHttpMethod(HttpMethod.POST);
        handler.setExpectedResponseType(String.class);
        handler.setOutputChannel(replyChannel()); // Set the output channel programmatically
        handler.setSendTimeout(10000); // Set the timeout

        // Additional configurations
        return handler;
    }

    @Bean
    @ServiceActivator(inputChannel = "replyChannel")
    public MessageHandler responseHandler() {
        return message -> {
            // Extract payload or headers from the message
            Object payload = message.getPayload();
            MessageHeaders headers = message.getHeaders();

            // Log or process the response
            System.out.println("Received response with payload: " + payload);
            // Additional logic to process the message
        };
    }

}

