package com.example.as_cloud.controller;

import com.example.as_cloud.model.Exposicao;
import com.example.as_cloud.service.ExposicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exposicao")
public class ExposicaoController {

    private final ExposicaoService exposicaoService;

    public ExposicaoController(ExposicaoService exposicaoService) {
        this.exposicaoService = exposicaoService;
    }

    @PostMapping
    public ResponseEntity<Exposicao> create(@RequestBody Exposicao exposicao) {
        return new ResponseEntity<>(exposicaoService.criarExposicao(exposicao), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exposicao>> getAll() {
        return ResponseEntity.ok(exposicaoService.listarExposicoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exposicao> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(exposicaoService.buscarExposicaoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        exposicaoService.deletarExposicao(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{exposicaoId}/obras/{obraId}")
    public ResponseEntity<Exposicao> addObra(@PathVariable Integer exposicaoId, @PathVariable Integer obraId) {
        return ResponseEntity.ok(exposicaoService.adicionarObra(exposicaoId, obraId));
    }

    @DeleteMapping("/{exposicaoId}/obras/{obraId}")
    public ResponseEntity<Exposicao> removeObra(@PathVariable Integer exposicaoId, @PathVariable Integer obraId) {
        return ResponseEntity.ok(exposicaoService.removerObra(exposicaoId, obraId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Exposicao>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(exposicaoService.buscarExposicaoPorNome(nome));
    }
}