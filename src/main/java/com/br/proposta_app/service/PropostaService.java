package com.br.proposta_app.service;

import com.br.proposta_app.dto.PropostaRequestDto;
import com.br.proposta_app.dto.PropostaResponseDto;
import com.br.proposta_app.entity.Proposta;
import com.br.proposta_app.mapper.PropostaMapper;
import com.br.proposta_app.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    PropostaRepository propostaRepository;

    public PropostaResponseDto createProposal(PropostaRequestDto requestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToEntity(requestDto);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDto> getProposal() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
