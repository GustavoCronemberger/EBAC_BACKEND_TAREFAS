package br.com.gustavokt.domain;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "TB_MATRICULA")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matri_seq")
    @SequenceGenerator(name = "matri_seq", sequenceName = "sq_matricula", initialValue = 1, allocationSize = 1)
    //O generetor matri_seq é só um parametro para referenciar no name embaixo.
    //O nome da sequencia mesmo é o sequenceName
    //allocationSize é de quanto em quanto ela vai colocando os dados. Aqui foi escolhido de 1 em 1, mas pode ser qualquer valor.
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "DATA_MATRICULA", length = 10, nullable = false)
    private Instant dataMatricula;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
