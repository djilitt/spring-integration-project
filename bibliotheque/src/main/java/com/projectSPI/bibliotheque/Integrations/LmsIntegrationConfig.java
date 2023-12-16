package com.projectSPI.bibliotheque.Integrations;

import com.projectSPI.bibliotheque.DTO.BorrowRequestDTO;
import com.projectSPI.bibliotheque.service.LivreEmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;

@Configuration
public class LmsIntegrationConfig {

    @Autowired
    private LivreEmpruntService livreEmpruntService;

    @Bean
    public HttpRequestHandlingMessagingGateway httpInboundGateway() {
        HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway();
        gateway.setRequestMapping(createRequestMapping());
        gateway.setRequestChannel(httpRequestChannel());
        return gateway;
    }

    private RequestMapping createRequestMapping() {
        RequestMapping requestMapping = new RequestMapping();
        requestMapping.setMethods(HttpMethod.POST); // Set the HTTP method to POST
        requestMapping.setPathPatterns("/api/Emprunt"); // Set the URL path for the gateway
        return requestMapping;
    }

    @Bean
    public MessageChannel httpRequestChannel() {
        return new DirectChannel() {
            @Override
            protected boolean doSend(Message<?> message, long timeout) {
                try {
                    // Assuming the payload is of type BorrowRequestDTO
                    BorrowRequestDTO payload = (BorrowRequestDTO) message.getPayload();
                    System.out.println("Received payload: " + payload);
                    livreEmpruntService.processBorrowRequest(payload);
                    return true; // Indicating successful processing
                } catch (MessagingException e) {
                    // Handle exceptions, log errors, etc.
                    return false; // Indicating failure in processing
                }
            }
        };
    }
}
