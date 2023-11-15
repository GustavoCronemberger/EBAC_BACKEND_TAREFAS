package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parte2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map<String, String> pessoas = new HashMap<>();

        while (true) {
            System.out.print("Digite os nomes e seu respectivo gênero (M-masculino e F-feminino), Ex: 'João-M, Ana-F' ou 'Sair': ");
            String entrada = input.nextLine();
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String[] arrayNomes = entrada.split(",");

            for (String nomeSexo : arrayNomes) {
                String[] dados = nomeSexo.trim().split("-");
                if (dados.length == 2) {
                    String nome = dados[0].trim();
                    String sexo = dados[1].trim().toUpperCase();
                    if (sexo.equals("M") || sexo.equals("F")) {
                        pessoas.put(nome, sexo);
                    } else {
                        System.out.println("Sexo inválido: " + sexo);
                    }
                } else {
                    System.out.println("Formato inválido: " + nomeSexo);
                }
            }
        }

        System.out.println("\n--- Grupo Masculino ---");
        imprimirGrupo(pessoas, "M");

        System.out.println("\n--- Grupo Feminino ---");
        imprimirGrupo(pessoas, "F");

        input.close();
    }

    private static void imprimirGrupo(Map<String, String> pessoas, String sexo) {
        boolean encontrado = false;
        for (Map.Entry<String, String> entry : pessoas.entrySet()) {
            String nome = entry.getKey();
            String s = entry.getValue();
            if (s.equals(sexo)) {
                System.out.println(nome);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum nome " + (sexo.equals("M") ? "masculino" : "feminino") + " registrado.");
        }
    }
}

