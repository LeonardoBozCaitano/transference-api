package br.com.bank.transfer.adapter.database;

import br.com.bank.transfer.adapter.database.entity.TransferenceEntity;
import br.com.bank.transfer.adapter.database.repository.TransferenceRepository;
import br.com.bank.transfer.core.domain.Transference;
import br.com.bank.transfer.core.port.data.TransferenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferenceGatewayAdapter implements TransferenceGateway {

    private final TransferenceRepository transferenceRepository;

    @Override
    public Transference getTransferenceById(String transferenceId) {
        var transferenceEntity = transferenceRepository.findById(transferenceId).orElseThrow();
        return transferenceEntity.toDto();
    }

    @Override
    public Transference saveNewTransference(Transference transference) {
        var entity = TransferenceEntity.from(transference);
        return transferenceRepository.save(entity).toDto();
    }

}
