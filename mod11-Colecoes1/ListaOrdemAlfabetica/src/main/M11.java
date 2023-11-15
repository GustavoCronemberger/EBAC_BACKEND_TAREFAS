package main;

import java.util.*;

public class M11 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> masculino = new HashSet<>();
        Set<String> feminino = new HashSet<>();

        while (true) {
            System.out.print("Digite o nome (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine();

            if (sexo.equalsIgnoreCase("M")) {
                masculino.add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                feminino.add(nome);
            } else {
                System.out.println("Sexo inválido. Digite 'M' para masculino ou 'F' para feminino.");
            }
        }

        System.out.println("\n*** Grupo Masculino ***");
        if (!masculino.isEmpty()) {
            for (String nome : masculino) {
                System.out.println(nome);
            }
        } else {
            System.out.println("Nenhum nome masculino registrado.");
        }

        System.out.println("\n*** Grupo Feminino ***");
        if (!feminino.isEmpty()) {
            for (String nome : feminino) {
                System.out.println(nome);
            }
        } else {
            System.out.println("Nenhum nome feminino registrado.");

        }

    }
}
