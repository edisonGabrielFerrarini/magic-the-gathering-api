package com.mtg.magic.game.core.port.output.usuario;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.model.Usuario;

public interface CadastrarUsuarioOutPutPort {

    Usuario cadastrar(Usuario usuario);

}
