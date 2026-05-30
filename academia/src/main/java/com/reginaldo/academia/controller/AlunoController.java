package com.reginaldo.academia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reginaldo.academia.model.Aluno;
import com.reginaldo.academia.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public Aluno salvar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Aluno editar(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.editar(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
