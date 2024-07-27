package br.com.ktgustavo.test;

import br.com.ktgustavo.domain.TabelaAnnotation;

public class ReflectionTest01 {
    public static void main(String[] args) {
        Class<TabelaAnnotation.MyEntity> clazz = TabelaAnnotation.MyEntity.class;
        TabelaAnnotation tabelaAnnotation = new TabelaAnnotation();
        tabelaAnnotation.lerTabelaAnnotation(clazz);
    }
}
