package br.com.gustavokt;

import br.com.gustavokt.DAO.ClienteDAO;
import br.com.gustavokt.DAO.IClienteDAO;
import br.com.gustavokt.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Gustavo Cronemberger");
        Integer countCad = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Gustavo Cronemberger");
        Integer countCad = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Gustavo Cronemberger");
        Integer countCad = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        Assert.assertTrue(countDel == 1);

    }@Test
    public void atualizarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Gustavo Cronemberger");
        Integer countCad = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Axl");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        Assert.assertTrue(countUpdate == 1);

        Cliente clienteBD1 = clienteDAO.buscar("10");
        Assert.assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.buscar("20");
        Assert.assertNotNull(clienteBD2);
        Assert.assertEquals(clienteBD.getId(), clienteBD2.getId());
        Assert.assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        Assert.assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list){
            clienteDAO.excluir(cli);
        }
    }

    @Test
    public void buscarTodosTest() throws Exception {//Cria uma lista de clientes e verifica se estão lá, estando irão ser excluídos. Busca novamente e não deve mais haver ninguém na lista.
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNome("Gustavo Cronemberger");
        cliente.setCodigo("10");
        Integer countCad = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setNome("Teste");
        clientes.setCodigo("20");
        Integer countCad2 = clienteDAO.cadastrar(clientes);
        Assert.assertTrue(countCad2 == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        int countDel = 0;
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        Assert.assertEquals(list.size(), countDel);
        list = clienteDAO.buscarTodos();
        Assert.assertEquals(list.size(), 0);
    }
}
