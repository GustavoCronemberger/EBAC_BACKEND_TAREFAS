package exVendas.DAO;

import java.util.Collection;

import exVendas.domain.Cliente;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCPF(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	


}
