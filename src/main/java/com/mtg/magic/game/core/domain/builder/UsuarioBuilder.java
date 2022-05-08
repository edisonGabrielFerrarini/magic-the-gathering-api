package com.mtg.magic.game.core.domain.builder;

import com.mtg.magic.game.core.domain.model.Usuario;

public class UsuarioBuilder {

    private Usuario usuario;

    public UsuarioBuilder() {
        this.usuario = new Usuario();
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public UsuarioBuilder addLogin(String login){
        this.usuario.setLogin(login);
        return this;
    }

    public UsuarioBuilder addPassword(String password){
        this.usuario.setPassword(password);
        return this;
    }

    public Usuario build(){
        return this.usuario;
    }

}
