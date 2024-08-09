import br.com.gustavokt.dao.ContratoDao;
import br.com.gustavokt.dao.IContratoDao;
import br.com.gustavokt.dao.mock.ContratoDaoMock;
import br.com.gustavokt.service.ContratoService;
import br.com.gustavokt.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String salvado = service.salvarTest();
        Assert.assertEquals("Salvado com sucesso", salvado);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErronoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String salvado = service.salvarTest();
        Assert.assertEquals("Salvado com sucesso", salvado);
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String encontrado = service.buscarTest();
        Assert.assertEquals("Encontrado com sucesso", encontrado);
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String atualizado = service.atualizarTest();
        Assert.assertEquals("Atualizado com sucesso", atualizado);
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String excluido = service.excluirTest();
        Assert.assertEquals("Excluído com sucesso", excluido);
    }
}