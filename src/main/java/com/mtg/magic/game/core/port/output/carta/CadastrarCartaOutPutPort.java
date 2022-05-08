package com.mtg.magic.game.core.port.output.carta;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;

public interface CadastrarCartaOutPutPort {

    Carta save(Carta carta) throws UsuarioInvalidoException;

    Carta update(Carta carta) throws UsuarioInvalidoException;

}
