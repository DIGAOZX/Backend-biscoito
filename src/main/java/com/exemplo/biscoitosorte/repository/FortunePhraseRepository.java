package com.exemplo.biscoitosorte.repository;

import com.exemplo.biscoitosorte.entity.FortunePhrase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FortunePhraseRepository extends JpaRepository<FortunePhrase, UUID> {
    Optional<FortunePhrase> findByConteudo(String conteudo);
}
