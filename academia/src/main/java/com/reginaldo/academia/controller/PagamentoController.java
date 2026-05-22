// Pacote onde está localizado esse arquivo — organiza o projeto em pastas
package com.reginaldo.academia.controller;

// Importa a classe List do Java — usada para retornar listas de pagamentos
import java.util.List;

// Importa o @Autowired — usado para injetar dependências automaticamente
import org.springframework.beans.factory.annotation.Autowired;

// Importa todas as anotações do Spring Web de uma vez (@GetMapping, @PostMapping, etc)
import org.springframework.web.bind.annotation.*;

// Importa a classe Pagamento — representa a tabela pagamento do banco de dados
import com.reginaldo.academia.model.Pagamento;

// Importa o PagamentoService — é quem tem as regras de negócio dos pagamentos
import com.reginaldo.academia.service.PagamentoService;

// Diz ao Spring que essa classe é um Controller REST — recebe e responde requisições HTTP
@RestController

// Define que todas as rotas dessa classe começam com /pagamentos
@RequestMapping("/pagamentos")
public class PagamentoController {

    // Injeta o PagamentoService automaticamente — o Spring cria e entrega ele pronto
    @Autowired
    private PagamentoService service;

    // Rota POST — recebe os dados do pagamento e salva no banco
    // Acesso: POST http://localhost:8080/pagamentos/cadastrar
    @PostMapping("/cadastrar")
    public Pagamento cadastrar(@RequestBody Pagamento pagamento) {
        // @RequestBody — pega os dados do corpo da requisição e transforma em objeto Pagamento
        return service.salvar(pagamento); // Chama o service para salvar no banco
    }

    // Rota GET — busca e retorna todos os pagamentos do banco
    // Acesso: GET http://localhost:8080/pagamentos
    @GetMapping
    public List<Pagamento> listarTodos() {
        return service.listarTodos(); // Chama o service para buscar todos os pagamentos
    }

    // Rota GET — busca todos os pagamentos de um aluno específico pelo id dele
    // Acesso: GET http://localhost:8080/pagamentos/aluno/1
    @GetMapping("/aluno/{alunoId}")
    public List<Pagamento> buscarPorAluno(@PathVariable Long alunoId) {
        // @PathVariable — pega o {alunoId} da URL e usa como parâmetro
        return service.buscarPorAluno(alunoId); // Chama o service para buscar pagamentos do aluno
    }

    // Rota DELETE — apaga um pagamento do banco pelo id
    // Acesso: DELETE http://localhost:8080/pagamentos/1
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        // @PathVariable — pega o {id} da URL e usa como parâmetro
        service.deletar(id); // Chama o service para deletar o pagamento
    }
}