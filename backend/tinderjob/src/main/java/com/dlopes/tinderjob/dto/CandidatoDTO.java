package com.dlopes.tinderjob.dto;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.dto
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 04/05/2025
 * Time: 21:44
 * <p>
 */
public class CandidatoDTO {
    private Long id;
    private String nome;
    private String email;

    public CandidatoDTO(Long id, String username, String email) {
        this.id = id;
        this.nome = username;
        this.email = email;
    }

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
}
