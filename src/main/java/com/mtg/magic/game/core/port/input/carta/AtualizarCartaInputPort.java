package com.mtg.magic.game.core.port.input.carta;

import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;

public interface AtualizarCartaInputPort {

    CartaDTO atualizarCarta(Long id, CartaDTO cartaDTO) throws CartaNaoEncontradaException, UsuarioInvalidoException;

}
