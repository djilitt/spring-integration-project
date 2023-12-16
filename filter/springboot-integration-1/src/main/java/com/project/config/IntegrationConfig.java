package com.project.config;

import com.project.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan("com.project")


public class IntegrationConfig {
    @Bean
    public MessageChannel recieverChannel(){
        return new DirectChannel();
    }


//    @Bean
//    public MessageChannel replyChannel(){
//        return new DirectChannel();
//    }
    @Filter(inputChannel = "router.channel")
    @Bean
    public MessageFilter filter(){
        MessageFilter filter = new MessageFilter(new MessageSelector() {
            @Override
            public boolean accept(Message<?> message) {
                return message.getPayload() instanceof  Student;
            }
        });
        filter.setOutputChannelName("student.channel");
        return filter ;
    }



}
