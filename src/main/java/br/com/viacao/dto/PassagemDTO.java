package br.com.viacao.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PassagemDTO {

    @NotNull(message = "O campo deve ser informado")
    private Integer preco; // PRECO DA PASSAGEM
    @NotBlank(message = "O Campo deve ser informado")
    private String origem; // LOCAL DE ORIGEM QUE O PASSAGEIRO IRAR PEGAR O ONIBUS
    @NotBlank(message = "O Campo deve ser informado")
    private String destino; // LOCAL DE DESTINO DO PASSAGEIRO
    @NotNull(message = "O Campo deve ser informado")
    private Integer assento; // ASSENTO DO PASSAGEIRO

    @NotNull(message = "O Campo idViacao deve ser informado")
    private Long idViacao;

    // GETTERS E SETTERS DA CLASSE PASSAGEMDTO.JAVA

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

    public Long getIdViacao() {
        return this.idViacao;
    }
    public void setIdViacao(Long idViacao) {
        this.idViacao = idViacao;
    }
}
