package br.com.gustavokt.service;

import br.com.gustavokt.domain.Cliente;
import br.com.gustavokt.exceptions.DAOException;
import br.com.gustavokt.service.generic.IGenericService;

import java.util.List;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    List<Cliente> filtrarClientes(String query);

}
