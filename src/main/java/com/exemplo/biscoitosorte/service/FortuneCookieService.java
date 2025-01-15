package com.exemplo.biscoitosorte.service;

import com.exemplo.biscoitosorte.dto.FortuneCookieDto;
import com.exemplo.biscoitosorte.entity.FortuneCookie;
import com.exemplo.biscoitosorte.entity.FortunePhrase;
import com.exemplo.biscoitosorte.repository.FortuneCookieRepository;
import com.exemplo.biscoitosorte.repository.FortunePhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FortuneCookieService {

    @Autowired
    private FortuneCookieRepository cookieRepository;

    @Autowired
    private FortunePhraseRepository phraseRepository;

    // Criar um novo biscoito associado a uma frase
    public FortuneCookie create(FortuneCookieDto cookieDto) {
        FortunePhrase phrase = phraseRepository.findById(cookieDto.getPhraseId()).orElse(null);
        if (phrase == null) {
            // Se a frase não existir, retornamos um erro 400 Bad Request
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Frase com ID " + cookieDto.getPhraseId() + " não encontrada");
        }

        FortuneCookie cookie = new FortuneCookie();
        cookie.setNome(cookieDto.getNome());
        cookie.setFrase(phrase);

        return cookieRepository.save(cookie);
    }

    // Outros métodos do serviço
    public List<FortuneCookie> findAll() {
        return cookieRepository.findAll();
    }

    public FortuneCookie findById(Long id) {
        return cookieRepository.findById(id).orElse(null);
    }

    public FortuneCookie update(Long id, FortuneCookie cookie) {
        FortuneCookie existingCookie = findById(id);
        if (existingCookie == null) {
            throw new RuntimeException("Biscoito com ID " + id + " não encontrado");
        }
        existingCookie.setNome(cookie.getNome());
        existingCookie.setFrase(cookie.getFrase());
        return cookieRepository.save(existingCookie);
    }

    public void delete(Long id) {
        cookieRepository.deleteById(id);
    }
}
