package br.com.bank.transfer.core.usecase.initiation.chain;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.Executor;
import br.com.bank.transfer.core.port.publisher.MessagePublisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublishInitiationMessage implements Executor<TransferencePayload> {

    private final MessagePublisher messagePublisher;

    @Override
    public TransferencePayload execute(final TransferencePayload payload) {
        messagePublisher.sendProcessTransferenceMessage(payload.getTransference().getId());
        return payload;
    }
}