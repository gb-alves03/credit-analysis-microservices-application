package com.br.proposta_app.controller;

import com.br.proposta_app.dto.PropostaRequestDto;
import com.br.proposta_app.dto.PropostaResponseDto;
import com.br.proposta_app.service.PropostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> createProposal(@RequestBody @Valid PropostaRequestDto requestDto) {
        PropostaResponseDto response = propostaService.criarProposta(requestDto);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }


    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> getProposal() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
