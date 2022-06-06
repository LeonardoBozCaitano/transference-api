package br.com.bank.transfer.adapter.sqs;

import br.com.bank.transfer.adapter.sqs.Event.TransferProcessPublishEvent;
import br.com.bank.transfer.core.port.publisher.MessagePublisher;
import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.AllArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SqsPublisher implements MessagePublisher {

    private static final String BANK_TRANSFERENCE = "bank-transference-test";

    private AmazonSQS amazonSQS;

    private ObjectMapper objectMapper;

    @Override
    public void sendProcessTransferenceMessage(String transferenceId) {
        var publishPayload = TransferProcessPublishEvent.builder()
                .transferenceId(transferenceId)
                .build();

        try {
            amazonSQS.sendMessage(BANK_TRANSFERENCE, objectMapper.writeValueAsString(publishPayload));
        } catch (Exception e) {

        }
    }
}
