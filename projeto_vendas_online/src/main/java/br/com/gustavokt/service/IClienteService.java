package br.com.gustavokt.service;

import br.com.gustavokt.domain.Cliente;
import br.com.gustavokt.exceptions.DAOException;
import br.com.gustavokt.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
