package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoDAO implements ICursoDAO{
    @Override
    public Curso cadastrar(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
     //Começa a transação, manda salvar o curso, faz o comit(obrigatório), fecha e retorna o curso
        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }
}
