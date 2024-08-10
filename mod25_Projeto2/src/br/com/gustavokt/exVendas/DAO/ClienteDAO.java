package br.com.gustavokt.exVendas.DAO;

import br.com.gustavokt.exVendas.DAO.generics.GenericDAO;
import br.com.gustavokt.exVendas.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClass() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }

}
