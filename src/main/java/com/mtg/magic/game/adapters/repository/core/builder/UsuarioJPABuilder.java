package com.mtg.magic.game.adapters.repository.core.builder;

import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;

public class UsuarioJPABuilder {

    private UsuarioJPA usuarioJPA;

    public UsuarioJPABuilder() {
        this.usuarioJPA = new UsuarioJPA();
    }

    public static UsuarioJPABuilder builder(){
        return new UsuarioJPABuilder();
    }

    public UsuarioJPABuilder addLogin(String login){
        this.usuarioJPA.setLogin(login);
        return this;
    }

    public UsuarioJPABuilder addPassword(String password){
        this.usuarioJPA.setPassword(password);
        return this;
    }

    public UsuarioJPA build(){
        return this.usuarioJPA;
    }

}
