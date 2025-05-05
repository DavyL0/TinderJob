package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.Vaga;
import com.dlopes.tinderjob.repository.VagasRepository;
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
 * Date: 29/04/2025
 * Time: 22:58
 * <p>
 */
@Service
public class VagasService implements IVagasService {

    @Autowired
    private VagasRepository vagaRepository;

    @Override
    public Vaga saveVagas(Vaga vagas) {
        return vagaRepository.save(vagas);
    }

    @Override
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    @Override
    public Optional<Vaga> findVagasById(Long id) {
        return vagaRepository.findById(id);
    }

    @Override
    public void deleteVagasById(Long id) {
        vagaRepository.deleteById(id);
    }
}
