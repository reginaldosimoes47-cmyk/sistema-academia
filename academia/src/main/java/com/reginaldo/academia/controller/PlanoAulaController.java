// Pacote onde está localizado esse arquivo — organiza o projeto em pastas
package com.reginaldo.academia.controller;

// Importa a classe List do Java — usada para retornar listas de planos
import java.util.List;

// Importa o @Autowired — usado para injetar dependências automaticamente
import org.springframework.beans.factory.annotation.Autowired;

// Importa o @DeleteMapping — usado para mapear requisições HTTP DELETE
import org.springframework.web.bind.annotation.DeleteMapping;

// Importa o @GetMapping — usado para mapear requisições HTTP GET
import org.springframework.web.bind.annotation.GetMapping;

// Importa o @PathVariable — usado para pegar variáveis da URL
import org.springframework.web.bind.annotation.PathVariable;

// Importa o @PostMapping — usado para mapear requisições HTTP POST
import org.springframework.web.bind.annotation.PostMapping;

// Importa o @RequestBody — usado para pegar os dados do corpo da requisição
import org.springframework.web.bind.annotation.RequestBody;

// Importa o @RequestMapping — usado para definir a rota base da classe
import org.springframework.web.bind.annotation.RequestMapping;

// Importa o @RestController — diz ao Spring que essa classe recebe e responde requisições HTTP
import org.springframework.web.bind.annotation.RestController;

// Importa a classe PlanoAula — representa a tabela plano_aula do banco de dados
import com.reginaldo.academia.model.PlanoAula;

// Importa o PlanoAulaService — é quem tem as regras de negócio dos planos
import com.reginaldo.academia.service.PlanoAulaService;

// Diz ao Spring que essa classe é um Controller REST
@RestController

// Define que todas as rotas dessa classe começam com /planos
@RequestMapping("/planos")
public class PlanoAulaController {

    // Injeta o PlanoAulaService automaticamente — o Spring cria e entrega ele pronto
    @Autowired
    private PlanoAulaService service;

    // Rota POST — recebe os dados do plano e salva no banco
    // Acesso: POST http://localhost:8080/planos/cadastrar
    @PostMapping("/cadastrar")
    public PlanoAula cadastrar(@RequestBody PlanoAula plano) {
        // @RequestBody — pega os dados do corpo da requisição e transforma em objeto PlanoAula
        return service.salvar(plano); // Chama o service para salvar no banco
    }

    // Rota GET — busca e retorna todos os planos do banco
    // Acesso: GET http://localhost:8080/planos
    @GetMapping
    public List<PlanoAula> listarTodos() {
        return service.listarTodos(); // Chama o service para buscar todos os planos
    }

    // Rota DELETE — apaga um plano do banco pelo id
    // Acesso: DELETE http://localhost:8080/planos/1
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        // @PathVariable — pega o {id} da URL e usa como parâmetro
        service.deletar(id); // Chama o service para deletar o plano
    }
}
