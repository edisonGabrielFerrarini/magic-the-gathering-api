package com.mtg.magic.game.adapters.repository.core.builder;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.core.domain.type.IdiomaType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaJPABuilder {
    private CartaJPA cartaJPA;

    public CartaJPABuilder() {
        this.cartaJPA = new CartaJPA();
    }

    public static CartaJPABuilder builder(){
        return new CartaJPABuilder();
    }

    public CartaJPABuilder addNome(String nome){
        this.cartaJPA.setNome(nome);
        return this;
    }

    public CartaJPABuilder addCreatedAt(LocalDateTime criacao){
        this.cartaJPA.setCreatedAt(criacao);
        return this;
    }

    public CartaJPABuilder addId(Long id){
        this.cartaJPA.setId(id);
        return this;
    }

    public CartaJPABuilder addUsuario(UsuarioJPA usuarioJPA){
        this.cartaJPA.setUsuario(usuarioJPA);
        return this;
    }

    public CartaJPABuilder addUpdateAt(LocalDateTime update){
        this.cartaJPA.setUpdatedAt(update);
        return this;
    }

    public CartaJPABuilder addQuantidadeDeCartas(Integer quantidade){
        this.cartaJPA.setQuantidadeDeCartas(quantidade);
        return this;
    }

    public CartaJPABuilder addEdicao(EdicaoJPA edicaoJPA){
        this.cartaJPA.setEdicao(edicaoJPA);
        return this;
    }

    public CartaJPABuilder addIdioma(IdiomaType idiomaType){
        this.cartaJPA.setIdioma(idiomaType);
        return this;
    }

    public CartaJPABuilder isFoil(Boolean foil){
        this.cartaJPA.setFoil(foil);
        return this;
    }

    public CartaJPABuilder addValor(BigDecimal valor){
        this.cartaJPA.setValor(valor);
        return this;
    }


    public CartaJPA build(){
        return this.cartaJPA;
    }
}
