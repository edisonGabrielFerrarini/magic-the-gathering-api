package com.mtg.magic.game.adapters.repository.core.validator.carta;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CartaValidator {

    void validar(Optional<CartaJPA> cartaJPA, Long id) throws CartaNaoEncontradaException;

}
