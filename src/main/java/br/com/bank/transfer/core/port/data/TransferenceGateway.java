package br.com.bank.transfer.core.port.data;

import br.com.bank.transfer.core.domain.Transference;

public interface TransferenceGateway {
    Transference getTransferenceById(String transferenceId);
    Transference saveNewTransference(Transference transference);
}
