/**
 *
 */
package br.com.gustavokt.exVendas.domain;

/**
 *
 */
public class Cliente implements IPersistente {

    private String nome;
    private Long CPF;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String UF;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long cPF) {
        CPF = cPF;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String uF) {
        UF = uF;
    }

    @Override
    public Long getCodigo() {
        return null;
    }

}
