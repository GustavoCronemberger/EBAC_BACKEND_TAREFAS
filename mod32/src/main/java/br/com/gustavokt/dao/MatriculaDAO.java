package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MatriculaDAO implements IMatriculaDAO{
    @Override
    public Matricula cadastrar(Matricula mat) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(mat);
        entityManager.getTransaction().commit();
        //Começa a transação, manda salvar o curso, faz o comit(obrigatório), fecha e retorna o curso
        entityManager.close();
        entityManagerFactory.close();

        return mat;
    }
}
