package com.mtg.magic.game.adapters.repository.core.validator.carta.impl;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class CartaInexistenteValidatorTest {

    private CartaInexistenteValidator cartaInexistenteValidator;

    @BeforeEach
    void init(){
        cartaInexistenteValidator = new CartaInexistenteValidator();
    }

    @Test
    void testeDevaraRetoranarUmErroCasoACartaOptionalSejaVazia(){
        Optional<CartaJPA> cartaJPAOptional = Optional.empty();
        Assertions.assertThrows(CartaNaoEncontradaException.class, () -> {
            cartaInexistenteValidator.validar(cartaJPAOptional, 1L);
        });
    }


}