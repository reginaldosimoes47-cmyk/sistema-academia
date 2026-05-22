package com.reginaldo.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reginaldo.academia.model.PlanoAula;
import com.reginaldo.academia.service.PlanoAulaService;

@RestController
@RequestMapping("/planos")
public class PlanoAulaController {

    @Autowired
    private PlanoAulaService service;

    @PostMapping("/cadastrar")
    public PlanoAula cadastrar(@RequestBody PlanoAula plano) {
        return service.salvar(plano);
    }

    @GetMapping
    public List<PlanoAula> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
