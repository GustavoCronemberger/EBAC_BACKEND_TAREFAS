package br.com.gustavokt.DAO;

import br.com.gustavokt.DAO.generic.IGenericDAO;
import br.com.gustavokt.domain.Venda;
import br.com.gustavokt.exceptions.DAOException;
import br.com.gustavokt.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
