package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.dto.CandidatoDTO;
import com.dlopes.tinderjob.dto.VagaCandidatosDTO;
import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.model.Vaga;
import com.dlopes.tinderjob.repository.UsersRepository;
import com.dlopes.tinderjob.repository.VagasRepository;
import com.dlopes.tinderjob.service.VagasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.controller
 * <p>
 * User: Davy Lopes
 * Email: davylopes866@gmail.com
 * Date: 29/04/2025
 * Time: 23:00
 * <p>
 */
@RestController
@RequestMapping("/vagas")
public class VagasController {

    @Autowired
    private VagasService vagaService;
    @Autowired
    private VagasRepository vagasRepository;
    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/listar")
    public ResponseEntity<List<Vaga>> findAll() {
        return ResponseEntity.ok(vagaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vaga>> findById(@PathVariable String id) {
        return ResponseEntity.ok(vagaService.findVagasById(Long.valueOf(id)));
    }

    @GetMapping("/vagas-com-candidatos")
    public ResponseEntity<List<VagaCandidatosDTO>> getVagasComCandidatos() {
        List<Vaga> vagas = vagasRepository.findAll(); // Pega todas as vagas

        // Converte as vagas para um DTO que inclui os candidatos
        List<VagaCandidatosDTO> vagasComCandidatos = vagas.stream().map(vaga -> {
            VagaCandidatosDTO vagaDTO = new VagaCandidatosDTO();
            vagaDTO.setVagaId(vaga.getId());
            vagaDTO.setVagaNome(vaga.getNome());
            vagaDTO.setCandidatos(vaga.getUsers().stream()
                    .map(user -> new CandidatoDTO(user.getId(), user.getUsername(), user.getEmail()))  // Cria a lista de candidatos
                    .collect(Collectors.toList()));
            return vagaDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(vagasComCandidatos);
    }



    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Vaga vaga, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.saveVagas(vaga));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid Vaga vaga, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(vagaService.saveVagas(vaga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vagaService.deleteVagasById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/candidatar")
    public ResponseEntity<?> candidatar(@PathVariable Long id, @AuthenticationPrincipal User user) {
        var vaga = vagasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Recarrega o usuário diretamente do banco
        var usuario = usersRepository.findById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        usuario.getVagas().add(vaga);
        usersRepository.save(usuario); // Agora sim, persistência correta

        return ResponseEntity.ok(Map.of("message", "Candidatura realizada com sucesso."));

    }


}
