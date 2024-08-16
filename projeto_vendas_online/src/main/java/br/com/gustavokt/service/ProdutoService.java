package br.com.gustavokt.service;

import br.com.gustavokt.DAO.IProdutoDAO;
import br.com.gustavokt.domain.Produto;
import br.com.gustavokt.service.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
