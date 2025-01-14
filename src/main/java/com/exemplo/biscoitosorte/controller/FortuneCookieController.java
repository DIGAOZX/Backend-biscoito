package com.exemplo.biscoitosorte.controller;

import com.exemplo.biscoitosorte.entity.FortuneCookie;
import com.exemplo.biscoitosorte.service.FortuneCookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/biscoitos")
public class FortuneCookieController {

    @Autowired
    private FortuneCookieService service;

    // Criar um novo biscoito
    @PostMapping
    public ResponseEntity<FortuneCookie> create(@RequestBody FortuneCookie cookie, @RequestParam UUID phraseId) {
        try {
            FortuneCookie createdCookie = service.create(cookie, phraseId); // Passando o UUID como parâmetro
            return ResponseEntity.ok(createdCookie);
        } catch (Exception ex) {
            // Retorna 400 em caso de erro
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Buscar todos os biscoitos
    @GetMapping
    public ResponseEntity<List<FortuneCookie>> findAll() {
        try {
            List<FortuneCookie> cookies = service.findAll();
            return ResponseEntity.ok(cookies);
        } catch (Exception ex) {
            // Retorna status 500 em caso de erro
            return ResponseEntity.status(500).body(null);
        }
    }

    // Buscar biscoito pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<FortuneCookie> findById(@PathVariable UUID id) {
        try {
            FortuneCookie cookie = service.findById(id);
            return ResponseEntity.ok(cookie);
        } catch (RuntimeException ex) {
            // Se não encontrar, retorna 404 Not Found
            return ResponseEntity.status(404).body(null);
        }
    }

    // Atualizar um biscoito existente
    @PutMapping("/{id}")
    public ResponseEntity<FortuneCookie> update(@PathVariable UUID id, @RequestBody FortuneCookie cookie, @RequestParam UUID phraseId) {
        try {
            // Passa o UUID do biscoito, o objeto do biscoito e o UUID da frase para o método update
            FortuneCookie updatedCookie = service.update(id, cookie, phraseId);
            return ResponseEntity.ok(updatedCookie);
        } catch (RuntimeException ex) {
            // Caso haja um erro, retorna 400 ou 404 dependendo do erro
            return ResponseEntity.status(400).body(null);
        }
    }

    // Deletar um biscoito pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            // Retorna 404 ou 500, conforme o erro
            return ResponseEntity.status(404).build();
        }
    }
}
