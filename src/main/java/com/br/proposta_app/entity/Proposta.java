package com.br.proposta_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Proposta")
@Table(name = "propostas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean inntegrada;
    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
