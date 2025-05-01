package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.Candidatura;

import java.util.List;
import java.util.Optional;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.service
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 30/04/2025
 * Time: 12:25
 * <p>
 */
public interface ICandidaturaService {
    Candidatura save(Candidatura candidatura);
    List<Candidatura> findAll();
    Optional<Candidatura> findById(Long id);
    void delete(Long id);


}
