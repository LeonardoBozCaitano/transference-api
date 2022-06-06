package br.com.bank.transfer.core.domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet implements Serializable {

    private BigDecimal balance;

}
