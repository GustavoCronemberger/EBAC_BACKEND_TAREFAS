package br.com.gustavokt.domain;

/**
 * Classe que representa todas as entidades/objetos da aplicação que serão salvas no BD
 */
public interface Persistente {

    public Long getId();

    public void setId(Long id);
}
