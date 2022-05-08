package com.mtg.magic.game.api;


import com.mtg.magic.game.core.domain.dto.CartaDTO;
import com.mtg.magic.game.core.domain.type.OrdemType;
import com.mtg.magic.game.core.port.input.carta.AtualizarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.CadastrarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.ConsultarCartaInputPort;
import com.mtg.magic.game.core.port.input.carta.RemoverCartaInputPort;
import com.mtg.magic.game.core.usecase.carta.exception.CartaNaoEncontradaException;
import com.mtg.magic.game.core.usecase.edicao.exception.EdicaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.mtg.magic.game.common.messages.MessageCarta.*;
import static com.mtg.magic.game.common.parameters.PageneableParameters.*;

@RestController
@RequestMapping(value = "/carta", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartaAPI {

    @Autowired
    private ConsultarCartaInputPort consultarCartaInputPort;

    @Autowired
    private CadastrarCartaInputPort cadastrarCartaInputPort;

    @Autowired
    private AtualizarCartaInputPort atualizarCartaInputPort;

    @Autowired
    private RemoverCartaInputPort removerCartaInputPort;

    @GetMapping
    public ResponseEntity<Object> getAll(
            @RequestParam(defaultValue = NUMERO_DA_PAGINA_DEFAULT) Integer pageNo,
            @RequestParam(defaultValue = TAMANHO_DA_PAGINA_DEFAULT) Integer pageSize,
            @RequestParam(defaultValue = PARAMETRO_DE_ORDENACAO_DEFAULT) String sortBy,
            @RequestParam(defaultValue = TIPO_DE_ORGANIZACAO_DEFAULT) OrdemType ordenacao
    ){
        try {
            List<CartaDTO> cartaDTOList = consultarCartaInputPort.getAll(pageNo, pageSize, sortBy, ordenacao);
            return ResponseEntity.accepted().body(cartaDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("minhas-cartas")
    public ResponseEntity<Object> getMinhasCartas(
            @RequestParam(defaultValue = NUMERO_DA_PAGINA_DEFAULT) Integer pageNo,
            @RequestParam(defaultValue = TAMANHO_DA_PAGINA_DEFAULT) Integer pageSize,
            @RequestParam(defaultValue = PARAMETRO_DE_ORDENACAO_DEFAULT) String sortBy,
            @RequestParam(defaultValue = TIPO_DE_ORGANIZACAO_DEFAULT) OrdemType ordenacao
    ){
        try {
            List<CartaDTO> cartaDTOList = consultarCartaInputPort.getAll(pageNo, pageSize, sortBy, ordenacao);
            return ResponseEntity.accepted().body(cartaDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("id/{id}")
    public ResponseEntity<Object> getByID(@PathVariable("id") Long id) {
        try {
            CartaDTO cartaDTO = consultarCartaInputPort.consultarById(id);
            return ResponseEntity.accepted().body(cartaDTO);
        } catch (CartaNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Object> atualizar(
            @PathVariable("id") Long id,
            @RequestBody @Valid CartaDTO cartaDTO
    ) {
        try {
            CartaDTO cartaDTOAtualizado = atualizarCartaInputPort.atualizarCarta(id, cartaDTO);
            return ResponseEntity.accepted().body(cartaDTOAtualizado);
        } catch (CartaNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(String.format(ERRO_ATUALIZAR_CARTA, id));
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> remover(@PathVariable("id") Long id) {
        try {
            removerCartaInputPort.remover(id);
            return ResponseEntity.accepted().body(String.format(SUCESSO_REMOVER_CARTA, id));
        } catch (CartaNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(String.format(ERRO_REMOVER_CARTA, id));
        }
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid CartaDTO cartaDTO) {
        try {
            CartaDTO cartaDTOResponse = cadastrarCartaInputPort.cadastrar(cartaDTO);
            return ResponseEntity.accepted().body(cartaDTOResponse);
        } catch (EdicaoNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
