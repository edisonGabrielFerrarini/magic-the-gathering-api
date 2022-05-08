package com.mtg.magic.fixtures;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.domain.model.Edicao;

import java.time.LocalDateTime;

public class EdicaoFixture {

    public static EdicaoJPA edicaoJPAFixture(){
        EdicaoJPA edicaoJPA = new EdicaoJPA();
        edicaoJPA.setSiglaEdicao("acd");
        edicaoJPA.setAno(2022);
        edicaoJPA.setNome("edicao 2");
        edicaoJPA.setId(1L);
        return edicaoJPA;
    }

    public static EdicaoDTO edicaoDTOFixture(){
        EdicaoDTO edicaoDTO = new EdicaoDTO();
        edicaoDTO.setSiglaEdicao("ecd");
        edicaoDTO.setNome("nome");
        edicaoDTO.setAno(2022);
        return edicaoDTO;
    }

    public static Edicao edicaoFixture(){
        Edicao edicao = new Edicao();
        edicao.setSiglaEdicao("ecd");
        edicao.setNome("nome");
        edicao.setAno(2022);
        edicao.setId(1L);
        edicao.setUpdateAt(LocalDateTime.now());
        edicao.setCreatedAt(LocalDateTime.now());
        return edicao;
    }

}
