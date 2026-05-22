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

    // Variável para acessar o Repository — faz as operações no banco de dados
    private final PagamentoRepository repository;

    // Variável para registrar mensagens no console — ajuda a monitorar o sistema
    private final Logger logger = LoggerFactory.getLogger(PagamentoService.class);

    // Construtor — o Spring injeta o Repository automaticamente aqui
    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    // Garante que o pagamento seja salvo completamente ou não salvo
    @Transactional
    public Pagamento salvar(Pagamento pagamento) {
        // Verifica se o pagamento é nulo — se for, lança erro 400
        if (pagamento == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pagamento requerido");
        }
        // Registra no console que está salvando o pagamento
        logger.info("Salvando pagamento do aluno id={}", pagamento.getAlunoId());
        // Salva no banco e retorna o pagamento salvo
        return repository.save(pagamento);
    }

    // Só lê do banco, não faz alterações — mais rápido!
    @Transactional(readOnly = true)
    public List<Pagamento> listarTodos() {
        // Registra no console que está listando os pagamentos
        logger.info("Listando todos os pagamentos");
        // Busca e retorna todos os pagamentos do banco
        return repository.findAll();
    }

    // Só lê do banco, não faz alterações
    @Transactional(readOnly = true)
    public List<Pagamento> buscarPorAluno(Long alunoId) {
        // Verifica se o id é nulo ou inválido — se for, lança erro 400
        if (alunoId == null || alunoId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        // Busca e retorna todos os pagamentos do aluno pelo id
        return repository.findByAlunoId(alunoId);
    }

    // Garante que o pagamento seja deletado completamente
    @Transactional
    public void deletar(Long id) {
        // Verifica se o id é nulo ou inválido — se for, lança erro 400
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        // Verifica se existe no banco — se não existir, lança erro 404
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado");
        }
        // Deleta o pagamento do banco pelo id
        repository.deleteById(id);
    }
}
    // @Transactional — garante que o pagamento seja del