package com.mtg.magic.fixtures;

import com.mtg.magic.game.adapters.repository.core.builder.UsuarioJPABuilder;
import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.core.domain.builder.CartaBuilder;
import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.IdiomaType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaFixture {

    public static CartaJPA cartaJPAFixture(){
        CartaJPA cartaJPA = new CartaJPA();
        cartaJPA.setQuantidadeDeCartas(2);
        cartaJPA.setEdicao(EdicaoFixture.edicaoJPAFixture());
        cartaJPA.setFoil(true);
        cartaJPA.setUsuario(
                UsuarioJPABuilder.builder()
                    .addLogin("123")
                    .addPassword("123")
                    .build()
        );
        cartaJPA.setId(1L);
        cartaJPA.setNome("carta lendaria");
        cartaJPA.setValor(BigDecimal.valueOf(200));
        return cartaJPA;
    }

    public static Carta cartaFixure(){
        return CartaBuilder.builder()
                .addId(1L)
                .addUsuario("usuario")
                .addQuantidadeDeCartas(2)
                .addUpdateAt(LocalDateTime.now())
                .addCreatedAt(LocalDateTime.now())
                .addValor(BigDecimal.valueOf(300))
                .addEdicao(EdicaoFixture.edicaoFixture())
                .addIdioma(IdiomaType.PORTUGUES)
                .isFoil(true)
                .build();
    }

    public static Carta cartaFixtureAtualizada(CartaDTO cartaDTO){
        return  CartaBuilder.builder()
                .addNome(cartaDTO.getNome())
                .addId(cartaDTO.getId())
                .addUsuario("login")
                .addQuantidadeDeCartas(cartaDTO.getQuantidadeDeCartas())
                .addUpdateAt(LocalDateTime.now())
                .addCreatedAt(LocalDateTime.now())
                .addValor(cartaDTO.getValor())
                .addEdicao(EdicaoFixture.edicaoFixture())
                .addIdioma(IdiomaType.PORTUGUES)
                .isFoil(cartaDTO.getFoil())
                .build();
    }

    public static CartaDTO cartaDTOFixture(){
        CartaDTO cartaDTO = new CartaDTO();
        cartaDTO.setNome("nome");
        cartaDTO.setSiglaEdicao("NEO");
        cartaDTO.setValor(BigDecimal.valueOf(300));
        cartaDTO.setFoil(true);
        cartaDTO.setQuantidadeDeCartas(2);
        return cartaDTO;
    }


}
