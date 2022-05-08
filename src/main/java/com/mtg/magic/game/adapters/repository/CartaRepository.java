package com.mtg.magic.game.adapters.repository;

import com.mtg.magic.game.adapters.repository.core.model.CartaJPA;
import com.mtg.magic.game.adapters.repository.core.model.UsuarioJPA;
import com.mtg.magic.game.adapters.repository.core.service.PaginatorService;
import com.mtg.magic.game.adapters.repository.core.validator.carta.CartaValidator;
import com.mtg.magic.game.adapters.repository.jpa.CartaJpaRepository;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.port.output.carta.CadastrarCartaOutPutPort;
import com.mtg.magic.game.core.port.output.carta.ConsultarCartaOutPutPort;
import com.mtg.magic.game.core.port.output.carta.RemoverCartaOutPutPort;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;
import com.mtg.magic.game.infra.security.user.validator.usuario.ValidacaoUsuario;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mtg.magic.game.adapters.repository.core.model.CartaJPA.gerarCarta;
import static com.mtg.magic.game.adapters.repository.core.model.CartaJPA.gerarCartaJPA;

@Repository
public class CartaRepository implements ConsultarCartaOutPutPort, CadastrarCartaOutPutPort, RemoverCartaOutPutPort {

    @Autowired
    private CartaJpaRepository cartaJpaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidacaoUsuario validarUsuario;

    @Autowired
    private CartaValidator cartaValidator;

    @Autowired
    private PaginatorService paginatorService;

    @Override
    public Carta getById(Long id) throws CartaNaoEncontradaException {
        Optional<CartaJPA> cartaJPAOptional = cartaJpaRepository.findById(id);
        cartaValidator.validar(cartaJPAOptional, id);
        return gerarCarta(cartaJPAOptional.get());
    }

    @Override
    public List<Carta> getAll(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType) {
        Pageable pageable = paginatorService.gerarPaginacao(pageNo, pageSize, sortBy, ordemType);
        Page<CartaJPA> cartaJPAS = cartaJpaRepository.findAll(pageable);
        return cartaJPAS.get()
                .map(CartaJPA::gerarCarta)
                .collect(Collectors.toList());
    }

    @Override
    public List<Carta> getMinhasCartas(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType) {
        Pageable pageable = paginatorService.gerarPaginacao(pageNo, pageSize, sortBy, ordemType);
        UsuarioJPA usuarioJPA = usuarioRepository.getUsuarioLogado();
        Page<CartaJPA> cartaJPAS = cartaJpaRepository.getByUsuario(usuarioJPA.getId(), pageable);
        return cartaJPAS.get()
                .map(CartaJPA::gerarCarta)
                .collect(Collectors.toList());
    }

    @Override
    public Carta update(Carta carta) throws UsuarioInvalidoException {
        UsuarioJPA usuarioJPAValido = validarUsuario.validar(carta.getUsuario());
        CartaJPA cartaJPA = gerarCartaJPA(carta, usuarioJPAValido, carta.getId());
        CartaJPA cartaJPANova = cartaJpaRepository.save(cartaJPA);
        return gerarCarta(cartaJPANova);
    }

    @Override
    public Carta save(Carta carta) throws UsuarioInvalidoException {
        UsuarioJPA usuarioJPA = usuarioRepository.getUsuarioLogado();
        CartaJPA cartaJPA = gerarCartaJPA(carta, usuarioJPA);
        CartaJPA cartaJPANova = cartaJpaRepository.save(cartaJPA);
        return gerarCarta(cartaJPANova);
    }

    @SneakyThrows
    @Override
    public void remover(Long id) {
        Optional<CartaJPA> cartaJPAOptional = cartaJpaRepository.findById(id);
        cartaValidator.validar(cartaJPAOptional, id);
        validarUsuario.validar(cartaJPAOptional.get().getUsuario().getLogin());
        cartaJpaRepository.delete(cartaJPAOptional.get());
    }
}
