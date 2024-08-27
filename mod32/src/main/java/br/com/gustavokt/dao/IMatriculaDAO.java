package br.com.gustavokt.dao;

import br.com.gustavokt.domain.Curso;
import br.com.gustavokt.domain.Matricula;

import java.util.List;

public interface IMatriculaDAO {

    Matricula cadastrar(Matricula mat);

    Matricula buscarPorCodigoCurso(String codigoCurso);

    Matricula buscarPorCurso(Curso curso);

    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    Matricula buscarPorCursoCriteria(Curso curso);

    List<Matricula> buscarTodos();

    Matricula excluir(Matricula mat);
}
