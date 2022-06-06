package br.com.bank.transfer.api.request;

import br.com.bank.transfer.core.domain.Transference;
import br.com.bank.transfer.core.domain.TransferencePayload;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
public class TransferenceInitiationRequest {

    @NonNull
    private String debtorCustomerId;

    @NonNull
    private String creditorCustomerId;

    @NonNull
    private BigDecimal amount;

    public TransferencePayload toTransferencePayload() {
        return TransferencePayload.builder()
                .transference(Transference.builder()
                                .amount(amount)
                                .creditor(creditorCustomerId)
                                .debtor(debtorCustomerId)
                                .build()
                ).build();
    }
}
