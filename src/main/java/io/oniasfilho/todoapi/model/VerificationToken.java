package io.oniasfilho.todoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "VerificationToken")
public class VerificationToken {
    @Id
    private String identifier;

    @Column(unique = true)
    private String token;

    private LocalDate expires;
}