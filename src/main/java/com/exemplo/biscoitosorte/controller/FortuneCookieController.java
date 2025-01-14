package com.exemplo.biscoitosorte.controller;

import com.exemplo.biscoitosorte.entity.FortuneCookie;
import com.exemplo.biscoitosorte.service.FortuneCookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biscoitos")
public class FortuneCookieController {

    @Autowired
    private FortuneCookieService service;

    // Criar um novo biscoito
    @PostMapping
    public ResponseEntity<FortuneCookie> create(@RequestBody FortuneCookie cookie, @RequestParam Long phraseId) {
        try {
            FortuneCookie createdCookie = service.create(cookie, phraseId); // Passando o Long como parâmetro
            return ResponseEntity.ok(createdCookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Buscar todos os biscoitos
    @GetMapping
    public ResponseEntity<List<FortuneCookie>> findAll() {
        try {
            List<FortuneCookie> cookies = service.findAll();
            return ResponseEntity.ok(cookies);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Buscar biscoito pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<FortuneCookie> findById(@PathVariable Long id) {
        try {
            FortuneCookie cookie = service.findById(id);
            return ResponseEntity.ok(cookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Atualizar um biscoito existente
    @PutMapping("/{id}")
    public ResponseEntity<FortuneCookie> update(@PathVariable Long id, @RequestBody FortuneCookie cookie, @RequestParam Long phraseId) {
        try {
            FortuneCookie updatedCookie = service.update(id, cookie, phraseId);
            return ResponseEntity.ok(updatedCookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(400).body(null);
        }
    }

    // Deletar um biscoito pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).build();
        }
    }
}
