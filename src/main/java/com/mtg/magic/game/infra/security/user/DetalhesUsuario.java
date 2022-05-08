package com.mtg.magic.game.infra.security.user;

import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalhesUsuario implements UserDetails {

    private final Optional<UsuarioJPA> usuario;

    public DetalhesUsuario(Optional<UsuarioJPA> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioJPA()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new UsuarioJPA()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
