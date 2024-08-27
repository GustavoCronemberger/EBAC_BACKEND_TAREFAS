package br.com.gustavokt;

import br.com.gustavokt.dao.IAlunoDAO;
import br.com.gustavokt.dao.AlunoDAO;
import br.com.gustavokt.domain.Aluno;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AlunoTest {
    private IAlunoDAO produtoDAO;

    public AlunoTest(){
        produtoDAO = new AlunoDAO();
    }


    @Test
    public void cadastrar(){
    Aluno aluno = new Aluno();
    aluno.setCodigo("#1233");
    aluno.setNome("Gilberto Souza");
    aluno = produtoDAO.cadastrar(aluno);
    assertNotNull(aluno);
    assertNotNull(aluno.getId());
    }
}
