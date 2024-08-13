package br.com.gustavokt;

import br.com.gustavokt.DAO.IProdutoDAO;
import br.com.gustavokt.DAO.ProdutoDAO;
import br.com.gustavokt.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Motosserra");
        Integer countCad = produtoDAO.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Motosserra");
        Integer countCad = produtoDAO.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Motosserra");
        Integer countCad = produtoDAO.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        Assert.assertTrue(countDel == 1);

    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Motosserra");
        Integer countCad = produtoDAO.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Cerrote");
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        Assert.assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.buscar("10");
        Assert.assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("20");
        Assert.assertNotNull(produtoBD2);
        Assert.assertEquals(produtoBD.getId(), produtoBD2.getId());
        Assert.assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        Assert.assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
        }
    }

    @Test
    public void buscarTodosTest() throws Exception {//Cria uma lista de produtos e verifica se estão lá, estando irão ser excluídos. Busca novamente e não deve mais haver ninguém na lista.
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Motosserra");
        produto.setCodigo("10");
        Integer countCad = produtoDAO.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produtos = new Produto();
        produtos.setNome("Teste");
        produtos.setCodigo("20");
        Integer countCad2 = produtoDAO.cadastrar(produtos);
        Assert.assertTrue(countCad2 == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        int countDel = 0;
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
            countDel++;
        }
        Assert.assertEquals(list.size(), countDel);
        list = produtoDAO.buscarTodos();
        Assert.assertEquals(list.size(), 0);
    }
}
