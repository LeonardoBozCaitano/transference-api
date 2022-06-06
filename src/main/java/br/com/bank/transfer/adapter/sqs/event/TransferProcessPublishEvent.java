package br.com.bank.transfer.adapter.sqs.Event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferProcessPublishEvent {
    private String transferenceId;
}
