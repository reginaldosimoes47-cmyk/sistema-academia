package com.reginaldo.academia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.reginaldo.academia.model.PlanoAula;
import com.reginaldo.academia.repository.PlanoAulaRepository;

@Service
public class PlanoAulaService {

    private final PlanoAulaRepository repository;
    private final Logger logger = LoggerFactory.getLogger(PlanoAulaService.class);

    public PlanoAulaService(PlanoAulaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PlanoAula salvar(PlanoAula plano) {
        if (plano == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plano requerido");
        }
        logger.info("Salvando plano={}", plano.getNomePlano());
        return repository.save(plano);
    }

    @Transactional(readOnly = true)
    public List<PlanoAula> listarTodos() {
        logger.info("Listando todos os planos");
        return repository.findAll();
    }

    @Transactional
    public void deletar(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado");
        }
        repository.deleteById(id);
    }
}