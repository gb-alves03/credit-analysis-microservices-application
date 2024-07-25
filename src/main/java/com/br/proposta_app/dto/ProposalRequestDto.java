package com.br.proposta_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalRequestDto {

    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private Double income;
    private Double requestedValue;
    private int paymentTerm;
}
