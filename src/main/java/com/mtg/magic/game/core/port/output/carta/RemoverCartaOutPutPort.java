package com.mtg.magic.game.core.port.output.carta;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;

public interface RemoverCartaOutPutPort {

    void remover(Long id) throws CartaNaoEncontradaException, UsuarioInvalidoException;

}
