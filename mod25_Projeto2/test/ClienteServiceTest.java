import DAO.ClienteDAOMock;
import br.com.gustavokt.exVendas.DAO.IClienteDAO;
import br.com.gustavokt.exVendas.domain.Cliente;
import br.com.gustavokt.exVendas.services.ClienteService;
import br.com.gustavokt.exVendas.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        cliente.setNome("Gustavo");
        cliente.setTel(65544333L);
        cliente.setEnd("XX.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        cliente.setNumero(10);
        cliente.setCidade("Imperatriz");
        cliente.setUF("MA");
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
        cliente.setNome("Gustavo Cronemberger");
        clienteService.alterar(cliente);
        Assert.assertEquals("Gustavo Cronemberger", cliente.getNome());
    }
}
