package com.mtg.magic.game.infra.security.service;

import com.mtg.magic.game.adapters.repository.UsuarioRepository;
import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.infra.security.user.DetalhesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioJPA> usuarioJPA = usuarioRepository.findByLogin(username);

        if (usuarioJPA.isEmpty()){
            throw new UsernameNotFoundException(String.format("usuario [%s] nao encontrado", username));
        }

        return new DetalhesUsuario(usuarioJPA);
    }

}
