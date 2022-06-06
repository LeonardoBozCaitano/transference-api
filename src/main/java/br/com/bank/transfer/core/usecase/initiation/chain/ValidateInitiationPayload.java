package br.com.bank.transfer.core.usecase.initiation.chain;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.Executor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Component
public class ValidateInitiationPayload implements Executor<TransferencePayload> {

    @Override
    public TransferencePayload execute(final TransferencePayload input) {
        validateTransferenceAmount(input.getTransference().getAmount());
        return input;
    }

    private void validateTransferenceAmount(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
