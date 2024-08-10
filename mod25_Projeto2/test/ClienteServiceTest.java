package exVendas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exVendas.DAO.IClienteDAO;
import exVendas.DAO.ClienteDAOMock;
import exVendas.domain.Cliente;
import exVendas.services.ClienteService;
import exVendas.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
	    IClienteDAO dao = new ClienteDAOMock();
	    clienteService = new ClienteService(dao);
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
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.consultar(cliente.getCPF());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteService.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCPF());
	}
	
	@Test
	public void alterarCliente() {
		cliente.setNome("Jailson Jau");
		clienteService.alterar(cliente);
		Assert.assertEquals("Jailson Jau", cliente.getNome());
	}
}
