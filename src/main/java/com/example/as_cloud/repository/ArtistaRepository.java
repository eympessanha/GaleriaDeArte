package com.example.as_cloud.repository;

import com.example.as_cloud.model.Artista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    List<Artista> findByNomeContainingIgnoreCase(String nome);
}