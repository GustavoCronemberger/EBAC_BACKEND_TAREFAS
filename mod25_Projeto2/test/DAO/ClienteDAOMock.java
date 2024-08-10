package DAO;

import br.com.gustavokt.exVendas.DAO.IClienteDAO;
import br.com.gustavokt.exVendas.domain.Cliente;

import java.util.Collection;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) {
		return true;
	}

	@Override
	public void excluir(Long valor) {
		
	}

	@Override
	public void alterar(Cliente entity) {
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCPF(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return null;
	}


	


}
