package com.exemplo.biscoitosorte.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;  // Importar para usar @JsonIgnore
import jakarta.persistence.*;
import java.util.List;

@Entity
public class FortunePhrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Geração automática sequencial (para banco com auto incremento)
    private Long id;  // Alterado para Long

    @Column(nullable = false, unique = true)
    private String conteudo;

    private String autor;

    @OneToMany(mappedBy = "frase", cascade = CascadeType.ALL, orphanRemoval = true)  
    @JsonIgnore  // Ignorar a serialização da lista fortuneCookies para evitar a circularidade
    private List<FortuneCookie> fortuneCookies;

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

    public List<FortuneCookie> getFortuneCookies() {
        return fortuneCookies;
    }

    public void setFortuneCookies(List<FortuneCookie> fortuneCookies) {
        this.fortuneCookies = fortuneCookies;
    }
}
