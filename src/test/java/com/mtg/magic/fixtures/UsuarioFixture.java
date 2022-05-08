package com.mtg.magic.fixtures;

import com.mtg.magic.game.core.domain.builder.UsuarioBuilder;
import com.mtg.magic.game.core.domain.dto.UsuarioDTO;
import com.mtg.magic.game.core.domain.model.Usuario;

public class UsuarioFixture {

    public static UsuarioDTO usuarioDTOFixture(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setLogin("login");
        usuarioDTO.setPassword("password");
        return usuarioDTO;
    }

    public static Usuario usuarioFixture(){
        return UsuarioBuilder.builder().addLogin("login").addPassword("password").build();
    }

}
