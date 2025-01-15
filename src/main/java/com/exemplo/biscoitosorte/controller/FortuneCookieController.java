package com.exemplo.biscoitosorte.controller;

import com.exemplo.biscoitosorte.dto.FortuneCookieDto;
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
    private FortuneCookieService cookieService;


    // Criar um novo biscoito, associando a uma frase existente
    @PostMapping
    public ResponseEntity<?> create(@RequestBody FortuneCookieDto cookieDto) {
        try {
            // Criar o biscoito utilizando o DTO
            FortuneCookie createdCookie = cookieService.create(cookieDto);
            return ResponseEntity.ok(createdCookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Erro ao criar o biscoito: " + ex.getMessage());
        }
    }

    // Buscar todos os biscoitos
    @GetMapping
    public ResponseEntity<List<FortuneCookie>> findAll() {
        try {
            List<FortuneCookie> cookies = cookieService.findAll();
            return ResponseEntity.ok(cookies);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Buscar biscoito pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            FortuneCookie cookie = cookieService.findById(id);
            if (cookie == null) {
                return ResponseEntity.status(404).body("Biscoito não encontrado com o ID: " + id);
            }
            return ResponseEntity.ok(cookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).body("Erro ao buscar o biscoito: " + ex.getMessage());
        }
    }

    // Atualizar um biscoito existente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FortuneCookie cookie) {
        try {
            FortuneCookie existingCookie = cookieService.findById(id);
            if (existingCookie == null) {
                return ResponseEntity.status(404).body("Biscoito não encontrado com o ID: " + id);
            }

            FortuneCookie updatedCookie = cookieService.update(id, cookie);
            return ResponseEntity.ok(updatedCookie);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(400).body("Erro ao atualizar o biscoito: " + ex.getMessage());
        }
    }

    // Deletar um biscoito pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            FortuneCookie cookie = cookieService.findById(id);
            if (cookie == null) {
                return ResponseEntity.status(404).build();
            }

            cookieService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).build();
        }
    }
}
