package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO{
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();
        //Começa a transação, manda salvar, faz o comit(obrigatório), fecha e retorna.
        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }
}
