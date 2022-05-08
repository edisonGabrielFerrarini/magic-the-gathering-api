package com.mtg.magic.game.core.port.output.carta;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;

import java.util.List;

public interface ConsultarCartaOutPutPort {

    Carta getById(Long id) throws CartaNaoEncontradaException;

    List<Carta> getAll(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType);

    List<Carta> getMinhasCartas(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType);

}
