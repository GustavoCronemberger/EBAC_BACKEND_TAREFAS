package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDAO implements ICarroDAO {
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();
        //Começa a transação, manda salvar, faz o comit(obrigatório), fecha e retorna.
        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
