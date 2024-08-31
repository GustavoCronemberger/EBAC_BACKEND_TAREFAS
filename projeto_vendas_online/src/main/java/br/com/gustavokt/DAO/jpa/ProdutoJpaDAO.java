package br.com.gustavokt.DAO.jpa;

import br.com.gustavokt.DAO.generic.jpa.GenericJpaDAO;
import br.com.gustavokt.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {


    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }
}
