import DAO.ClienteDAOMock;
import br.com.gustavokt.exVendas.DAO.IClienteDAO;
import br.com.gustavokt.exVendas.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		cliente.setNome("Gustavo");
		cliente.setTel(65544333L);
		cliente.setEnd("XX.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		cliente.setNumero(10);
		cliente.setCidade("Imperatriz");
		cliente.setUF("MA");
		
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
		cliente.setNome("Gustavo Cronemberger");
		clienteDAO.alterar(cliente);
		
		Assert.assertEquals("Gustavo Cronemberger", cliente.getNome());
	}

}
