package br.com.bank.transfer.core.domain;

import br.com.bank.transfer.core.domain.enums.TransferenceStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transference implements Serializable {

    private String id;

    private String debtor;

    private String creditor;

    private BigDecimal amount;

    private TransferenceStatus status;

}
