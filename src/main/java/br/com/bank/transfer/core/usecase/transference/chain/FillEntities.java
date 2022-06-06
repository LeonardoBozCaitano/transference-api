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
public class FillEntities implements Executor<TransferencePayload> {

    private final TransferenceGateway transferenceGateway;

    private final CustomerClient customerClient;

    @Override
    public TransferencePayload execute(final TransferencePayload payload) {
        payload.setTransference(transferenceGateway.getTransferenceById(payload.getTransference().getId()));
        payload.setCreditor(getCustomerBy(payload.getTransference().getCreditor()));
        payload.setDebtor(getCustomerBy(payload.getTransference().getDebtor()));

        return payload;
    }

    private Customer getCustomerBy(String customerDocument) {
        return customerClient.getCustomerByDocument(customerDocument);
    }
}