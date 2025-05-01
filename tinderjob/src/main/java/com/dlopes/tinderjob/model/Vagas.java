package com.dlopes.tinderjob.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Project: tinderjob2
 * Package: com.dlopes.tinderjob.model
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 29/04/2025
 * Time: 22:43
 * <p>
 */
@Entity(name = "VAGAS")
public class Vagas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vaga_id")
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String name;

    @NotNull(message = "Descrição é obrigatória")
    @Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres")
    private String description;

    @NotNull(message = "Requisitos é obrigatória")
    @Size(min = 5, max = 255, message = "Os requisitos deve ter entre 5 e 255 caracteres")
    private String requisitos;

    @OneToMany(mappedBy = "vagas")
    private List<Candidatura> candidaturas;


    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public List<Candidatura> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<Candidatura> candidaturas) {
        this.candidaturas = candidaturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
