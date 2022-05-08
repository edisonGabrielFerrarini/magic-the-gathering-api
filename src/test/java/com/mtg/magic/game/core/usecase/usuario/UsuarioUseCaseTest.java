package com.mtg.magic.game.core.usecase.usuario;

import com.mtg.magic.fixtures.UsuarioFixture;
import com.mtg.magic.game.core.domain.dao.usuario.UsuarioDAO;
import com.mtg.magic.game.core.domain.dto.UsuarioDTO;
import com.mtg.magic.game.core.domain.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class UsuarioUseCaseTest {

    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    @Mock
    private UsuarioDAO usuarioDAO;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioUseCase usuarioUseCase;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn(PASSWORD);
        Mockito.when(usuarioDAO.cadastrar(Mockito.any())).thenReturn(UsuarioFixture.usuarioFixture());
    }

    @Test
    void deveReceberUmUsuarioDTOeRetornarUmNovoUsuario(){
        UsuarioDTO usuarioDTO = UsuarioFixture.usuarioDTOFixture();

        Usuario usuario = usuarioUseCase.gerarUsuario(usuarioDTO);

        Assertions.assertEquals(LOGIN, usuario.getLogin());
        Assertions.assertEquals(PASSWORD, usuario.getPassword());
    }

    @Test
    void deveRealizarUmNovoCadastroDeUsuarioERetornarUmUsuarioDTO(){
        UsuarioDTO usuarioDTO = usuarioUseCase.cadastrar(UsuarioFixture.usuarioDTOFixture());

        Assertions.assertEquals(LOGIN, usuarioDTO.getLogin());
        Assertions.assertEquals(PASSWORD, usuarioDTO.getPassword());
    }

}