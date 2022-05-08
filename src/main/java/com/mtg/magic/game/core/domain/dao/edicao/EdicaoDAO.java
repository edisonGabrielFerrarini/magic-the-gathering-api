package com.mtg.magic.game.core.domain.dao.edicao;

import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.port.output.edicao.CadastrarEdicaoOutPutPort;
import com.mtg.magic.game.core.port.output.edicao.ConsultarEdicaoOutPutPort;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdicaoDAO {

    @Autowired
    private ConsultarEdicaoOutPutPort consultarEdicaoOutPutPort;

    @Autowired
    private CadastrarEdicaoOutPutPort cadastrarEdicaoOutPutPort;

    public Edicao getById(Long id) throws EdicaoNaoEncontradaException {
        return consultarEdicaoOutPutPort.getById(id);
    }

    public Edicao getBySiglaEdicao(String siglaEdicao) throws EdicaoNaoEncontradaException {
        return consultarEdicaoOutPutPort.getBySiglaEdicao(siglaEdicao);
    }

    public Edicao cadastrar(Edicao edicao){
        return cadastrarEdicaoOutPutPort.cadastrar(edicao);
    }


}
