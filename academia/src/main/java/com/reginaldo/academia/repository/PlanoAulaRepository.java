// Pacote onde está localizado esse arquivo — organiza o projeto em pastas
package com.reginaldo.academia.repository;

// Importa o JpaRepository — fornece os métodos prontos para acessar o banco
import org.springframework.data.jpa.repository.JpaRepository;

// Importa o @Repository — diz ao Spring que essa classe acessa o banco de dados
import org.springframework.stereotype.Repository;

// Importa a classe PlanoAula — representa a tabela plano_aula do banco de dados
import com.reginaldo.academia.model.PlanoAula;

// Diz ao Spring que essa interface acessa o banco de dados
@Repository
// JpaRepository já vem com save, findAll, findById, delete prontos!
public interface PlanoAulaRepository extends JpaRepository<PlanoAula, Long> {

}
