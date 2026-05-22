package com.reginaldo.academia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.reginaldo.academia.model.Pagamento;
import com.reginaldo.academia.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping("/cadastrar")
    public Pagamento cadastrar(@RequestBody Pagamento pagamento) {
        return service.salvar(pagamento);
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Pagamento> buscarPorAluno(@PathVariable Long alunoId) {
        return service.buscarPorAluno(alunoId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}