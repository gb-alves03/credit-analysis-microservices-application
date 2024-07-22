package com.br.proposta_app.controller;

import com.br.proposta_app.dto.ProposalRequestDto;
import com.br.proposta_app.dto.ProposalResponseDto;
import com.br.proposta_app.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> createProposal(@RequestBody ProposalRequestDto requestDto, UriComponentsBuilder uriBuilder) {
        ProposalResponseDto response = proposalService.createProposal(requestDto);

        var uri = uriBuilder.path("/proposals/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
