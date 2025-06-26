package com.example.as_cloud.repository;

import com.example.as_cloud.model.Artista;
import com.example.as_cloud.model.Obra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {
    List<Obra> findByTituloContainingIgnoreCase(String titulo);
    List<Obra> findByArtistaId(Integer artistaId);
    List<Obra> findByArtistaIn(List<Artista> artistas);
}