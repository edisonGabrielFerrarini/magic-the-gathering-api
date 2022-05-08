package com.mtg.magic.game.adapters.repository.core.validator.edicao.impl;

import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EdicaoValidatorImplTest {

    private EdicaoValidatorImpl edicaoValidator;

    @BeforeEach
    void init(){
        edicaoValidator = new EdicaoValidatorImpl();
    }

    @Test
    void testeDevaraRetoranarUmErroCasoEdicaoOptionalSejaVazia(){
        Assertions.assertThrows(EdicaoNaoEncontradaException.class, () -> {
            edicaoValidator.validar(null, "ID");
        });
    }

}