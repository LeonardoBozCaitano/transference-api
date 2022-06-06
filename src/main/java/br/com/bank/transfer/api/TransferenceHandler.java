package br.com.bank.transfer.api;

import br.com.bank.transfer.core.usecase.initiation.TransferenceInitiationUseCase;
import br.com.bank.transfer.api.request.TransferenceInitiationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TransferenceHandler.BASE_URL)
@AllArgsConstructor
public class TransferenceHandler {

    public static final String BASE_URL = "/transference";

    private final TransferenceInitiationUseCase transferenceInitiationUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Validated @RequestBody TransferenceInitiationRequest transferenceInitiationRequest) {
        transferenceInitiationUseCase.process(transferenceInitiationRequest.toTransferencePayload());
    }
}
