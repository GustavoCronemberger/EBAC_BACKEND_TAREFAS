package br.com.gustavokt;

import br.com.gustavokt.dao.IProdutoDAO;
import br.com.gustavokt.dao.ProdutoDAO;
import br.com.gustavokt.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    public ProdutoTest(){
        produtoDAO = new ProdutoDAO();
    }


    @Test
    public void cadastrar(){
    Produto prd = new Produto();
    prd.setCodigo("#1233");
    prd.setNome("Teclado Mecânico");
    prd.setValor(400d);
    prd.setDescricao("Teclado Gamer silencioso");
    prd = produtoDAO.cadastrar(prd);
    assertNotNull(prd);
    assertNotNull(prd.getId());
    }
}
