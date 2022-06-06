package br.com.bank.transfer.api.advice;

import br.com.bank.transfer.api.response.DefaultErrorReponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultErrorReponse handleEntityNotFound() {
        return DefaultErrorReponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .timestamp(LocalDateTime.now().toString())
                .build();
    }
}
