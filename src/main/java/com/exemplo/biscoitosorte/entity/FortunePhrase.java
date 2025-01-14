package com.exemplo.biscoitosorte.entity;

import jakarta.persistence.*;

@Entity
public class FortunePhrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Geração automática sequencial (para banco com auto incremento)
    private Long id;  // Alterado para Long

    @Column(nullable = false, unique = true)
    private String conteudo;

    private String autor;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
