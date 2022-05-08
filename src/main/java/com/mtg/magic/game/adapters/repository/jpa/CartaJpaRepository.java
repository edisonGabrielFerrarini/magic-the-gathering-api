package com.mtg.magic.game.adapters.repository.jpa;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaJpaRepository extends JpaRepository<CartaJPA, Long> {

    Page<CartaJPA> getByUsuario(Long usuario, Pageable pageable);

}
