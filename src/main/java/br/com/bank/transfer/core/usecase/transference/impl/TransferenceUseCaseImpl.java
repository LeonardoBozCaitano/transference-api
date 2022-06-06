package br.com.bank.transfer.core.usecase.transference.impl;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.executor.impl.SyncChain;
import br.com.bank.transfer.core.usecase.initiation.TransferenceInitiationUseCase;
import br.com.bank.transfer.core.usecase.initiation.chain.CreateInitiationTransference;
import br.com.bank.transfer.core.usecase.initiation.chain.PublishInitiationMessage;
import br.com.bank.transfer.core.usecase.initiation.chain.ValidateInitiationPayload;
import br.com.bank.transfer.core.usecase.transference.TransferenceUseCase;
import br.com.bank.transfer.core.usecase.transference.chain.FillEntities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenceUseCaseImpl implements TransferenceUseCase {

    private final FillEntities fillEntities;

    public TransferencePayload process(TransferencePayload transferencePayload) {
        return buildExecutorChain().execute(transferencePayload);
    }

    private SyncChain<TransferencePayload> buildExecutorChain() {
        return SyncChain.<TransferencePayload>builder()
                .chain(fillEntities)
                .build();
    }
}
