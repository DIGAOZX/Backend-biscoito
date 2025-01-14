package com.exemplo.biscoitosorte.service;     

import com.exemplo.biscoitosorte.entity.FortuneCookie;
import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortuneCookieRepository;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FortuneCookieService {

    @Autowired
    private FortuneCookieRepository cookieRepository;

    @Autowired
    private FortunePhraseRepository phraseRepository;

    public FortuneCookie create(FortuneCookie cookie, Long phraseId) { // Alterado para Long
        FortunePhrase phrase = phraseRepository.findById(phraseId)
                .orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
        cookie.setFrase(phrase);
        return cookieRepository.save(cookie);
    }

    public List<FortuneCookie> findAll() {
        return cookieRepository.findAll();
    }

    public FortuneCookie findById(Long id) { // Alterado para Long
        return cookieRepository.findById(id).orElseThrow(() -> new RuntimeException("Biscoito não encontrado!"));
    }

    public FortuneCookie update(Long id, FortuneCookie cookie, Long phraseId) { // Alterado para Long
        FortuneCookie existing = findById(id);
        FortunePhrase phrase = phraseRepository.findById(phraseId)
                .orElseThrow(() -> new RuntimeException("Frase não encontrada!"));
        existing.setNome(cookie.getNome());
        existing.setFrase(phrase);
        return cookieRepository.save(existing);
    }

    public void delete(Long id) { // Alterado para Long
        cookieRepository.deleteById(id);
    }
}
