package com.exemplo.biscoitosorte.service;

import com.exemplo.biscoitosorte.entity.FortuneCookie;
import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortuneCookieRepository;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FortuneCookieService {

    @Autowired
    private FortuneCookieRepository cookieRepository;

    @Autowired
    private FortunePhraseRepository phraseRepository;

    public FortuneCookie create(FortuneCookie cookie, UUID phraseId) {
        FortunePhrase phrase = phraseRepository.findById(phraseId)
                .orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
        cookie.setFrase(phrase);
        return cookieRepository.save(cookie);
    }

    public List<FortuneCookie> findAll() {
        return cookieRepository.findAll();
    }

    public FortuneCookie findById(UUID id) {
        return cookieRepository.findById(id).orElseThrow(() -> new RuntimeException("Biscoito não encontrado!"));
    }

    public FortuneCookie update(UUID id, FortuneCookie cookie, UUID phraseId) {
        FortuneCookie existing = findById(id);
        FortunePhrase phrase = phraseRepository.findById(phraseId)
                .orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
        existing.setNome(cookie.getNome());
        existing.setFrase(phrase);
        return cookieRepository.save(existing);
    }

    public void delete(UUID id) {
        cookieRepository.deleteById(id);
    }
}