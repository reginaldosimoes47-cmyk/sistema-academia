package com.reginaldo.academia.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.reginaldo.academia.model.Aluno;
import com.reginaldo.academia.repository.AlunoRepository;


@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Aluno salvar(Aluno aluno) {
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno não pode ser nulo");
        }
        if (aluno.getCpf() != null && repository.existsByCpf(aluno.getCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }
        return repository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Transactional
    public Aluno editar(Long id, Aluno atualizado) {
        if (id == null || atualizado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
        
        return repository.findById(id).map(aluno -> {
            aluno.setNome(atualizado.getNome());
            aluno.setEmail(atualizado.getEmail());
            aluno.setCpf(atualizado.getCpf());
            aluno.setIdade(atualizado.getIdade());
            aluno.setMatricula(atualizado.getMatricula());
            aluno.setPlano(atualizado.getPlano());
            aluno.setRg(atualizado.getRg());
            return repository.save(aluno);
        }).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Transactional
    public void deletar(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }

        repository.findById(id).ifPresentOrElse(
            repository::delete,
            () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"); }
        );
    }
}
