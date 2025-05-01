package com.dlopes.tinderjob.controller;
import com.dlopes.tinderjob.model.Candidatura;
import com.dlopes.tinderjob.service.CandidaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.controller
 * <p>
 * User: Davy Lopes
 * Email: davylopes866@gmail.com
 * Date: 30/04/2025
 Java
 */

@RestController
@RequestMapping( "/api/candidatura")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Candidatura>> findAll() {
        return ResponseEntity.ok(candidaturaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Candidatura candidatura, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(candidaturaService.save(candidatura));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        candidaturaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
