package com.mtg.magic.game.api;

import com.mtg.magic.game.core.domain.dto.EdicaoDTO;
import com.mtg.magic.game.core.port.input.edicao.CadastrarEdicaoInputPort;
import com.mtg.magic.game.core.port.input.edicao.ConsultaEdicaoInputPort;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.mtg.magic.game.common.messages.MessageEdicao.ERRO_AO_RECUPERAR_EDICAO;
import static com.mtg.magic.game.common.messages.MessageEdicao.ERRO_AO_SALVAR_EDICAO;

@RestController
@RequestMapping(value = "/edicao", produces = MediaType.APPLICATION_JSON_VALUE)
public class EdicaoAPI {

    @Autowired
    private ConsultaEdicaoInputPort consultaEdicaoInputPort;

    @Autowired
    private CadastrarEdicaoInputPort cadastrarEdicaoInputPort;

    @GetMapping("id/{id}")
    public ResponseEntity<Object> getByID(@PathVariable("id") Long id) throws EdicaoNaoEncontradaException {
        try {
            EdicaoDTO edicaoDTO = consultaEdicaoInputPort.consultarById(id);
            return ResponseEntity.accepted().body(edicaoDTO);
        }catch (EdicaoNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ERRO_AO_RECUPERAR_EDICAO);
        }
    }

    @GetMapping("sigla/{sigla}")
    public ResponseEntity<Object> getByNumeroEdicao(@PathVariable("sigla") String sigla) {
        try {
            EdicaoDTO edicaoDTO = consultaEdicaoInputPort.consultarBySiglaEdicao(sigla);
            return ResponseEntity.accepted().body(edicaoDTO);
        }catch (EdicaoNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ERRO_AO_RECUPERAR_EDICAO);
        }
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid EdicaoDTO edicaoDTO){
        try {
            EdicaoDTO edicaoDTOResponse = cadastrarEdicaoInputPort.cadastrar(edicaoDTO);
            return ResponseEntity.accepted().body(edicaoDTOResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ERRO_AO_SALVAR_EDICAO);
        }
    }


}
