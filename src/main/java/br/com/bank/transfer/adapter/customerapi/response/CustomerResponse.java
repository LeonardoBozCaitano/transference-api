package br.com.bank.transfer.adapter.customerapi.response;

import br.com.bank.transfer.core.domain.Customer;
import br.com.bank.transfer.core.domain.Wallet;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String document;

    private WalletResponse wallet;

    public Customer toCustomer() {
        return Customer.builder()
                .id(this.id)
                .name(this.name)
                .document(this.document)
                .wallet(Wallet.builder().balance(
                        this.getWallet().getBalance()).build()
                ).build();
    }

}
