package br.com.ktgustavo.domain;

public class TabelaAnnotation{
    @Tabela (nome = "Tabela Exercício Módulo 19")
    public static class MyEntity{}

    public void lerTabelaAnnotation(Class<?> classe){
        if (classe.isAnnotationPresent(Tabela.class)){
            Tabela tabelaAnnotation = classe.getAnnotation(Tabela.class);
            String nomeTabela = tabelaAnnotation.nome();
            System.out.println("Nome da tabela: " + nomeTabela);
        }else {
            System.out.println("A anotação @Tabela não foi encontrada");
        }
    }
}
