package com.example.as_cloud.controller;

import com.example.as_cloud.model.Artista;
import com.example.as_cloud.service.ArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    private final ArtistaService artistaService;

    @Autowired
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping
    public ResponseEntity<Artista> cadastrarArtista(@RequestBody Artista artista) {
        Artista novoArtista = artistaService.cadastrarArtista(artista);
        return new ResponseEntity<>(novoArtista, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Artista>> listarArtistas() {
        return ResponseEntity.ok(artistaService.listarArtistas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarArtistaPorId(@PathVariable Integer id) {
        Artista artista = artistaService.buscarArtistaPorId(id);
        return ResponseEntity.ok(artista);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Artista>> buscarArtistaPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(artistaService.buscarArtistaPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable Integer id, @RequestBody Artista artistaDetails) {
        return ResponseEntity.ok(artistaService.atualizarArtista(id, artistaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtista(@PathVariable Integer id) {
        artistaService.deletarArtista(id);
        return ResponseEntity.noContent().build();
    }
}