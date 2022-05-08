package com.mtg.magic.game.core.domain.dto;


import com.mtg.magic.game.core.domain.model.Edicao;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class EdicaoDTO {

    @NotNull
    String nome;

    @NotNull
    Integer ano;

    @NotNull
    String siglaEdicao;

    public static EdicaoDTO gerarEdicaoDTO(Edicao edicaoNova) {
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setSiglaEdicao(edicaoNova.getSiglaEdicao());
        edicaoDTO.setAno(edicaoNova.getAno());
        edicaoDTO.setNome(edicaoNova.getNome());
        return edicaoDTO;
    }
}
