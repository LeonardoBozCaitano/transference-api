package br.com.bank.transfer.core.port.client;

import br.com.bank.transfer.core.domain.Customer;

public interface CustomerClient {
    Customer getCustomerByDocument(String document);
}
