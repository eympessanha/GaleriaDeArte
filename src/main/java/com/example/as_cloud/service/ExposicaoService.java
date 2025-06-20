package com.example.as_cloud.service;

import com.example.as_cloud.model.Exposicao;
import com.example.as_cloud.model.Obra;
import com.example.as_cloud.repository.ExposicaoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExposicaoService {

    private ExposicaoRepository exposicaoRepository;
    private ObraService obraService;

    public ExposicaoService(ExposicaoRepository exposicaoRepository, ObraService obraService) {
        this.exposicaoRepository = exposicaoRepository;
        this.obraService = obraService;
    }

    public Exposicao criarExposicao (Exposicao exposicao) {
        return exposicaoRepository.save(exposicao);
    }

    public List<Exposicao> listarExposicoes() {
        return exposicaoRepository.findAll();
    }

    public Exposicao buscarExposicaoPorId(Integer id) {
        return exposicaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exposição não encontrada com o ID: " + id));
    }

    public void deletarExposicao(Integer id) {
        if (!exposicaoRepository.existsById(id)) {
             throw new EntityNotFoundException("Exposição não encontrada com o ID: " + id);
        }
        exposicaoRepository.deleteById(id);
    }

    public Exposicao adicionarObra(Integer exposicaoId, Integer obraId) {
        Exposicao exposicao = buscarExposicaoPorId(exposicaoId);
        Obra obra = obraService.buscarObraPorId(obraId);
        exposicao.getObras().add(obra);
        return exposicaoRepository.save(exposicao);
    }

    public Exposicao removerObra(Integer exposicaoId, Integer obraId) {
        Exposicao exposicao = buscarExposicaoPorId(exposicaoId);
        Obra obra = obraService.buscarObraPorId(obraId);
        exposicao.getObras().remove(obra);
        return exposicaoRepository.save(exposicao);
    }

    public List<Exposicao> buscarExposicaoPorNome(String nome) {
        return exposicaoRepository.findByNomeContainingIgnoreCase(nome);
    }
}