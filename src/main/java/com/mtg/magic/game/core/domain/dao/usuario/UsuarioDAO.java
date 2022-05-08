package com.mtg.magic.game.core.domain.dao.usuario;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.model.Usuario;
import com.mtg.magic.game.core.port.output.usuario.CadastrarUsuarioOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDAO {

    @Autowired
    private CadastrarUsuarioOutPutPort cadastrarUsuarioOutPutPort;

    public Usuario cadastrar(Usuario usuario){
        return cadastrarUsuarioOutPutPort.cadastrar(usuario);
    }

}
