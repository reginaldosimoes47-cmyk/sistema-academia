package com.reginaldo.academia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.reginaldo.academia.model.Pagamento;
import com.reginaldo.academia.repository.PagamentoRepository;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;
    private final Logger logger = LoggerFactory.getLogger(PagamentoService.class);

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Pagamento salvar(Pagamento pagamento) {
        if (pagamento == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pagamento requerido");
        }
        logger.info("Salvando pagamento do aluno id={}", pagamento.getAlunoId());
        return repository.save(pagamento);
    }

    @Transactional(readOnly = true)
    public List<Pagamento> listarTodos() {
        logger.info("Listando todos os pagamentos");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Pagamento> buscarPorAluno(Long alunoId) {
        if (alunoId == null || alunoId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        return repository.findByAlunoId(alunoId);
    }

    @Transactional
    public void deletar(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado");
        }
        repository.deleteById(id);
    }
}