package com.mtg.magic.game.core.usecase.carta;

import com.mtg.magic.fixtures.CartaFixture;
import com.mtg.magic.fixtures.EdicaoFixture;
import com.mtg.magic.game.core.domain.dao.carta.CartaDAO;
import com.mtg.magic.game.core.domain.dao.edicao.EdicaoDAO;
import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

class CartaUseCaseTest {

    private final BigDecimal VALOR = BigDecimal.valueOf(300);
    private final Integer QTDE_DE_CARTAS = 2;
    private final Integer SIZE = 1;
    private final String NOME_CARTA_ATUALIZADA = "cartaAtualizada";
    private final Long ID = 1L;

    @Mock
    private EdicaoDAO edicaoDAO;

    @Mock
    private CartaDAO cartaDAO;

    @InjectMocks
    private CartaUseCase cartaUseCase;

    @SneakyThrows
    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @SneakyThrows
    @Test
    void testeDeveRealizarOCadastroDeUmaCarta() {
        Mockito.when(cartaDAO.save(Mockito.any())).thenReturn(CartaFixture.cartaFixure());
        Mockito.when(edicaoDAO.getById(Mockito.any())).thenReturn(EdicaoFixture.edicaoFixture());

        CartaDTO cartaDTO = cartaUseCase.cadastrar(CartaFixture.cartaDTOFixture());

        Assertions.assertEquals(QTDE_DE_CARTAS, cartaDTO.getQuantidadeDeCartas());
        Assertions.assertEquals(VALOR, cartaDTO.getValor());
    }

    @SneakyThrows
    @Test
    void testeDeveraRetornarUmaExceptionDeEdicaoNaoEncontrada() {
        Mockito.when(edicaoDAO.getBySiglaEdicao(Mockito.any())).thenThrow(EdicaoNaoEncontradaException.class);
        Assertions.assertThrows(EdicaoNaoEncontradaException.class, () -> cartaUseCase.cadastrar(CartaFixture.cartaDTOFixture()));
    }

    @SneakyThrows
    @Test
    void testeDeveraConsultarUmCartaPorId() {
        Mockito.when(cartaDAO.getById(Mockito.any())).thenReturn(CartaFixture.cartaFixure());

        CartaDTO cartaDTO = cartaUseCase.consultarById(ID);

        Assertions.assertEquals(QTDE_DE_CARTAS, cartaDTO.getQuantidadeDeCartas());
        Assertions.assertEquals(VALOR, cartaDTO.getValor());
    }

    @Test
    void testeDeveraRecuperarTodasAsCartas() {
        Mockito.when(cartaDAO.getAll(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(List.of(CartaFixture.cartaFixure()));

        List<CartaDTO> cartaDTOList = cartaUseCase.getAll(1, 2, "sort", OrdemType.DESC);

        Assertions.assertEquals(SIZE, cartaDTOList.size());
    }

    @Test
    void testeDeveraRecuperarAsCartasUmUsuario(){
        Mockito.when(cartaDAO.getMinhasCartas(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(List.of(CartaFixture.cartaFixure()));

        List<CartaDTO> cartaDTOList = cartaUseCase.getMinhasCartas(1, 2, "sort", OrdemType.DESC);

        Assertions.assertEquals(SIZE, cartaDTOList.size());
    }

    @SneakyThrows
    @Test
    void testeDeveraAtualizarUmaCarta(){
        CartaDTO cartaDTOAtualizada = CartaFixture.cartaDTOFixture();
        cartaDTOAtualizada.setNome(NOME_CARTA_ATUALIZADA);

        Mockito.when(cartaDAO.save(Mockito.any())).thenReturn(CartaFixture.cartaFixtureAtualizada(cartaDTOAtualizada));
        Mockito.when(cartaDAO.getById(Mockito.any())).thenReturn(CartaFixture.cartaFixure());

        CartaDTO cartaDTO = cartaUseCase.atualizarCarta(ID, cartaDTOAtualizada);

        Assertions.assertEquals(NOME_CARTA_ATUALIZADA, cartaDTO.getNome());
    }
}
