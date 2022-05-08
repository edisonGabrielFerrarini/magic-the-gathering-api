package com.mtg.magic.game.adapters.repository.core.builder;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;

import java.time.LocalDateTime;

public class EdicaoJPABuilder {

    private EdicaoJPA edicaoJPA;

    public EdicaoJPABuilder(){
        this.edicaoJPA = new EdicaoJPA();
    }

    public static EdicaoJPABuilder builder(){
        return new EdicaoJPABuilder();
    }

    public EdicaoJPABuilder addAno(Integer ano){
        this.edicaoJPA.setAno(ano);
        return this;
    }

    public EdicaoJPABuilder addId(Long id){
        this.edicaoJPA.setId(id);
        return this;
    }

    public EdicaoJPABuilder addNome(String nome){
        this.edicaoJPA.setNome(nome);
        return this;
    }

    public EdicaoJPABuilder addSiglaEdicao(String siglaEdicao){
        this.edicaoJPA.setSiglaEdicao(siglaEdicao);
        return this;
    }

    public EdicaoJPABuilder addCreatedAt(LocalDateTime criacao){
        this.edicaoJPA.setCreatedAt(criacao);
        return this;
    }

    public EdicaoJPABuilder addUpdateAt(LocalDateTime update){
        this.edicaoJPA.setUpdatedAt(update);
        return this;
    }

    public EdicaoJPA build(){
        return this.edicaoJPA;
    }
    
}
