package br.com.gustavokt.service;

import br.com.gustavokt.domain.Produto;
import br.com.gustavokt.service.generic.IGenericService;

import java.util.List;

public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}
