package com.mtg.magic.game.adapters.repository.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mtg.magic.game.adapters.repository.core.builder.UsuarioJPABuilder;
import com.mtg.magic.game.core.domain.model.Usuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(unique = true)
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public static UsuarioJPA gerarUsuarioJPA(Usuario usuario) {
        return UsuarioJPABuilder.builder().addLogin(usuario.getLogin()).addPassword(usuario.getPassword()).build();
    }

    public static Usuario gerarUsuario(UsuarioJPA usuarioJPA) {
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioJPA.getLogin());
        usuario.setPassword(usuario.getPassword());
        return usuario;
    }
}
