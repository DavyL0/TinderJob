package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.model.Users;
import com.dlopes.tinderjob.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.controller
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 29/04/2025
 * Time: 22:59
 * <p>
 */
@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    private ResponseEntity<Object> create(@RequestBody Users users,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
    }


    @PutMapping("/modificar")
    public ResponseEntity<Object> update(@RequestBody @Valid Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(usersService.save(users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
