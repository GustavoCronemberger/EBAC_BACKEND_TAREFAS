package br.com.gustavokt;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TesteSexo {
    @Test
    public void testeSexoF() {
        List<Pessoa> listaPessoas = new ArrayList<>();

        listaPessoas.add(new Pessoa("Gustavo", 30, "M"));
        listaPessoas.add(new Pessoa("Giulia", 10, "F"));
        listaPessoas.add(new Pessoa("Axl", 20, "M"));
        listaPessoas.add(new Pessoa("Lays", 26, "F"));

        List<Pessoa> mulheres = listaPessoas.stream()
                .filter(p -> p.getSexo().equals("F"))
                .toList();

        for (Pessoa mulher : mulheres) {
            Assert.assertEquals("F", mulher.getSexo());
        }
    }
}
