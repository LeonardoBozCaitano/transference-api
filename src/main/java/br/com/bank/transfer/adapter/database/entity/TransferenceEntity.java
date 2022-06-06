package br.com.bank.transfer.adapter.database.entity;

import br.com.bank.transfer.core.domain.Transference;
import br.com.bank.transfer.core.domain.enums.TransferenceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "transference")
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    private String debtor;

    private String creditor;

    private BigDecimal amount;

    private TransferenceStatus status;

    public static TransferenceEntity from(Transference dto) {
        return TransferenceEntity.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .creditor(dto.getCreditor())
                .debtor(dto.getDebtor())
                .status(dto.getStatus())
                .build();
    }

    public Transference toDto() {
        return Transference.builder()
                .id(this.getId())
                .amount(this.getAmount())
                .creditor(this.getCreditor())
                .debtor(this.getDebtor())
                .status(this.getStatus())
                .build();
    }
}
