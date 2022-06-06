package br.com.bank.transfer.core.usecase.initiation;

import br.com.bank.transfer.core.domain.TransferencePayload;

public interface TransferenceInitiationUseCase {
    void process(final TransferencePayload transferencePayload);
}
