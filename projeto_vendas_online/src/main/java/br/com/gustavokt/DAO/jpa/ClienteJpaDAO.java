package br.com.gustavokt.DAO.jpa;

import br.com.gustavokt.DAO.generic.jpa.GenericJpaDAO;
import br.com.gustavokt.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {
//Com a JPA não há mais querys sql!
    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }


}
