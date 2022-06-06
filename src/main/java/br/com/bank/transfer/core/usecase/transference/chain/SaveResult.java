package br.com.bank.transfer.core.usecase.transference.chain;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.Executor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveResult implements Executor<TransferencePayload> {

    @Override
    public TransferencePayload execute(final TransferencePayload payload) {

        return payload;
    }
}