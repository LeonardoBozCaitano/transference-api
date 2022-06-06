package br.com.bank.transfer.core.usecase.initiation.impl;

import br.com.bank.transfer.core.domain.TransferencePayload;
import br.com.bank.transfer.core.usecase.initiation.chain.CreateInitiationTransference;
import br.com.bank.transfer.core.usecase.initiation.chain.PublishInitiationMessage;
import br.com.bank.transfer.core.usecase.initiation.chain.ValidateInitiationPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransferenceInitiationUseCaseImplTest {

    @InjectMocks
    private TransferenceInitiationUseCaseImpl transferenceInitiationUseCase;

    @Mock
    private ValidateInitiationPayload validateInitiationPayload;

    @Mock
    private CreateInitiationTransference createInitiationTransference;

    @Mock
    private PublishInitiationMessage publishInitiationMessage;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldInitiateTransferenceSuccessfully() {
        var transferencePayload = createTransferencePayload();

        when(validateInitiationPayload.execute(transferencePayload)).thenReturn(transferencePayload);
        when(createInitiationTransference.execute(transferencePayload)).thenReturn(transferencePayload);
        when(publishInitiationMessage.execute(transferencePayload)).thenReturn(transferencePayload);

        assertDoesNotThrow(() -> transferenceInitiationUseCase.process(transferencePayload));

        verify(validateInitiationPayload, times(1)).execute(transferencePayload);
        verify(createInitiationTransference, times(1)).execute(transferencePayload);
        verify(publishInitiationMessage, times(1)).execute(transferencePayload);
    }

    @Test
    void shouldThrowErrorAtValidateInitiationPayload() {
        var transferencePayload = createTransferencePayload();

        when(validateInitiationPayload.execute(transferencePayload)).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST));

        assertThrows(ResponseStatusException.class, () -> transferenceInitiationUseCase.process(transferencePayload));

        verify(validateInitiationPayload, times(1)).execute(transferencePayload);
        verify(createInitiationTransference, times(0)).execute(transferencePayload);
        verify(publishInitiationMessage, times(0)).execute(transferencePayload);
    }

    private TransferencePayload createTransferencePayload() {
        return TransferencePayload.builder().build();
    }
}