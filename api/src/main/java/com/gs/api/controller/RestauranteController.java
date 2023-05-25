package com.gs.api.controller;

import com.gs.api.domain.Restaurante;
import com.gs.api.domain.RestauranteDTO;
import com.gs.api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/restaurantes")
    public ResponseEntity<Restaurante> salvarRestaurante(@RequestBody RestauranteDTO dados){
        var newRestaurante = new Restaurante(dados);
        Restaurante restauranteSalvo = restauranteService.salvarRestaurante(newRestaurante);
        return ResponseEntity.ok(restauranteSalvo);
    }

    @PostMapping("/restaurantes/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String email, @RequestParam String senha){
        Restaurante restaurante = restauranteService.loginRestaurante(email, senha);
        if(restaurante !=null){
            return ResponseEntity.ok("Login realizado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Dados de login inválidos");
        }
    }

}
