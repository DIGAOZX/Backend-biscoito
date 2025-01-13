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

    @PostMapping
    public ResponseEntity<FortuneCookie> create(@RequestBody FortuneCookie cookie, @RequestParam UUID phraseId) {
        try {
            FortuneCookie createdCookie = service.create(cookie, phraseId);
            return ResponseEntity.ok(createdCookie);
        } catch (RuntimeException ex) {
            // Caso o erro seja de uma exceção, retorne um status 400 e uma mensagem de erro.
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<FortuneCookie>> findAll() {
        try {
            List<FortuneCookie> cookies = service.findAll();
            return ResponseEntity.ok(cookies);
        } catch (Exception ex) {
            // Em caso de erro, retorna o status 500 com a mensagem de erro.
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FortuneCookie> findById(@PathVariable UUID id) {
        try {
            FortuneCookie cookie = service.findById(id);
            return ResponseEntity.ok(cookie);
        } catch (RuntimeException ex) {
            // Se não encontrar o cookie, retorna 404 Not Found.
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FortuneCookie> update(@PathVariable UUID id, @RequestBody FortuneCookie cookie, @RequestParam UUID phraseId) {
        try {
            FortuneCookie updatedCookie = service.update(id, cookie, phraseId);
            return ResponseEntity.ok(updatedCookie);
        } catch (RuntimeException ex) {
            // Caso o erro seja de uma exceção, retorne um status 400 ou 404.
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            // Caso o erro seja de uma exceção, retorne 404 ou 500, conforme o caso.
            return ResponseEntity.status(404).build();
        }
    }
}
