package com.mtg.magic.game.core.usecase.usuario;

import com.mtg.magic.game.core.domain.builder.UsuarioBuilder;
import com.mtg.magic.game.core.domain.dao.usuario.UsuarioDAO;
import com.mtg.magic.game.core.domain.dto.UsuarioDTO;
import com.mtg.magic.game.core.domain.model.Usuario;
import com.mtg.magic.game.core.port.input.usuario.CadastroUsuarioInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mtg.magic.game.core.domain.dto.UsuarioDTO.gerarUsuarioDTO;

@Service
public class UsuarioUseCase implements CadastroUsuarioInputPort {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDAO.cadastrar(gerarUsuario(usuarioDTO));
        return gerarUsuarioDTO(usuario);
    }

    public Usuario gerarUsuario(UsuarioDTO usuarioDTO) {
        return UsuarioBuilder
                .builder()
                .addLogin(usuarioDTO.getLogin())
                .addPassword(passwordEncoder.encode(usuarioDTO.getPassword()))
                .build();
    }

}
