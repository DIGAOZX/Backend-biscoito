package com.exemplo.biscoitosorte.controller;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.service.FortunePhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/frases")
public class FortunePhraseController {

    @Autowired
    private FortunePhraseService service;

    @PostMapping
    public ResponseEntity<FortunePhrase> create(@RequestBody FortunePhrase phrase) {
        return ResponseEntity.ok(service.create(phrase));
    }

    @GetMapping
    public ResponseEntity<List<FortunePhrase>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FortunePhrase> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FortunePhrase> update(@PathVariable UUID id, @RequestBody FortunePhrase phrase) {
        return ResponseEntity.ok(service.update(id, phrase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
