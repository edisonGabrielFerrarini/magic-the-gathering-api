package com.mtg.magic.game.adapters.repository.core.validator.carta.impl;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.adapters.repository.core.validator.carta.CartaValidator;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.mtg.magic.game.common.messages.MessageCarta.MESSAGE_CARTA_NAO_ENCONTRADA;

@Service
public class CartaInexistenteValidator implements CartaValidator {
    @Override
    public void validar(Optional<CartaJPA> cartaJPAOptional, Long id) throws CartaNaoEncontradaException {
        if (cartaJPAOptional.isEmpty()) {
            throw new CartaNaoEncontradaException(String.format(MESSAGE_CARTA_NAO_ENCONTRADA, id));
        }
    }
}
