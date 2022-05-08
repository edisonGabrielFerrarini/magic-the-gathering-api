package com.mtg.magic.game.core.port.input.carta;

import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;

import java.util.List;

public interface ConsultarCartaInputPort {

    CartaDTO consultarById(Long id) throws CartaNaoEncontradaException;

    List<CartaDTO> getAll(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType);

    List<CartaDTO> getMinhasCartas(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType);

}
