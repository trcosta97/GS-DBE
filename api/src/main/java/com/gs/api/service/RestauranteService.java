package com.gs.api.service;

import com.gs.api.domain.Restaurante;
import com.gs.api.domain.RestauranteRepository;
import com.gs.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Restaurante salvarRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }


    public List<Usuario> todosRestaurantesAtivos() {
        return restauranteRepository.findAllByAtivoTrue();
    }

    public Restaurante loginRestaurante(String email, String senha){
        return restauranteRepository.findAllByEmailAndSenha(email, senha);
    }
}
