package br.com.viacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PassagemModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer preco; // PRECO DA PASSAGEM
    @Column(nullable = false)
    private String origem; // LOCAL DE ORIGEM QUE O PASSAGEIRO IRAR PEGAR O ONIBUS
    @Column(nullable = false)
    private String destino; // LOCAL DE DESTINO DO PASSAGEIRO
    @Column(nullable = false)
    private Integer assento; // ASSENTO DO PASSAGEIRO

    @ManyToOne
    @JoinColumn(name = "id_viacao")
    private ViacaoModel viacao; // VIACAO VINCULADA A PASSAGEM (N PASSAGENS PODEM PERTENCE A 1 VIACAO)

    // GETTERS E SETTERS DA CLASSE PASSAGEMMODEL.JAVA
    public Long getId() {
        return this.id;
    }    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getPreco() {
        return this.preco;
    }
    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public String getOrigem() {
        return this.origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return this.destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ViacaoModel getViacao() {
        return this.viacao;
    }
    public void setViacao(ViacaoModel viacao) {
        this.viacao = viacao;
    }

    public Integer getAssento() {
        return this.assento;
    }
    public void setAssento(Integer assento) {
        this.assento = assento;
    }

}
