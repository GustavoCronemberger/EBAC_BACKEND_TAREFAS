package br.com.gustavokt;

import br.com.gustavokt.dao.CursoDAO;
import br.com.gustavokt.dao.ICursoDAO;
import br.com.gustavokt.domain.Curso;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private ICursoDAO cursoDAO;

    public CursoTest(){
        cursoDAO = new CursoDAO();
    }
    @Test
    public void cadastrar(){
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java BackEnd");
        curso.setDescricao("Torne-se um desenvolvedor java em 6 meses com salário de R$ 5.000,00");
        curso = cursoDAO.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}
