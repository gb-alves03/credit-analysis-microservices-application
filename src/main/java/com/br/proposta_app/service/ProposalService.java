package com.br.proposta_app.service;

import com.br.proposta_app.dto.ProposalRequestDto;
import com.br.proposta_app.dto.ProposalResponseDto;
import com.br.proposta_app.entity.Proposal;
import com.br.proposta_app.mapper.ProposalMapper;
import com.br.proposta_app.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    @Autowired
    ProposalRepository proposalRepository;

    public ProposalResponseDto createProposal(ProposalRequestDto requestDto) {
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToEntity(requestDto);
        proposalRepository.save(proposal);

        return ProposalMapper.INSTANCE.convertEntityToDto(proposal);
    }
}
