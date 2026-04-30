package com.reginaldo.academia.repository;

// meu pacote onde está repository aluno//
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;// não entendi//
import org.springframework.stereotype.Repository;// não entendi//

import com.reginaldo.academia.model.Aluno;
// minha classe aluno//

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);// não entendi//

    boolean existsByCpf(String cpf);
}
