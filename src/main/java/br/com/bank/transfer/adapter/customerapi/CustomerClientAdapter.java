package br.com.bank.transfer.adapter.customerapi;

import br.com.bank.transfer.adapter.customerapi.feign.CustomerFeignClient;
import br.com.bank.transfer.core.domain.Customer;
import br.com.bank.transfer.core.port.client.CustomerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerClientAdapter implements CustomerClient {

    private final CustomerFeignClient customerFeignClient;

    public Customer getCustomerByDocument(String document) {
        return customerFeignClient.getByDocument(document).toCustomer();
    }
}
