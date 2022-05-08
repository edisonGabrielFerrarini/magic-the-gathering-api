package com.mtg.magic.game.adapters.repository;

import com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA;
import com.mtg.magic.game.adapters.repository.core.validator.edicao.EdicaoValidator;
import com.mtg.magic.game.adapters.repository.jpa.EdicaoJpaRepository;
import com.mtg.magic.game.core.domain.model.Edicao;
import com.mtg.magic.game.core.port.output.edicao.CadastrarEdicaoOutPutPort;
import com.mtg.magic.game.core.port.output.edicao.ConsultarEdicaoOutPutPort;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA.gerarEdicao;
import static com.mtg.magic.game.adapters.repository.core.model.EdicaoJPA.gerarEdicaoJPA;

@Repository
public class EdicaoRepository implements ConsultarEdicaoOutPutPort, CadastrarEdicaoOutPutPort {

    @Autowired
    private EdicaoJpaRepository edicaoJpaRepository;

    @Autowired
    private EdicaoValidator edicaoValidator;

    @Override
    public Edicao getById(Long id) throws EdicaoNaoEncontradaException {
        EdicaoJPA edicaoJPA = edicaoJpaRepository.getById(id);
        edicaoValidator.validar(edicaoJPA, id.toString());
        return gerarEdicao(edicaoJPA);
    }

    @Override
    public Edicao getBySiglaEdicao(String siglaEdicao) throws EdicaoNaoEncontradaException {
        EdicaoJPA edicaoJPA = edicaoJpaRepository.findBySiglaEdicao(siglaEdicao);
        edicaoValidator.validar(edicaoJPA, siglaEdicao);
        return gerarEdicao(edicaoJPA);
    }

    @Override
    public Edicao cadastrar(Edicao edicao) {
        EdicaoJPA edicaoJPA = gerarEdicaoJPA(edicao);
        EdicaoJPA edicaoJPANovo = edicaoJpaRepository.save(edicaoJPA);
        return gerarEdicao(edicaoJPANovo);
    }
}
