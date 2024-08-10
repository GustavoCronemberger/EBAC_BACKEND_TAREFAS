package exVendas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exVendas.DAO.ClienteDAOMock;
import exVendas.DAO.IClienteDAO;
import exVendas.domain.Cliente;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDAOMock();
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCPF(11111111111L);
		cliente.setNome("Jailson");
		cliente.setTel(99999999L);
		cliente.setEnd("Cel. Miguel Satiro");
		cliente.setNumero(30);
		cliente.setCidade("João Pessoa");
		cliente.setUF("PB");
		
		clienteDAO.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDAO.consultar(cliente.getCPF());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteDAO.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDAO.excluir(cliente.getCPF());
	}
	
	@Test
	public void alterarCliente() {
		cliente.setNome("Jailson Jau");
		clienteDAO.alterar(cliente);
		
		Assert.assertEquals("Jailson Jau", cliente.getNome());
	}

}
