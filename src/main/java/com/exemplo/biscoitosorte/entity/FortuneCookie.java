package com.exemplo.biscoitosorte.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class FortuneCookie {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_frase", nullable = false)
    private FortunePhrase frase;

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FortunePhrase getFrase() {
        return frase;
    }

    public void setFrase(FortunePhrase frase) {
        this.frase = frase;
    }
}
