package br.com.bank.transfer.adapter.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.bank.transfer.adapter.database.repository")
public class DatabaseConfig {

}
