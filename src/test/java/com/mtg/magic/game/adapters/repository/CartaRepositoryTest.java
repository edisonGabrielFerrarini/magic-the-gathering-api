package com.mtg.magic.game.adapters.repository;

import com.mtg.magic.fixtures.CartaFixture;
import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.adapters.repository.core.service.PaginatorService;
import com.mtg.magic.game.adapters.repository.core.validator.carta.CartaValidator;
import com.mtg.magic.game.adapters.repository.jpa.CartaJpaRepository;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.infra.security.user.validator.usuario.ValidacaoUsuario;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Optional;

class CartaRepositoryTest {

    @Mock
    private CartaJpaRepository cartaJpaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ValidacaoUsuario validarUsuario;

    @Mock
    private CartaValidator cartaValidator;

    @Mock
    private PaginatorService paginatorService;

    @InjectMocks
    private CartaRepository cartaRepository;

    private static final Long ID = 1L;
    private static final Integer NUMERO_DE_CARTAS = 2;
    private static final BigDecimal VALOR = BigDecimal.valueOf(200);

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @SneakyThrows
    @Test
    void testeDeveRecuperarUmaCartaPorId(){
        Mockito.when(cartaJpaRepository.findById(Mockito.any())).thenReturn(Optional.of(CartaFixture.cartaJPAFixture()));

        Carta carta = cartaRepository.getById(ID);

        Assertions.assertEquals(VALOR, carta.getValor());
        Assertions.assertEquals(NUMERO_DE_CARTAS, carta.getQuantidadeDeCartas());
    }

}