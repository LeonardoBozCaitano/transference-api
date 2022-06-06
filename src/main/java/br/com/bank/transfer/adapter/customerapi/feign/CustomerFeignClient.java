package br.com.bank.transfer.adapter.customerapi.feign;


import br.com.bank.transfer.adapter.customerapi.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "customer", url = "localhost:8080/customer")
public interface CustomerFeignClient {

    @GetMapping
    CustomerResponse getById(@PathVariable String customerId);

    @GetMapping()
    CustomerResponse getByDocument(@RequestParam String document);

}
