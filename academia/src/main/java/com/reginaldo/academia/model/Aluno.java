package com.reginaldo.academia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Atributos do aluno (as características que ele tem) nome do aluno, email, cpf, idade,
    // matricula, plano, peso, altura, rg Atributo é sempre uma variável (um nome que guarda um
    // valor)//
    private String nome;
    private String email;
    private String cpf;

    private Integer idade;
    private String matricula;
    private String plano;
    private Double peso;
    private Double altura;
    private String rg;
    private Double medidaBiceps;
    private Double medidaTriceps;
    private Double medidaCintura;
    private Double medidaCipanturrilha;
    private Double medidaPeitoral;
    private Double medidaQuadril;

    // --- GETTERS E SETTERS (As portas de acesso) ---
    // O Java precisa disso para o erro de 'setNome' sumir!

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getMedidaBiceps() {
        return medidaBiceps;
    }

    public void setMedidaBiceps(Double medidaBiceps) {
        this.medidaBiceps = medidaBiceps;
    }

    public Double getMedidaTriceps() {
        return medidaTriceps;
    }

    public void setMedidaTriceps(Double medidaTriceps) {
        this.medidaTriceps = medidaTriceps;
    }

    public Double getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(Double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public Double getMedidaCipanturrilha() {
        return medidaCipanturrilha;
    }

    public void setMedidaCipanturrilha(Double medidaCipanturrilha) {
        this.medidaCipanturrilha = medidaCipanturrilha;
    }

    public Double getMedidaPeitoral() {
        return medidaPeitoral;
    }

    public void setMedidaPeitoral(Double medidaPeitoral) {
        this.medidaPeitoral = medidaPeitoral;
    }

    public Double getMedidaQuadril() {
        return medidaQuadril;
    }

    public void setMedidaQuadril(Double medidaQuadril) {
        this.medidaQuadril = medidaQuadril;
    }
}
