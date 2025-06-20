package com.example.as_cloud.service;

import com.example.as_cloud.model.Artista;
import com.example.as_cloud.repository.ArtistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Artista cadastrarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }

    public Artista buscarArtistaPorId(Integer id) {
        return artistaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artista não encontrado com o ID: " + id));
    }

    public List<Artista> buscarArtistaPorNome(String nome) {
        return artistaRepository.findByNomeContainingIgnoreCase(nome);
    }

    // mudar
    public Artista atualizarArtista(Integer id, Artista artistaDetails) {
        Artista artista = buscarArtistaPorId(id);
        artista.setNome(artistaDetails.getNome());
        artista.setBiografia(artistaDetails.getBiografia());
        artista.setDataNascimento(artistaDetails.getDataNascimento());
        return artistaRepository.save(artista);
    }

    public void deletarArtista(Integer id) {
        if (!artistaRepository.existsById(id)) {
            throw new EntityNotFoundException("Artista não encontrado com o ID: " + id);
        }
        artistaRepository.deleteById(id);
    }
}