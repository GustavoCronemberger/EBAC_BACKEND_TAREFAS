package br.com.gustavokt.exVendas.DAO.generics;

import java.util.Collection;

import br.com.gustavokt.exVendas.domain.IPersistente;

public interface IGenericDAO<T extends IPersistente> {

    public Boolean cadastrar(T entity);

    public void excluir(Long valor);

    public void alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();

}
