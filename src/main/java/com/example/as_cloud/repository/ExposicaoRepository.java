package com.example.as_cloud.repository;

import com.example.as_cloud.model.Exposicao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExposicaoRepository extends JpaRepository<Exposicao, Integer> {
    List<Exposicao> findByNomeContainingIgnoreCase(String nome);
}