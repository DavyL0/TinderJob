package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.model.Vagas;
import com.dlopes.tinderjob.service.VagasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping("/api/vagas")
public class VagasController {

    @Autowired
    private VagasService vagaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Vagas>> findAll() {
        return ResponseEntity.ok(vagaService.findAll());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<Vagas>> findById(@PathVariable String id) {
        return ResponseEntity.ok(vagaService.findVagasById(Long.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Vagas vaga, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Se houver erros de validação, retornamos 400 com as mensagens de erro
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        // Se não houver erros, salva a vaga
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.saveVagas(vaga));
    }

    @PutMapping("/modificar")
    public ResponseEntity<Object> update(@RequestBody @Valid Vagas vaga, BindingResult bindingResult) {
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
}
