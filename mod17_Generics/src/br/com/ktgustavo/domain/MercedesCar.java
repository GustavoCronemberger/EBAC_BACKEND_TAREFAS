package br.com.ktgustavo.domain;

public class MercedesCar extends Carros{


    public MercedesCar(String modelo) {
        super("Mercedes", modelo);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Marca: " + this.getMarca() + "; Modelo: " + this.getModelo());
    }
}
