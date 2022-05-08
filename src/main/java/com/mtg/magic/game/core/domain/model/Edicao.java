package com.mtg.magic.game.core.domain.model;

import com.mtg.magic.game.core.domain.builder.EdicaoBuilder;
import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Edicao {

    Long id;
    String nome;
    Integer ano;
    String siglaEdicao;
    LocalDateTime createdAt;
    LocalDateTime updateAt;

    public static Edicao gerarEdicao(EdicaoDTO edicaoDTO){
        return EdicaoBuilder
                .builder()
                .addEdicao(edicaoDTO.getSiglaEdicao())
                .addAno(edicaoDTO.getAno())
                .addNome(edicaoDTO.getNome())
                .addCreatedAt(LocalDateTime.now())
                .addUpdateAt(LocalDateTime.now())
                .build();
    }
}
