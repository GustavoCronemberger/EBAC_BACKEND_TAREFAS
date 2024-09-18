package br.com.gustavokt.dao;

import br.com.gustavokt.dao.generic.IGenericDAO;
import br.com.gustavokt.domain.Produto;

import java.util.List;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}