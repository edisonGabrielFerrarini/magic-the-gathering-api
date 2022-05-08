package com.mtg.magic.game.adapters.repository.core.model;

import com.mtg.magic.game.adapters.repository.core.builder.EdicaoJPABuilder;
import com.mtg.magic.game.core.domain.builder.EdicaoBuilder;
import com.mtg.magic.game.core.domain.model.Edicao;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "edicao")
public class EdicaoJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @Column(unique = true)
    private String nome;
    private Integer ano;
    @Column(unique = true)
    private String siglaEdicao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static EdicaoJPA gerarEdicaoJPA(Edicao edicao) {
        return EdicaoJPABuilder.builder().addAno(edicao.getAno()).addSiglaEdicao(edicao.getSiglaEdicao()).addId(edicao.getId()).addNome(edicao.getNome()).addCreatedAt(edicao.getCreatedAt()).addUpdateAt(edicao.getUpdateAt()).build();
    }

    public static Edicao gerarEdicao(EdicaoJPA edicaoJPA) {
        return EdicaoBuilder.builder().addEdicao(edicaoJPA.getSiglaEdicao()).addAno(edicaoJPA.getAno()).addNome(edicaoJPA.getNome()).addUpdateAt(edicaoJPA.getUpdatedAt()).addCreatedAt(edicaoJPA.getCreatedAt()).addId(edicaoJPA.getId()).build();
    }
}
