package com.dlopes.tinderjob.dto;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.dto
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 03/05/2025
 * Time: 01:24
 * <p>
 */
public class UserUpdateDTO {
    private Boolean admin; // Pode ser null
    private String description;
    private String password;
    private String username;
    private Long vaga_id;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getVaga_id() {
        return vaga_id;
    }

    public void setVaga_id(Long vaga_id) {
        this.vaga_id = vaga_id;
    }
}
