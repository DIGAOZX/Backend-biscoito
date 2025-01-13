package com.exemplo.biscoitosorte.service;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FortunePhraseService {

    @Autowired
    private FortunePhraseRepository repository;

    public FortunePhrase create(FortunePhrase phrase) {
        if (repository.findByConteudo(phrase.getConteudo()).isPresent()) {
            throw new RuntimeException("Frase já cadastrada!");
        }
        return repository.save(phrase);
    }

    public List<FortunePhrase> findAll() {
        return repository.findAll();
    }

    public FortunePhrase findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
    }

    public FortunePhrase update(UUID id, FortunePhrase phrase) {
        FortunePhrase existing = findById(id);
        existing.setConteudo(phrase.getConteudo());
        existing.setAutor(phrase.getAutor());
        return repository.save(existing);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
