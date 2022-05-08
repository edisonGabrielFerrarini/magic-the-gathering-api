package com.mtg.magic.game.core.port.output.edicao;

import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;

public interface ConsultarEdicaoOutPutPort {

    Edicao getById(Long id) throws EdicaoNaoEncontradaException;

    Edicao getBySiglaEdicao(String siglaEdicao) throws EdicaoNaoEncontradaException;

}
