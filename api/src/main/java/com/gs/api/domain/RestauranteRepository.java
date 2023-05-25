package com.gs.api.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Usuario> findAllByAtivoTrue();

    Restaurante findAllByEmailAndSenha(String email, String senha);
}
