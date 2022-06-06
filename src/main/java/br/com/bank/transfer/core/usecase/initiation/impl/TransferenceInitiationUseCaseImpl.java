package br.com.bank.transfer.core.usecase.initiation.impl;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.impl.SyncChain;
import br.com.bank.transfer.core.usecase.initiation.TransferenceInitiationUseCase;
import br.com.bank.transfer.core.usecase.initiation.chain.CreateInitiationTransference;
import br.com.bank.transfer.core.usecase.initiation.chain.PublishInitiationMessage;
import br.com.bank.transfer.core.usecase.initiation.chain.ValidateInitiationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenceInitiationUseCaseImpl implements TransferenceInitiationUseCase {

    private final ValidateInitiationPayload validateInitiationPayload;

    private final CreateInitiationTransference createInitiationTransference;

    private final PublishInitiationMessage publishInitiationMessage;

    public void process(TransferencePayload transferencePayload) {
        buildExecutorChain().execute(transferencePayload);
    }

    private SyncChain<TransferencePayload> buildExecutorChain() {
        return SyncChain.<TransferencePayload>builder()
                .chain(validateInitiationPayload)
                .chain(createInitiationTransference)
                .chain(publishInitiationMessage)
                .build();
    }
}
