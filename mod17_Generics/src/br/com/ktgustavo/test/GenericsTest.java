package br.com.ktgustavo.test;

import br.com.ktgustavo.domain.AudiCar;
import br.com.ktgustavo.domain.Carros;
import br.com.ktgustavo.domain.MercedesCar;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        List<Carros> listaCarros = new ArrayList<Carros>();
        listaCarros.add(new AudiCar("A5"));
        listaCarros.add(new MercedesCar("AMG GT"));

        for (Carros carro : listaCarros) {
            carro.exibirDetalhes();
        }
    }
}
