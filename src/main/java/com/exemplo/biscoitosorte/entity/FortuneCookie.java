package com.exemplo.biscoitosorte.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class FortuneCookie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_frase", referencedColumnName = "id")
    @JsonIgnore  // Ignora a serialização da frase diretamente, evitando a circularidade
    private FortunePhrase frase;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
