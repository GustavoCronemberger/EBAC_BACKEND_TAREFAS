package colecoes;

import java.util.Arrays;
import java.util.Scanner;

public class Parte1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Digite os nomes separados por ',' ou 'Sair': ");
            String nomes = input.nextLine();
            if (nomes.equalsIgnoreCase("Sair")) {
                break;
            }

            String[] arrayNomes = nomes.split(",");

            System.out.println("Ordem Alfabética");
            Arrays.sort(arrayNomes);

            for (String nome : arrayNomes) {
                System.out.println(nome.trim());
            }
        }
        input.close();
    }
}

