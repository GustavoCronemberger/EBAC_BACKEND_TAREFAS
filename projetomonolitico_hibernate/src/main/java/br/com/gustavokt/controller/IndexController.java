package br.com.gustavokt.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = 2898801926802118482L;

    public String redirectCliente() {
        return "/cliente/list.xhtml";
    }

    public String redirectProduto() {
        return "/produto/list.xhtml";
    }

    public String redirectVenda() {
        return "/venda/list.xhtml";
    }
}
