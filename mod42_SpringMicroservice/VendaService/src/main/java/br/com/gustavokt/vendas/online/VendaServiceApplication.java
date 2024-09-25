package br.com.gustavokt.vendas.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@RefreshScope
@EnableFeignClients
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VendaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaServiceApplication.class, args);
	}

}
