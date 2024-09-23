package br.com.gustavokt.SpringBootFirstExample;

import br.com.gustavokt.SpringBootFirstExample.domain.Cliente;
import br.com.gustavokt.SpringBootFirstExample.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackageClasses = br.com.gustavokt.SpringBootFirstExample.repository.IClienteRepository.class)
@EntityScan("br.com.gustavokt.SpringBootFirstExample.*")
//Não precisa usar @ComponentScan pois o @SpringBootApp já faz todo o scan.
public class SpringBootFirstExampleApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootFirstExampleApplication.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting Application");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("ITZ")
				.cpf(7897655678L)
				.estado("MA")
				.tel(9897897987L)
				.end("Rua das Pedras, 78")
				.numero(7887667)
				.nome("Gustavo")
				.email("gustavokt@kt.com")
				.build();
	}

}
