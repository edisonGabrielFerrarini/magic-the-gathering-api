package com.mtg.magic.game.infra.security.user.validator.usuario.impl;

import com.mtg.magic.game.adapters.repository.UsuarioRepository;
import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.infra.security.user.validator.usuario.ValidacaoUsuario;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mtg.magic.game.common.messages.MessageUsuario.USUARIO_OPERACAO_NAO_PERMITIDA;

@Service
public class ValidacaoUsuarioInvalido implements ValidacaoUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioJPA validar(String loginAtual) throws UsuarioInvalidoException {
        UsuarioJPA usuarioLogado = usuarioRepository.getUsuarioLogado();
        if(!Objects.equals(usuarioLogado.getLogin(), loginAtual)){
            throw new UsuarioInvalidoException(USUARIO_OPERACAO_NAO_PERMITIDA);
        }
        return usuarioLogado;
    }
}
