package com.mtg.magic.game.adapters.repository;

import com.mtg.magic.game.adapters.repository.jpa.UsuarioJpaRepository;
import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.core.domain.model.Usuario;
import com.mtg.magic.game.core.port.output.usuario.CadastrarUsuarioOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA.gerarUsuario;
import static com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA.gerarUsuarioJPA;

@Repository
public class UsuarioRepository implements CadastrarUsuarioOutPutPort {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    public Optional<UsuarioJPA> findByLogin(String login) {
        return usuarioJpaRepository.findByLogin(login);
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        UsuarioJPA usuarioJPA = gerarUsuarioJPA(usuario);
        UsuarioJPA usuarioCadastrado = usuarioJpaRepository.save(usuarioJPA);
        return gerarUsuario(usuarioCadastrado);
    }

    public UsuarioJPA getUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return usuarioJpaRepository.findByLogin(authentication.getName()).orElseThrow();
    }
}
