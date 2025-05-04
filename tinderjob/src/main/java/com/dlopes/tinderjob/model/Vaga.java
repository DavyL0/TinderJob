package com.dlopes.tinderjob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.model
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 02/05/2025
 * Time: 19:10
 * <p>
 */

@Entity
@Table(name = "VAGAS")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Alterado para IDENTITY
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @Size(min = 2, max = 100)
    private String nome;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String requisitos;

    @NotNull
    @Column(length = 20) // Define o tamanho máximo
    private String status;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao = LocalDate.now(); // Renomeado para match com o banco

    @OneToMany(mappedBy = "vaga")
    @JsonIgnore // Adicionado para evitar serialização circular
    private List<User> users; // Renomeado para plural

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

