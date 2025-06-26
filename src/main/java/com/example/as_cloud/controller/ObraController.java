package com.example.as_cloud.controller;

import com.example.as_cloud.model.Obra;
import com.example.as_cloud.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {

    private final ObraService obraService;

    @Autowired
    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<Obra> create(@RequestBody Obra obra, @RequestParam Integer artistaId) {
        Obra novaObra = obraService.cadastrarObra(obra, artistaId);
        return new ResponseEntity<>(novaObra, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Obra>> getAll() {
        return ResponseEntity.ok(obraService.listarObras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(obraService.buscarObraPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        obraService.deletarObra(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Obra>> findByTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(obraService.buscarObraPorTitulo(titulo));
    }

    @GetMapping("/artista/{artistaId}")
    public ResponseEntity<List<Obra>> findByArtistaId(@PathVariable Integer artistaId) {
        return ResponseEntity.ok(obraService.buscarObraPorArtistaId(artistaId));
    }

    @GetMapping("/buscar-por-artista")
    public ResponseEntity<List<Obra>> findByNomeArtista(@RequestParam String nome) {
        return ResponseEntity.ok(obraService.buscarObraPorNomeArtista(nome));
    }
}