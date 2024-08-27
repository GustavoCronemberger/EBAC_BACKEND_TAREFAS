package br.com.gustavokt;

import br.com.gustavokt.dao.*;
import br.com.gustavokt.domain.Acessorio;
import br.com.gustavokt.domain.Carro;
import br.com.gustavokt.domain.Marca;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarroTest {
    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;
    private IAcessorioDAO acessorioDAO;
    private List<Carro> carros;

    public CarroTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void cadastrar(){
        Marca marca = criarMarca();
        Acessorio acessorio = criarAcessorio(carros);

        Carro carro = new Carro();
        carro.setCodigo("01");
        carro.setNome("Corolla XLR");
        carro.setPreco(150000.00);
        carro.setTipo("Sedan");
        carro.setMarca(marca);
        Carro carro2 = new Carro();
        carro.setCodigo("02");
        carro.setNome("Corolla XR");
        carro.setPreco(120000.00);
        carro.setTipo("Sedan");
        carro.setMarca(marca);

        List<Carro> carros = new ArrayList<>();
        carros.add(carro);
        carros.add(carro2);
    }

    private Acessorio criarAcessorio(List<Carro> carros) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Aerofolio");
        acessorio.setCodigo("#1");
        acessorio.setPreco(5000.00);
        acessorio.setObservacao("Aerofolio para Corolla");
        acessorio.setCarros(carros);
        return acessorioDAO.cadastrar(acessorio);
    }

    private Marca criarMarca() {
        Marca marca = new Marca();
        marca.setCodigo("01");
        marca.setNome("Toyota");
        marca.setPaisOrigem("Japão");
        marca.setCodigo("A1");
        return marcaDAO.cadastrar(marca);
    }
}
