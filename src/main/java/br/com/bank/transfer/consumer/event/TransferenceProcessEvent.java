package br.com.bank.transfer.consumer.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceProcessEvent {
    private String transferenceId;
}
