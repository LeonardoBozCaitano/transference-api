package br.com.bank.transfer.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferencePayload {

    private Transference transference;

    private Customer creditor;

    private Customer debtor;

}
