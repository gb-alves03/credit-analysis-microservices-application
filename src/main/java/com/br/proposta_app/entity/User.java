package com.br.proposta_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastname;
    private String cpf;
    private String phone;
    private Double income;

    @OneToOne(mappedBy = "user")
    private Proposal proposal;
}
