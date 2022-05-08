package com.mtg.magic.game.core.usecase.edicao;

import com.mtg.magic.game.core.domain.dao.edicao.EdicaoDAO;
import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.port.input.edicao.CadastrarEdicaoInputPort;
import com.mtg.magic.game.core.port.input.edicao.ConsultaEdicaoInputPort;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mtg.magic.game.core.domain.dto.EdicaoDTO.gerarEdicaoDTO;
import static com.mtg.magic.game.core.domain.model.Edicao.gerarEdicao;

@Service
public class EdicaoUseCase implements CadastrarEdicaoInputPort, ConsultaEdicaoInputPort {

    @Autowired
    private EdicaoDAO edicaoDAO;

    @Override
    public EdicaoDTO cadastrar(EdicaoDTO edicaoDTO) {
        Edicao edicao = gerarEdicao(edicaoDTO);
        return salvar(edicao);
    }

    public EdicaoDTO salvar(Edicao edicao){
        Edicao edicaoNova = edicaoDAO.cadastrar(edicao);
        return gerarEdicaoDTO(edicaoNova);
    }

    @Override
    public EdicaoDTO consultarById(Long id) throws EdicaoNaoEncontradaException {
        Edicao edicao = edicaoDAO.getById(id);
        return gerarEdicaoDTO(edicao);
    }

    @Override
    public EdicaoDTO consultarBySiglaEdicao(String siglaEdicao) throws EdicaoNaoEncontradaException {
        Edicao edicao = edicaoDAO.getBySiglaEdicao(siglaEdicao);
        return gerarEdicaoDTO(edicao);
    }
}
