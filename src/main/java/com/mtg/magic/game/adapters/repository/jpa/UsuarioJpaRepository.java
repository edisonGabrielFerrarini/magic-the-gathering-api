package com.mtg.magic.game.adapters.repository.jpa;

import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJPA, Long> {

    Optional<UsuarioJPA> findByLogin(String login);

}
