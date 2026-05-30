package com.reginaldo.academia.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "plano")
    private String plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

    public Aluno() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }

    public List<AvaliacaoFisica> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) { this.avaliacoes = avaliacoes; }

    public void addAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
        avaliacao.setAluno(this);
    }

}
