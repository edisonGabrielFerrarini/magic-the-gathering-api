package com.mtg.magic.game.adapters.repository.core.validator.edicao.impl;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import com.mtg.magic.game.adapters.repository.core.validator.edicao.EdicaoValidator;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.stereotype.Service;

import static com.mtg.magic.game.common.messages.MessageEdicao.MESSAGE_EDICAO_NAO_ENCONTRADA;

@Service
public class EdicaoValidatorImpl implements EdicaoValidator {
    @Override
    public void validar(EdicaoJPA edicaoJPA, String option) throws EdicaoNaoEncontradaException {
        if (edicaoJPA == null) {
            throw new EdicaoNaoEncontradaException(String.format(MESSAGE_EDICAO_NAO_ENCONTRADA, option));
        }
    }
}
