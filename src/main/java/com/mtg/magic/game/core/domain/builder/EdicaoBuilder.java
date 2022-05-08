package com.mtg.magic.game.core.domain.builder;

import com.mtg.magic.game.core.domain.model.Edicao;

import java.time.LocalDateTime;

public class EdicaoBuilder {

    private Edicao edicao;

    public EdicaoBuilder(){
        this.edicao = new Edicao();
    }

    public static EdicaoBuilder builder(){
        return new EdicaoBuilder();
    }

    public EdicaoBuilder addAno(Integer ano){
        this.edicao.setAno(ano);
        return this;
    }

    public EdicaoBuilder addId(Long id){
        this.edicao.setId(id);
        return this;
    }

    public EdicaoBuilder addCreatedAt(LocalDateTime criacao){
        this.edicao.setCreatedAt(criacao);
        return this;
    }

    public EdicaoBuilder addUpdateAt(LocalDateTime update){
        this.edicao.setUpdateAt(update);
        return this;
    }

    public EdicaoBuilder addNome(String nome){
        this.edicao.setNome(nome);
        return this;
    }

    public EdicaoBuilder addEdicao(String siglaEdicao){
        this.edicao.setSiglaEdicao(siglaEdicao);
        return this;
    }


    public Edicao build(){
        return this.edicao;
    }

}
