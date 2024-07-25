package com.br.proposta_app.controller;

import com.br.proposta_app.dto.ProposalRequestDto;
import com.br.proposta_app.dto.ProposalResponseDto;
import com.br.proposta_app.service.ProposalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> createProposal(@RequestBody @Valid ProposalRequestDto requestDto) {
        ProposalResponseDto response = proposalService.createProposal(requestDto);

        return ResponseEntity.ok(response);
    }
}
