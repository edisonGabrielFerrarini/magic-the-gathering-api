package com.mtg.magic.game.core.usecase.edicao;

import com.mtg.magic.fixtures.EdicaoFixture;
import com.mtg.magic.game.core.domain.dao.edicao.EdicaoDAO;
import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class EdicaoUseCaseTest {

    private final Long ID = 1L;
    private final String NOME_EDICAO = "nome";
    private final Integer ANO = 2022;
    private final String SIGLA_EDICAO = "ecd";

    @Mock
    private EdicaoDAO edicaoDAO;

    @InjectMocks
    private EdicaoUseCase edicaoUseCase;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testeDeveraCadastrarUmaNovaEdicao(){
        EdicaoDTO edicaoDTO = EdicaoFixture.edicaoDTOFixture();

        when(edicaoDAO.cadastrar(any())).thenReturn(EdicaoFixture.edicaoFixture());

        EdicaoDTO edicaoDTONova = edicaoUseCase.cadastrar(edicaoDTO);

        assertEquals(edicaoDTO.getSiglaEdicao(), edicaoDTONova.getSiglaEdicao());
        assertEquals(edicaoDTO.getNome(), edicaoDTONova.getNome());
    }

    @Test
    void testeDeveraConsultarPorId() throws EdicaoNaoEncontradaException {
        when(edicaoDAO.getById(any())).thenReturn(EdicaoFixture.edicaoFixture());

        EdicaoDTO edicaoDTO = edicaoUseCase.consultarById(ID);

        assertEquals(NOME_EDICAO, edicaoDTO.getNome());
        assertEquals(ANO, edicaoDTO.getAno());
        assertEquals(SIGLA_EDICAO, edicaoDTO.getSiglaEdicao());
    }

    @SneakyThrows
    @Test
    void testeDeveraRetornarUmaExceptionCasoOIdEdicaoNaoSejaEncontrado(){
        when(edicaoDAO.getById(any())).thenThrow(EdicaoNaoEncontradaException.class);

        assertThrows(EdicaoNaoEncontradaException.class, () -> edicaoUseCase.consultarById(ID));
    }

    @SneakyThrows
    @Test
    void testeDeveraConsultarPorSigla(){
        when(edicaoDAO.getBySiglaEdicao(Mockito.any())).thenReturn(EdicaoFixture.edicaoFixture());

        EdicaoDTO edicaoDTO = edicaoUseCase.consultarBySiglaEdicao(SIGLA_EDICAO);

        assertEquals(NOME_EDICAO, edicaoDTO.getNome());
        assertEquals(ANO, edicaoDTO.getAno());
        assertEquals(SIGLA_EDICAO, edicaoDTO.getSiglaEdicao());
    }

    @SneakyThrows
    @Test
    void testeDeveraRetornarUmaExceptionCasoASiglaEdicaoNaoSejaEncontrado(){
        when(edicaoDAO.getBySiglaEdicao(any())).thenThrow(EdicaoNaoEncontradaException.class);

        assertThrows(EdicaoNaoEncontradaException.class, () -> edicaoUseCase.consultarBySiglaEdicao(SIGLA_EDICAO));
    }

}