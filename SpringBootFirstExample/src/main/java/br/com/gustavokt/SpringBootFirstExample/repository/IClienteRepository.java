package br.com.gustavokt.SpringBootFirstExample.repository;

import br.com.gustavokt.SpringBootFirstExample.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
