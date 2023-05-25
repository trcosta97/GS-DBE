package com.gs.api.controller;

import com.gs.api.domain.Alimento;
import com.gs.api.domain.AlimentoDTO;
import com.gs.api.service.AlimentoService;
import com.oracle.svm.core.annotate.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("/alimentos")
    public ResponseEntity<Alimento> salvarAlimento(@RequestBody AlimentoDTO dadosAlimento){
        var newAlimento = new Alimento (dadosAlimento);
        Alimento alimentoSalvo = alimentoService.salvarAlimento(newAlimento);
        return ResponseEntity.ok(alimentoSalvo);
    }

    @GetMapping("/alimentos")
    public ResponseEntity<List<Alimento>> todosAlimentosAtivos() {
        List<Alimento> alimentosAtivos = alimentoService.todosAlimentosAtivos();
        return ResponseEntity.status(HttpStatus.OK).body(alimentosAtivos);
    }

    @DeleteMapping("/alimentos/{id}")
    @Transactional
    public ResponseEntity<Alimento> deletarAlimento(@PathVariable Long id){
        Alimento alimento = alimentoService.findById(id);
        alimentoService.removerAlimento(id);
        return ResponseEntity.ok(alimento);
    }

}
