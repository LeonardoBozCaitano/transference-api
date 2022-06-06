package br.com.bank.transfer.core.usecase.initiation.chain;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.domain.enums.TransferenceStatus;
import br.com.bank.transfer.core.executor.Executor;
import br.com.bank.transfer.core.port.data.TransferenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateInitiationTransference implements Executor<TransferencePayload> {

    private final TransferenceGateway transferenceGateway;

    @Override
    public TransferencePayload execute(final TransferencePayload payload) {
        payload.getTransference().setStatus(TransferenceStatus.PENDING);
        payload.setTransference(
                transferenceGateway.saveNewTransference(payload.getTransference())
        );
        return payload;
    }
}
