package br.com.gustavokt.dao;

import br.com.gustavokt.dao.generic.GenericDAO;
import br.com.gustavokt.domain.Cliente;

import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        TypedQuery<Cliente> tpQuery =
                this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();

    }

}
