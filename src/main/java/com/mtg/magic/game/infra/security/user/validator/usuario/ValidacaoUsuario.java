package com.mtg.magic.game.infra.security.user.validator.usuario;

import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;

public interface ValidacaoUsuario {

    UsuarioJPA validar(String login) throws UsuarioInvalidoException;

}
