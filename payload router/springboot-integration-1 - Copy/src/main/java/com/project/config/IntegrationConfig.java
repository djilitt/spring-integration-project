package com.project.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Student;
import com.project.service.IntegrationGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.NullChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
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

    @Bean
    @Transformer(inputChannel = "integration.student.gateway.channel", outputChannel = "integration.student.objectToJson.channel")
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());
    }

    @Bean
    public Jackson2JsonObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(mapper);
    }

    @Bean
    @Transformer(inputChannel = "integration.student.jsonToObject.channel", outputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Student.class);
    }
}
