package com.dlopes.tinderjob.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.model
 * <p>
 * User: Davy Lopes
 * Email: davylopes866@gmail.com
 * Date: 30/04/2025
 * Time: 12:18
 * <p>
 */
@Entity(name = "CANDIDATURA")
public class Candidatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidatura_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id", referencedColumnName = "vaga_id")
    @NotNull
    private Vagas vagas;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @NotNull
    private Users user;

    @Column(name = "status")
    @NotNull
    private String status;

    @Column(name = "date-update")
    private LocalDate updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vagas getVagas() {
        return vagas;
    }

    public void setVagas(Vagas vagas) {
        this.vagas = vagas;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
