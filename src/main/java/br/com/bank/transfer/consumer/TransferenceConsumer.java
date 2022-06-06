package br.com.bank.transfer.consumer;

import br.com.bank.transfer.consumer.event.TransferenceProcessEvent;
import br.com.bank.transfer.core.domain.Transference;
import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.usecase.transference.TransferenceUseCase;
import io.awspring.cloud.messaging.listener.Acknowledgment;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransferenceConsumer {

    private TransferenceUseCase transferenceUseCase;

    @SqsListener(deletionPolicy = SqsMessageDeletionPolicy.NEVER, value="${sqs.queues.transference.url}")
    public void receiveMessage(final TransferenceProcessEvent transferenceProcessEvent, final Acknowledgment acknowledgment) {
        var input = TransferencePayload.builder().transference(
                Transference.builder()
                        .id(transferenceProcessEvent.getTransferenceId())
                        .build()
        ).build();
        transferenceUseCase.process(input);
        acknowledgment.acknowledge();
    }
}
