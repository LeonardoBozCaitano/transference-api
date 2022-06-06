package br.com.bank.transfer.consumer.config;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.messaging.config.QueueMessageHandlerFactory;
import io.awspring.cloud.messaging.listener.support.AcknowledgmentHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;

import java.util.Arrays;

@Configuration
public class AwsSqsConfig {

    @Bean
    public QueueMessageHandlerFactory queueMessageHandlerFactory(final AmazonSQSAsync amazonSQSAsync, final ObjectMapper objectMapper) {
        MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
        jackson2MessageConverter.setSerializedPayloadClass(String.class);
        jackson2MessageConverter.setStrictContentTypeMatch(false);
        jackson2MessageConverter.setObjectMapper(objectMapper);

        var payloadMethodArgumentResolver =
                new PayloadMethodArgumentResolver(jackson2MessageConverter);

        var acknowledgmentResolver = new AcknowledgmentHandlerMethodArgumentResolver("Acknowledgment");

        var factory = new QueueMessageHandlerFactory();
        factory.setAmazonSqs(amazonSQSAsync);
        factory.setArgumentResolvers(Arrays.asList(acknowledgmentResolver, payloadMethodArgumentResolver));

        return factory;
    }



}
