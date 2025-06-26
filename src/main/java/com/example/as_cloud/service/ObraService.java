package com.example.as_cloud.service;

import com.example.as_cloud.model.Artista;
import com.example.as_cloud.model.Obra;
import com.example.as_cloud.repository.ObraRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {

    private ObraRepository obraRepository;
    private ArtistaService artistaService;

    public ObraService(ObraRepository obraRepository, ArtistaService artistaService) {
        this.obraRepository = obraRepository;
        this.artistaService = artistaService;
    }

    public Obra cadastrarObra(Obra obra, Integer artistaId) {
        Artista artista = artistaService.buscarArtistaPorId(artistaId);
        obra.setArtista(artista);

        return obraRepository.save(obra);
    }

    public List<Obra> listarObras() {
        return obraRepository.findAll();
    }

    public Obra buscarObraPorId(Integer id) {
        return obraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Obra não encontrada com o ID: " + id));
    }

    public void deletarObra(Integer id) {
        if (!obraRepository.existsById(id)) {
            throw new EntityNotFoundException("Obra não encontrada com o ID: " + id);
        }
        obraRepository.deleteById(id);
    }

    public List<Obra> buscarObraPorTitulo(String titulo) {
        return obraRepository.findByTituloContainingIgnoreCase(titulo);
    }

    // talvez trocar por nome
    public List<Obra> buscarObraPorArtistaId(Integer artistaId) {
        artistaService.buscarArtistaPorId(artistaId);
        return obraRepository.findByArtistaId(artistaId);
    }

    public List<Obra> buscarObraPorNomeArtista(String nome) {
    List<Artista> artistas = artistaService.buscarArtistaPorNome(nome);
    if (artistas.isEmpty()) {
        throw new EntityNotFoundException("Nenhum artista encontrado com o nome: " + nome);
    }
    // Supondo que uma obra pode ter apenas um artista, mas pode haver vários artistas com nomes parecidos
    return obraRepository.findByArtistaIn(artistas);
}
}

