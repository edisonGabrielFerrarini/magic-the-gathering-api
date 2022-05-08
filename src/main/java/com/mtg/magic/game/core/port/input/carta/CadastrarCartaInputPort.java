package com.mtg.magic.game.core.port.input.carta;

import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.model.Carta;

public interface CadastrarCartaInputPort {

    CartaDTO cadastrar(CartaDTO cartaDTO) throws Exception;

}
