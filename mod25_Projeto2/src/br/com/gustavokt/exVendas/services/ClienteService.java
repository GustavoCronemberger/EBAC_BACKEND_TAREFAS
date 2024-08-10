package br.com.gustavokt.exVendas.services;


import br.com.gustavokt.exVendas.DAO.generics.GenericDAO;
import br.com.gustavokt.exVendas.DAO.IClienteDAO;
import br.com.gustavokt.exVendas.domain.Cliente;

public class ClienteService extends GenericDAO<Cliente> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super();
	}

	@Override
	public Class<Cliente> getTipoClass() {
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
	}

}
