package br.com.bank.transfer.core.usecase.initiation.chain;

import br.com.bank.transfer.core.domain.Transference;
import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.port.data.TransferenceGateway;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreateInitiationTransferenceTest {

    @InjectMocks
    private CreateInitiationTransference createInitiationTransference;

    @Mock
    private TransferenceGateway transferenceGateway;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateInitiationTransferenceSuccessfully() {
        var transferencePayload = createTransferencePayload();

        when(transferenceGateway.saveNewTransference(transferencePayload.getTransference())).thenReturn(transferencePayload.getTransference());

        assertDoesNotThrow(() -> createInitiationTransference.execute(transferencePayload));
    }

    private TransferencePayload createTransferencePayload() {
        return TransferencePayload.builder()
                .transference(Transference.builder()
                        .debtor(RandomString.make(13))
                        .creditor(RandomString.make(13))
                        .amount(BigDecimal.TEN)
                        .build())
                .build();
    }
}