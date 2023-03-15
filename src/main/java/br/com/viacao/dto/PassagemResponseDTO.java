package br.com.viacao.dto;

import java.util.HashMap;
import java.util.Map;

import br.com.viacao.model.PassagemModel;

public class PassagemResponseDTO {
    
    private Long id;
    private Integer preco;
    private String origem;
    private String destino;
    private Integer assento;
    private Map<String, Object> viacao;

    public PassagemResponseDTO(PassagemModel passagemModel) {
        this.id = passagemModel.getId();
        this.preco = passagemModel.getPreco();
        this.origem = passagemModel.getOrigem();
        this.destino = passagemModel.getDestino();
        this.assento = passagemModel.getAssento();
        
        this.viacao = new HashMap<String, Object>();
        this.viacao.put("nome", passagemModel.getViacao().getNome());
    }

    // METODOS GETTERS E SETTERS DA CLASSE PASSAGEMRESPONSEDTO.JAVA
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

    public Integer getAssento() {
        return this.assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public Map<String,Object> getViacao() {
        return this.viacao;
    }

    public void setViacao(Map<String,Object> viacao) {
        this.viacao = viacao;
    }


}
