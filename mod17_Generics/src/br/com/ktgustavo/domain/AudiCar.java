package br.com.ktgustavo.domain;

/**
 * @author gusta
 */
public class AudiCar extends Carros {


    public AudiCar(String modelo) {
        super("Audi", modelo);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Marca: " + this.getMarca() + "; Modelo: " + this.getModelo());
    }
}