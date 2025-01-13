package com.exemplo.biscoitosorte.repository;

import com.exemplo.biscoitosorte.entity.FortuneCookie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FortuneCookieRepository extends JpaRepository<FortuneCookie, UUID> {
}
