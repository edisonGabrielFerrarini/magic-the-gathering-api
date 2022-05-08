package com.mtg.magic.game.core.domain.model;

import com.mtg.magic.game.core.domain.builder.CartaBuilder;
import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.type.IdiomaType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Carta {

    private Long id;
    private String nome;
    private Edicao edicao;
    private IdiomaType idioma;
    private Boolean foil;
    private String usuario;
    private BigDecimal valor;
    private Integer quantidadeDeCartas;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Carta gerarCarta(Long idCarta, CartaDTO cartaDTO, Edicao edicao, String usuario) {
        return CartaBuilder.builder()
                .addNome(cartaDTO.getNome())
                .addId(idCarta)
                .addUsuario(usuario)
                .addIdioma(cartaDTO.getIdioma())
                .addEdicao(edicao)
                .addValor(cartaDTO.getValor())
                .addCreatedAt(LocalDateTime.now())
                .addUpdateAt(LocalDateTime.now())
                .addQuantidadeDeCartas(cartaDTO.getQuantidadeDeCartas())
                .isFoil(cartaDTO.getFoil())
                .build();
    }

    public static Carta gerarCarta(CartaDTO cartaDTO, Edicao edicao){
        return CartaBuilder.builder()
                .addNome(cartaDTO.getNome())
                .addIdioma(cartaDTO.getIdioma())
                .addEdicao(edicao)
                .addValor(cartaDTO.getValor())
                .addCreatedAt(LocalDateTime.now())
                .addUpdateAt(LocalDateTime.now())
                .addQuantidadeDeCartas(cartaDTO.getQuantidadeDeCartas())
                .isFoil(cartaDTO.getFoil())
                .build();
    }
}
