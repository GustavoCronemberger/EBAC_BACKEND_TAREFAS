package br.com.gustavokt.DAO;

/**
 * Classe que representa todas as entidades ou objetos da aplicação que serão salvas no banco de dados
 */
public interface Persistente {

    public Long getId();

    public void setId(Long id);
}
