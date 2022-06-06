package br.com.bank.transfer.core.usecase.transference;

import br.com.bank.transfer.core.domain.TransferencePayload;

public interface TransferenceUseCase {
    TransferencePayload process(final TransferencePayload transferencePayload);
}
