package com.mtg.magic.game.core.port.input.edicao;

import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.domain.model.Edicao;

public interface CadastrarEdicaoInputPort {

    EdicaoDTO cadastrar(EdicaoDTO edicaoDTO);

}
