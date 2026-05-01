package com.reginaldo.academia.service;
// meu pacote onde está service aluno onde ele vai poxar a informações , esse linha vai acessar
// bando de dados aluno//

import java.util.List;// import da lista Java//

import org.slf4j.Logger; // Biblioteca de logging (SLF4J)
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;// String biblioteca indica que é uma class de serviço//
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.reginaldo.academia.model.Aluno;// meu model aluno//
import com.reginaldo.academia.repository.AlunoRepository;
// meu repository aluno//

@Service // anotação para indicar que essa classe é um serviço do Spring//


public class AlunoService {// declaração da minha classe//

    private final AlunoRepository repository;// VARIaVEL PARA ACESSAR O REPOSITORY DO ALUNO//
    private final Logger logger = LoggerFactory.getLogger(AlunoService.class);// Variável recebe o
                                                                              // logger específico
                                                                              // para essa classe,
                                                                              // permitindo
                                                                              // registrar mensagens
                                                                              // de log com
                                                                              // contexto.//

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    // anotação para indicar que esse método é transacional, ou seja, ele vai ser executado dentro
    // de uma transação do banco de dados//
    public Aluno salvar(Aluno aluno) {
        // metodo salvar recebe um objeto do tipo aluno e retorna um objeto do tipo aluno ex:Ação
        // salvar é um metodo//

        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno requerido");
        }

        String cpf = aluno.getCpf();
        if (cpf == null || !cpf.matches("\\d{11}")) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF inválido");
        }

        if (repository.existsByCpf(cpf)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }

        // --- SE PASSOU NA BALANÇA ---
        // O Gerente (Service) dá o carimbo de OK e manda o Repository salvar no estoque
        logger.info("Salvando aluno com CPF={}", cpf);
        return repository.save(aluno);
    }

    @Transactional(readOnly = true)
    public List<Aluno> listarTodos() {
        logger.info("Listando todos os alunos cadastrados");
        return repository.findAll();
    }


    @Transactional(readOnly = true)
    public Aluno buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Aluno> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional
    public Aluno editar(Long id, Aluno alunoAtualizado) {
        // Validação do ID para evitar que ele "grite"
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }

        if (alunoAtualizado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno requerido");
        }

        return repository.findById(id).map(aluno -> {
            String novoCpf = alunoAtualizado.getCpf();
            if (novoCpf != null && !novoCpf.equals(aluno.getCpf())
                    && repository.existsByCpf(novoCpf)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
            }

            // Atualizando o básico
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setCpf(novoCpf);
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setPlano(alunoAtualizado.getPlano());
            aluno.setMatricula(alunoAtualizado.getMatricula());
            aluno.setRg(alunoAtualizado.getRg());

            // Atualizando as medidas (O shape!)
            aluno.setAltura(alunoAtualizado.getAltura());
            aluno.setPeso(alunoAtualizado.getPeso());
            aluno.setMedidaBiceps(alunoAtualizado.getMedidaBiceps());
            aluno.setMedidaTriceps(alunoAtualizado.getMedidaTriceps());
            aluno.setMedidaCintura(alunoAtualizado.getMedidaCintura());
            aluno.setMedidaPanturrilha(alunoAtualizado.getMedidaPanturrilha());
            aluno.setMedidaPeitoral(alunoAtualizado.getMedidaPeitoral());
            aluno.setMedidaQuadril(alunoAtualizado.getMedidaQuadril());

            logger.info("Atualizando aluno id={}", id);
            return repository.save(aluno);
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Transactional
    public void deletar(Long id) {
        // Validação do ID para evitar que ele "grite"
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        repository.deleteById(id);
    }
}
