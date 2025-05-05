package com.dlopes.tinderjob.dto;

import java.util.List;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.dto
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 04/05/2025
 * Time: 21:43
 * <p>
 */
public class VagaCandidatosDTO {
    private Long vagaId;
    private String vagaNome;

    public List<CandidatoDTO> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoDTO> candidatos) {
        this.candidatos = candidatos;
    }

    public String getVagaNome() {
        return vagaNome;
    }

    public void setVagaNome(String vagaNome) {
        this.vagaNome = vagaNome;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public void setVagaId(Long vagaId) {
        this.vagaId = vagaId;
    }

    private List<CandidatoDTO>

            candidatos;
}
