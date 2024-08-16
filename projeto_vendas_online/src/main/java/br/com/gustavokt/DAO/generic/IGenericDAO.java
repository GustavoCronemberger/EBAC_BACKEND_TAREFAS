package br.com.gustavokt.DAO.generic;

import br.com.gustavokt.DAO.Persistente;
import br.com.gustavokt.exceptions.DAOException;
import br.com.gustavokt.exceptions.MaisDeUmRegistroException;
import br.com.gustavokt.exceptions.TableException;
import br.com.gustavokt.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author gustavo cronemberger
 * Interface genérica para métodos CRUD
 * @param <T>
 * @param <E>
 */
public interface IGenericDAO <T extends Persistente, E extends Serializable> {
    /**
     * Método cadastrar novos registros no banco de dados
     *
     * @param entity
     * @return true para cadastrado false para não cadastrado
     * @throws TipoChaveNaoEncontradaException
     */
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método excluir registro no banco de dados
     * @param valor é uma chave única do dado a ser excluído
     * @throws DAOException
     */
    public void excluir(E valor) throws DAOException;

    /**
     * Método alterar registro no banco de dados
     * @param entity a ser atualizado
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método consultar registro no banco de dados
     * @param valor chave única do dado a ser consultado
     * @throws DAOException, MaisDeUmRegistroException.
     */
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método para retornar todos os registros do banco de dados de um dado ou tabela
     * @return registros encontrados
     * @throws DAOException
     */
    public Collection<T> buscarTodos() throws DAOException;
}

