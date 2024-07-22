package com.br.proposta_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Proposal")
@Table(name = "proposals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestedValue;
    private int paymentTerm;
    private Boolean approved;
    private boolean integrated;
    private String observation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
