package com.mtg.magic.game.core.port.input.edicao;

import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;

public interface ConsultaEdicaoInputPort {

    EdicaoDTO consultarById(Long id) throws EdicaoNaoEncontradaException;

    EdicaoDTO consultarBySiglaEdicao(String siglaEdicao) throws EdicaoNaoEncontradaException;

}
