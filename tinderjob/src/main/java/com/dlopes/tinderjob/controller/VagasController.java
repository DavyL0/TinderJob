package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.model.Vaga;
import com.dlopes.tinderjob.repository.UsersRepository;
import com.dlopes.tinderjob.repository.VagasRepository;
import com.dlopes.tinderjob.service.VagasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    private VagasRepository vagaRepository;

    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Vaga>> findAll() {
        return ResponseEntity.ok(vagaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vaga>> findById(@PathVariable String id) {
        return ResponseEntity.ok(vagaService.findVagasById(Long.valueOf(id)));
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

    @PutMapping("/{vagaId}/candidatar/{userId}")
    public ResponseEntity<?> candidatarUsuario(@PathVariable Long vagaId, @PathVariable Long userId) {
        Optional<Vaga> vagaOpt = vagaRepository.findById(vagaId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (vagaOpt.isEmpty() || userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vaga vaga = vagaOpt.get();
        User user = userOpt.get();

        vaga.getUsers().add(user);
        vagaRepository.save(vaga);

        return ResponseEntity.ok().build();
    }
}
