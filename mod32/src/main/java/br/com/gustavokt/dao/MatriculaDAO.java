package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Curso;
import br.com.gustavokt.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

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

    @Override
    public Matricula buscarPorCodigoCurso(String codigoCurso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
/**
 * Aqui temos a JPQL, que é uma linguagem sql da JPA orientada a objetos
 * Diferente do até então, aqui a query é com os objetos e seus atributos, não usa-se os nomes das tabelas e colunas.
 * O m.curso, é a propriedade curso que tem no objeto Matricula.
 * O ':' é como se fosse um ?. :codigoCurso será substituído pelo parâmetro String codigoCurso.
 */
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c.codigo = :codigoCurso");

        entityManager.getTransaction().begin();
        TypedQuery<Matricula> query =
                entityManager.createQuery(sb.toString(), Matricula.class);
        query.setParameter("codigoCurso", codigoCurso);
        Matricula matricula = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCurso(Curso curso) {
        /**
         * A duferença desse buscar para o por Codigo, é que aqui você passa o objeto Curso diretamente, e não pelo atributo código.
         */
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c = :curso");

        entityManager.getTransaction().begin();
        TypedQuery<Matricula> query =
                entityManager.createQuery(sb.toString(), Matricula.class);
        query.setParameter("curso", curso);
        Matricula matricula = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);//É igual ao Select From no sql
        Join<Object, Object> join = root.join("curso", JoinType.INNER);//Aqui é o join
        query.select(root).where(builder.equal(join.get("codigo"), codigoCurso));//Aqui o final colocando o where também

        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        Matricula matricula = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCursoCriteria(Curso curso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);
        Join<Object, Object> join = root.join("curso", JoinType.INNER);
        query.select(root).where(builder.equal(join, curso));

        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        Matricula matricula = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public List<Matricula> buscarTodos() { //Buscar todas as matriculas que estão no BD
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);
        query.select(root);//Não precisa de join e where já que é buscando tudo

        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        List<Matricula> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return list;
    }

    @Override
    public Matricula excluir(Matricula mat) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        mat = entityManager.merge(mat);
        entityManager.remove(mat);
        entityManager.getTransaction().commit();
        //Começa a transação, manda excluir, faz o comit(obrigatório), fecha.
        entityManager.close();
        entityManagerFactory.close();
        return mat;
    }
}
