package com.exemplo.biscoitosorte.service;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public FortunePhrase findById(Long id) { // Alterado para Long
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
    }

    public FortunePhrase update(Long id, FortunePhrase phrase) { // Alterado para Long
        FortunePhrase existing = findById(id);
        existing.setConteudo(phrase.getConteudo());
        existing.setAutor(phrase.getAutor());
        return repository.save(existing);
    }

    public void delete(Long id) { // Alterado para Long
        repository.deleteById(id);
    }
}
