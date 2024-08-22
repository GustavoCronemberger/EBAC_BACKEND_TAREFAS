package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Produto cadastrar(Produto prd) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(prd);
        entityManager.getTransaction().commit();
        //Começa a transação, manda salvar o curso, faz o comit(obrigatório), fecha e retorna o curso
        entityManager.close();
        entityManagerFactory.close();

        return prd;
    }
}
