package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.Vagas;

import java.util.List;
import java.util.Optional;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.service
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 29/04/2025
 * Time: 23:10
 * <p>
 */
public interface IVagasService {
    Vagas saveVagas(Vagas vagas);
    List<Vagas> findAll();
    Optional<Vagas> findVagasById(Long id);
    void deleteVagasById(Long id);
}
