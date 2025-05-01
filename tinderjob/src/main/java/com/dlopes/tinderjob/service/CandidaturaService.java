package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.Candidatura;
import com.dlopes.tinderjob.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.service
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 30/04/2025
 * Time: 12:28
 * <p>
 */
@Service
public class CandidaturaService implements ICandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Override
    public Candidatura save(Candidatura candidatura) {
        return candidaturaRepository.save(candidatura);
    }

    @Override
    public List<Candidatura> findAll() {
        return candidaturaRepository.findAll();
    }

    @Override
    public Optional<Candidatura> findById(Long id) {
        return candidaturaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        candidaturaRepository.deleteById(id);
    }
}
