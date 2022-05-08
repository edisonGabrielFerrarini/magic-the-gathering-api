package com.mtg.magic.game.adapters.repository.core.model;


import com.mtg.magic.game.adapters.repository.core.builder.CartaJPABuilder;
import com.mtg.magic.game.core.domain.builder.CartaBuilder;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.IdiomaType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA.gerarEdicao;
import static com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA.gerarEdicaoJPA;

@Data
@Entity
@Table(name = "carta")
public class CartaJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioJPA usuario;
    private String nome;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_edicao", referencedColumnName = "id")
    private EdicaoJPA edicao;

    @Enumerated(EnumType.STRING)
    private IdiomaType idioma;

    private Boolean foil;
    private BigDecimal valor;
    private Integer quantidadeDeCartas;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CartaJPA gerarCartaJPA(Carta carta, UsuarioJPA usuarioJPA) {
        return CartaJPABuilder.builder().addEdicao(gerarEdicaoJPA(carta.getEdicao())).addUsuario(usuarioJPA).addNome(carta.getNome()).addCreatedAt(carta.getCreatedAt()).addUpdateAt(carta.getUpdatedAt()).addIdioma(carta.getIdioma()).addQuantidadeDeCartas(carta.getQuantidadeDeCartas()).addValor(carta.getValor()).isFoil(carta.getFoil()).build();
    }

    public static CartaJPA gerarCartaJPA(Carta carta, UsuarioJPA usuarioJPA, Long idCarta) {
        return CartaJPABuilder.builder().addEdicao(gerarEdicaoJPA(carta.getEdicao())).addUsuario(usuarioJPA).addNome(carta.getNome()).addCreatedAt(carta.getCreatedAt()).addId(idCarta).addUpdateAt(carta.getUpdatedAt()).addIdioma(carta.getIdioma()).addQuantidadeDeCartas(carta.getQuantidadeDeCartas()).addValor(carta.getValor()).isFoil(carta.getFoil()).build();
    }

    public static Carta gerarCarta(CartaJPA cartaJPA) {
        return CartaBuilder.builder().addIdioma(cartaJPA.getIdioma()).addId(cartaJPA.getId()).addUsuario(cartaJPA.getUsuario().getLogin()).addEdicao(gerarEdicao(cartaJPA.getEdicao())).addValor(cartaJPA.getValor()).addNome(cartaJPA.getNome()).addQuantidadeDeCartas(cartaJPA.getQuantidadeDeCartas()).addCreatedAt(cartaJPA.getCreatedAt()).addUpdateAt(cartaJPA.getUpdatedAt()).isFoil(cartaJPA.getFoil()).build();
    }
}
