package br.com.gustavokt;


import br.com.gustavokt.dao.*;
import br.com.gustavokt.domain.Aluno;
import br.com.gustavokt.domain.Computador;
import br.com.gustavokt.domain.Curso;
import br.com.gustavokt.domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class MatriculaTest {

    private IMatriculaDAO matriculaDAO;
    private IAlunoDAO alunoDAO;
    private ICursoDAO cursoDAO;
    private IComputadorDAO computadorDAO;


    public MatriculaTest() {
        matriculaDAO = new MatriculaDAO();
        alunoDAO = new AlunoDAO();
        cursoDAO = new CursoDAO();
        computadorDAO = new ComputadorDAO();
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("01");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(3900d);
        mat.setCurso(curso);
        mat.setAluno(aluno);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matBD = matriculaDAO.buscarPorCodigoCurso(mat.getCodigo());
        assertNotNull(matBD);
        assertEquals(mat.getId(), matBD.getId());

        Matricula matBDObj = matriculaDAO.buscarPorCurso(curso);
        assertNotNull(matBDObj);
        assertEquals(mat.getId(), matBDObj.getId());
    }

    private Computador criarComputador(String codigo) {
        Computador comp = new Computador();
        comp.setCodigo(codigo);
        comp.setDescricao("Comp 1");
        return comp;
        //return computadorDao.cadastrar(comp);
    }

    private Aluno criarAluno(String codigo) {
        Computador comp = criarComputador("A1");
        Computador comp2 = criarComputador("A2");
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome("Rodrigo");
        aluno.add(comp);
        aluno.add(comp2);
        //comp.add(aluno);
        //comp2.add(aluno);
        return alunoDAO.cadastrar(aluno);
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        return cursoDAO.cadastrar(curso);
    }
}
