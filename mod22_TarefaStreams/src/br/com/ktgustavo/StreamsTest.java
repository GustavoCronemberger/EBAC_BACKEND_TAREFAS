package br.com.ktgustavo;

import java.util.ArrayList;
import java.util.List;

public class StreamsTest {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();

        listaPessoas.add(new Pessoa("Gustavo", 30, "M"));
        listaPessoas.add(new Pessoa("Giulia", 10, "F"));
        listaPessoas.add(new Pessoa("Axl", 20, "M"));
        listaPessoas.add(new Pessoa("Lays", 26, "F"));

        System.out.println("Lista Completa");

        for (Pessoa pessoa : listaPessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Sexo: " + pessoa.getSexo());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");

        System.out.println("Lista Mulheres");

        listaPessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equals("F"))
                .forEach(m -> {
                    System.out.println("Nome: " + m.getNome());
                    System.out.println("Sexo: " + m.getSexo());
                    System.out.println("Idade: " + m.getIdade());
                    System.out.println();
                });
         }
    }
