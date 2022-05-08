package com.mtg.magic.game.adapters.repository.jpa;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EdicaoJpaRepository extends JpaRepository<EdicaoJPA, Long> {

    @Query(
            "SELECT e FROM EdicaoJPA e " +
                    "WHERE e.siglaEdicao = :siglaEdicao")
    EdicaoJPA findBySiglaEdicao(String siglaEdicao);

}
