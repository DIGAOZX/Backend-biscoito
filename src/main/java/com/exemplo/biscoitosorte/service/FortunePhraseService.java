package com.exemplo.biscoitosorte.service;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FortunePhraseService {

    @Autowired
    private FortunePhraseRepository repository;

    // Criar uma nova frase
    public FortunePhrase create(FortunePhrase phrase) {
        if (repository.findByConteudo(phrase.getConteudo()).isPresent()) {
            // Se a frase já existir no banco, retornamos um erro 400 Bad Request
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Frase já cadastrada!");
        }
        return repository.save(phrase);
    }

    public List<FortunePhrase> findAll() {
        return repository.findAll();
    }

    public FortunePhrase findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frase não encontrada!"));
    }

    public FortunePhrase update(Long id, FortunePhrase phrase) {
        FortunePhrase existing = findById(id);
        existing.setConteudo(phrase.getConteudo());
        existing.setAutor(phrase.getAutor());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
