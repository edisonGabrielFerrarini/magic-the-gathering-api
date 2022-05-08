package com.mtg.magic.game.core.domain.builder;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.domain.type.IdiomaType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaBuilder {

    private Carta carta;

    public CartaBuilder() {
        this.carta = new Carta();
    }

    public static CartaBuilder builder(){
        return new CartaBuilder();
    }

    public CartaBuilder addNome(String nome){
        this.carta.setNome(nome);
        return this;
    }

    public CartaBuilder addUsuario(String login){
        this.carta.setUsuario(login);
        return this;
    }

    public CartaBuilder addId(Long id){
        this.carta.setId(id);
        return this;
    }

    public CartaBuilder addCreatedAt(LocalDateTime criacao){
        this.carta.setCreatedAt(criacao);
        return this;
    }

    public CartaBuilder addUpdateAt(LocalDateTime update){
        this.carta.setUpdatedAt(update);
        return this;
    }

    public CartaBuilder addQuantidadeDeCartas(Integer quantidade){
        this.carta.setQuantidadeDeCartas(quantidade);
        return this;
    }

    public CartaBuilder addEdicao(Edicao edicao){
        this.carta.setEdicao(edicao);
        return this;
    }

    public CartaBuilder addIdioma(IdiomaType idiomaType){
        this.carta.setIdioma(idiomaType);
        return this;
    }

    public CartaBuilder isFoil(Boolean foil){
        this.carta.setFoil(foil);
        return this;
    }

    public CartaBuilder addValor(BigDecimal valor){
        this.carta.setValor(valor);
        return this;
    }

    public Carta build(){
        return this.carta;
    }

}
