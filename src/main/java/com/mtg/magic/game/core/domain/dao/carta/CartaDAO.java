package com.mtg.magic.game.core.domain.dao.carta;

import com.mtg.magic.game.core.domain.model.Carta;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.port.output.carta.CadastrarCartaOutPutPort;
import com.mtg.magic.game.core.port.output.carta.ConsultarCartaOutPutPort;
import com.mtg.magic.game.core.port.output.carta.RemoverCartaOutPutPort;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.usuario.exception.UsuarioInvalidoException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaDAO {

    @Autowired
    private ConsultarCartaOutPutPort consultarCartaOutPutPort;

    @Autowired
    private CadastrarCartaOutPutPort cadastrarCartaOutPutPort;

    @Autowired
    private RemoverCartaOutPutPort removerCartaOutPutPort;

    public Carta getById(Long id) throws CartaNaoEncontradaException {
        return consultarCartaOutPutPort.getById(id);
    }

    public List<Carta> getAll(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType){
        return consultarCartaOutPutPort.getAll(pageNo, pageSize, sortBy, ordemType);
    }

    public List<Carta> getMinhasCartas(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType){
        return consultarCartaOutPutPort.getAll(pageNo, pageSize, sortBy, ordemType);
    }

    public Carta save(Carta carta) throws UsuarioInvalidoException {
        return cadastrarCartaOutPutPort.save(carta);
    }

    @SneakyThrows
    public void remover(Long id) {
        removerCartaOutPutPort.remover(id);
    }


}
