package com.project.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Student;
import com.project.service.IntegrationGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.NullChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.beans.BeanProperty;

@Configuration
@EnableIntegration
@IntegrationComponentScan("com.project")


public class IntegrationConfig {
    @Bean
    public MessageChannel recieverChannel(){
        return new DirectChannel();
    }


    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "router.channel")
    @Bean
    public RecipientListRouter router(){
        RecipientListRouter router = new RecipientListRouter();
        router.addRecipient("student.channel.1");
        router.addRecipient("student.channel.2");
        return router;
    }

}
