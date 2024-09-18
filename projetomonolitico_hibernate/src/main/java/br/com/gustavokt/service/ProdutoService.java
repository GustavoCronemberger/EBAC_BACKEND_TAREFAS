package br.com.gustavokt.service;

import br.com.gustavokt.dao.IProdutoDAO;
import br.com.gustavokt.domain.Produto;
import br.com.gustavokt.service.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDAO produtoDao;

    @Inject
    public ProdutoService(IProdutoDAO produtoDao) {
        super(produtoDao);
        this.produtoDao = produtoDao;
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        return produtoDao.filtrarProdutos(query);
    }

}
