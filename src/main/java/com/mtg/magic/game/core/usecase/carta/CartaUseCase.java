package com.mtg.magic.game.core.usecase.carta;

import com.mtg.magic.game.core.domain.dao.carta.CartaDAO;
import com.mtg.magic.game.core.domain.dao.edicao.EdicaoDAO;
import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.port.input.carta.AtualizarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.CadastrarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.ConsultarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.RemoverCartaInputPort;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mtg.magic.game.core.domain.dto.CartaDTO.gerarCartaDTO;
import static com.mtg.magic.game.core.domain.model.Carta.gerarCarta;

@Service
public class CartaUseCase implements CadastrarCartaInputPort, ConsultarCartaInputPort, AtualizarCartaInputPort, RemoverCartaInputPort {

    @Autowired
    private EdicaoDAO edicaoDAO;

    @Autowired
    private CartaDAO cartaDAO;

    @Override
    public CartaDTO cadastrar(CartaDTO cartaDTO) throws Exception {
        Edicao edicao = edicaoDAO.getBySiglaEdicao(cartaDTO.getSiglaEdicao());
        Carta carta = gerarCarta(cartaDTO, edicao);
        return salvar(carta);
    }

    @Override
    public CartaDTO consultarById(Long id) throws CartaNaoEncontradaException {
        Carta carta = cartaDAO.getById(id);
        return gerarCartaDTO(carta);
    }

    @Override
    public List<CartaDTO> getAll(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType) {
        List<Carta> cartaList = cartaDAO.getAll(pageNo, pageSize, sortBy, ordemType);
        return cartaList.stream()
                .map(CartaDTO::gerarCartaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CartaDTO> getMinhasCartas(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType) {
        List<Carta> cartaList = cartaDAO.getMinhasCartas(pageNo, pageSize, sortBy, ordemType);
        return cartaList.stream()
                .map(CartaDTO::gerarCartaDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public CartaDTO atualizarCarta(Long id, CartaDTO cartaDTO) {
        Carta carta = cartaDAO.getById(id);
        Carta cartaAtualizada = gerarCarta(id, cartaDTO, carta.getEdicao(), carta.getUsuario());
        return salvar(cartaAtualizada);
    }

    @SneakyThrows
    @Override
    public void remover(Long id){
        cartaDAO.remover(id);
    }

    public CartaDTO salvar(Carta carta) throws UsuarioInvalidoException {
        Carta cartaNova = cartaDAO.save(carta);
        return gerarCartaDTO(cartaNova);
    }
}
