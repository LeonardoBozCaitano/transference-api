package br.com.bank.transfer.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultErrorReponse {
    private int status;
    private String error;
    private String timestamp;
}
