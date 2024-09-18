package br.com.gustavokt.dao;

import br.com.gustavokt.dao.generic.IGenericDAO;
import br.com.gustavokt.domain.Cliente;

import java.util.List;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    List<Cliente> filtrarClientes(String query);

}
