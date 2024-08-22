package br.com.gustavokt;

import br.com.gustavokt.dao.IMatriculaDAO;
import br.com.gustavokt.dao.MatriculaDAO;
import br.com.gustavokt.domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    private IMatriculaDAO matriculaDAO;

    public MatriculaTest() {
        matriculaDAO = new MatriculaDAO();
    }

    @Test
    public void cadastrar() {
        Matricula mat = new Matricula();
        mat.setCodigo("01");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(3900d);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());
    }
}
