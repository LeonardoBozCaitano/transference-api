package br.com.bank.transfer.adapter.customerapi.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("br.com.bank.transfer.adapter.customerapi.feign")
public class ClientConfig {

}
