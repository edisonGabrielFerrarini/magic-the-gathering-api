package com.mtg.magic.game.core.port.input.usuario;

import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.dto.UsuarioDTO;

public interface CadastroUsuarioInputPort {

    UsuarioDTO cadastrar(UsuarioDTO usuarioDTO);

}
