package com.mtg.magic.game.api;

import com.mtg.magic.game.core.domain.dto.UsuarioDTO;
import com.mtg.magic.game.core.port.input.usuario.CadastroUsuarioInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioAPI {

    @Autowired
    private CadastroUsuarioInputPort cadastroUsuarioInputPort;
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid UsuarioDTO usuarioDTO){
        try {
            cadastroUsuarioInputPort.cadastrar(usuarioDTO);
            return ResponseEntity.accepted().body("usuario criado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("erro ao gerar um novo usuario!");
        }
    }

}
