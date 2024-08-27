package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlunoDAO implements IAlunoDAO {
    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
        //Começa a transação, manda salvar o curso, faz o comit(obrigatório), fecha e retorna o curso
        entityManager.close();
        entityManagerFactory.close();

        return aluno;
    }
}
