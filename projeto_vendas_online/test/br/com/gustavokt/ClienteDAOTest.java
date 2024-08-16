package br.com.gustavokt;

import br.com.gustavokt.DAO.ClienteDAO;
import br.com.gustavokt.DAO.IClienteDAO;
import br.com.gustavokt.domain.Cliente;
import br.com.gustavokt.exceptions.DAOException;
import br.com.gustavokt.exceptions.MaisDeUmRegistroException;
import br.com.gustavokt.exceptions.TableException;
import br.com.gustavokt.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }
    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos(); //Tem que estar apontado para um BDTest, pois se apontar para o BDProducao irá excluir tudo.
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(455445676767L);
        cliente.setNome("Gustavo");
        cliente.setCidade("Maranhão");
        cliente.setEnd("Rua dos Santos");
        cliente.setEstado("MA");
        cliente.setNumero(11);
        cliente.setTel(99923757775L);
        cliente.setEmail("gustavo@gustavokt.com");
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(455445676767L);
        cliente.setNome("Gustavo");
        cliente.setCidade("Maranhão");
        cliente.setEnd("Rua dos Santos");
        cliente.setEstado("MA");
        cliente.setNumero(11);
        cliente.setTel(99923757775L);
        cliente.setEmail("gustavo@gustavokt.com");
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(455445676767L);
        cliente.setNome("Gustavo");
        cliente.setCidade("Maranhão");
        cliente.setEnd("Rua dos Santos");
        cliente.setEstado("MA");
        cliente.setNumero(11);
        cliente.setTel(99923757775L);
        cliente.setEmail("gustavo@gustavokt.com");
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(455445676767L);
        cliente.setNome("Gustavo");
        cliente.setCidade("Maranhão");
        cliente.setEnd("Rua dos Santos");
        cliente.setEstado("MA");
        cliente.setNumero(11);
        cliente.setTel(99923757775L);
        cliente.setEmail("gustavo@gustavokt.com");
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Gustavo Cronemberger");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Gustavo Cronemberger", clienteAlterado.getNome());

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(455445676767L);
        cliente.setNome("Gustavo");
        cliente.setCidade("Maranhão");
        cliente.setEnd("Rua dos Santos");
        cliente.setEstado("MA");
        cliente.setNumero(11);
        cliente.setTel(99923757775L);
        cliente.setEmail("gustavo@gustavokt.com");
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(412212112L);
        cliente1.setNome("Alex");
        cliente1.setCidade("Maranhão");
        cliente1.setEnd("Rua dos Santos");
        cliente1.setEstado("MA");
        cliente1.setNumero(11);
        cliente1.setTel(99923757775L);
        cliente1.setEmail("alex@gustavokt.com");
        Boolean retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.isEmpty());
    }
}
