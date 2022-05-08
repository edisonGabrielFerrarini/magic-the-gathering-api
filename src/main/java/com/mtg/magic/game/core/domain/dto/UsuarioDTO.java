package com.mtg.magic.game.core.domain.dto;


import com.mtg.magic.game.core.domain.model.Usuario;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class UsuarioDTO {

    @NotNull
    @Email(message = "email invalido")
    private String login;

    @NotNull
    private String password;

    public static UsuarioDTO gerarUsuarioDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setLogin(usuario.getLogin());
        return usuarioDTO;
    }
}
