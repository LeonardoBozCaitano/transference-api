package br.com.bank.transfer.core.usecase.transference.chain;

import br.com.bank.transfer.core.domain.Customer;
import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.Executor;
import br.com.bank.transfer.core.port.client.CustomerClient;
import br.com.bank.transfer.core.port.data.TransferenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidateData implements Executor<TransferencePayload> {

    @Override
    public TransferencePayload execute(final TransferencePayload payload) {

        return payload;
    }
}