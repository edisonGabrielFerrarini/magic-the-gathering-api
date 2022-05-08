package com.mtg.magic.game.adapters.repository.core.validator.edicao;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;

public interface EdicaoValidator {

    void validar(EdicaoJPA edicaoJPA, String option) throws EdicaoNaoEncontradaException;

}
