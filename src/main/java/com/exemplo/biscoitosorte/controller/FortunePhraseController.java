package com.exemplo.biscoitosorte.controller;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.service.FortunePhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frases")
public class FortunePhraseController {

    @Autowired
    private FortunePhraseService service;

    // Criar uma nova frase
    @PostMapping
    public ResponseEntity<FortunePhrase> create(@RequestBody FortunePhrase phrase) {
        try {
            FortunePhrase createdPhrase = service.create(phrase);
            return new ResponseEntity<>(createdPhrase, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Erro ao criar frase
        }
    }

    // Buscar todas as frases
    @GetMapping
    public ResponseEntity<List<FortunePhrase>> findAll() {
        try {
            List<FortunePhrase> phrases = service.findAll();
            return ResponseEntity.ok(phrases);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Erro de servidor
        }
    }

    // Buscar frase pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<FortunePhrase> findById(@PathVariable Long id) {
        try {
            FortunePhrase phrase = service.findById(id);
            return ResponseEntity.ok(phrase);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Frase não encontrada
        }
    }

    // Atualizar uma frase
    @PutMapping("/{id}")
    public ResponseEntity<FortunePhrase> update(@PathVariable Long id, @RequestBody FortunePhrase phrase) {
        try {
            FortunePhrase updatedPhrase = service.update(id, phrase);
            return ResponseEntity.ok(updatedPhrase);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Erro ao atualizar frase
        }
    }

    // Deletar uma frase
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build(); // Sucesso ao deletar
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Frase não encontrada
        }
    }
}
