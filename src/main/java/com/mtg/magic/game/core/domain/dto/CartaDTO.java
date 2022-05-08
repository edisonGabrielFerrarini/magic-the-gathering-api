package com.mtg.magic.game.core.domain.dto;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.IdiomaType;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Validated
public class CartaDTO {
    Long id;
    @NotNull
    String nome;
    @NotNull
    String siglaEdicao;
    @NotNull
    IdiomaType idioma;
    @NotNull
    Boolean foil;
    @NotNull
    BigDecimal valor;
    @NotNull
    Integer quantidadeDeCartas;

    public static CartaDTO gerarCartaDTO(Carta carta) {
        CartaDTO cartaDTO = new CartaDTO();
        cartaDTO.setId(carta.getId());
        cartaDTO.setFoil(carta.getFoil());
        cartaDTO.setNome(carta.getNome());
        cartaDTO.setQuantidadeDeCartas(carta.getQuantidadeDeCartas());
        cartaDTO.setIdioma(carta.getIdioma());
        cartaDTO.setSiglaEdicao(carta.getEdicao().getSiglaEdicao());
        cartaDTO.setValor(carta.getValor());
        return cartaDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeDeCartas() {
        return quantidadeDeCartas;
    }

    public void setQuantidadeDeCartas(Integer quantidadeDeCartas) {
        this.quantidadeDeCartas = quantidadeDeCartas;
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaEdicao() {
        return siglaEdicao;
    }

    public void setSiglaEdicao(String siglaEdicao) {
        this.siglaEdicao = siglaEdicao;
    }

    public IdiomaType getIdioma() {
        return idioma;
    }

    public void setIdioma(IdiomaType idioma) {
        this.idioma = idioma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Boolean getFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
