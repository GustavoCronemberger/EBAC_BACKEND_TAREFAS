package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
    public static void main (String[] args){
        listaNomesOrdemAlfabetica();


    }

    private static void listaNomesOrdemAlfabetica() {
        System.out.println("****ListaOrdemAlfabética****");
        List<String> lista = new ArrayList<>();
        lista.add("Fabrício");
        lista.add("Leonardo");
        lista.add("Gustavo");
        lista.add("Felipe");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println(" ");

    }
}
