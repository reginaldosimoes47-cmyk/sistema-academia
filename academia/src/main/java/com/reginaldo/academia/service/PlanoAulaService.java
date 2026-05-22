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

    // Variável para acessar o Repository — faz as operações no banco de dados
    private final PlanoAulaRepository repository;

    // Variável para registrar mensagens no console — ajuda a monitorar o sistema
    private final Logger logger = LoggerFactory.getLogger(PlanoAulaService.class);

    // Construtor — o Spring injeta o Repository automaticamente aqui
    public PlanoAulaService(PlanoAulaRepository repository) {
        this.repository = repository;
    }

    // Garante que o plano seja salvo completamente ou não salvo
    @Transactional
    public PlanoAula salvar(PlanoAula plano) {
        // Verifica se o plano é nulo — se for, lança erro 400
        if (plano == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plano requerido");
        }
        // Registra no console que está salvando o plano
        logger.info("Salvando plano={}", plano.getNomePlano());
        // Salva no banco e retorna o plano salvo
        return repository.save(plano);
    }

    // Só lê do banco, não faz alterações — mais rápido!
    @Transactional(readOnly = true)
    public List<PlanoAula> listarTodos() {
        // Registra no console que está listando os planos
        logger.info("Listando todos os planos");
        // Busca e retorna todos os planos do banco
        return repository.findAll();
    }

    // Garante que o plano seja deletado completamente
    @Transactional
    public void deletar(Long id) {
        // Verifica se o id é nulo ou inválido — se for, lança erro 400
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        // Verifica se existe no banco — se não existir, lança erro 404
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado");
        }
        // Deleta o plano do banco pelo id
        repository.deleteById(id);
    }
}