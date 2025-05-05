package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.dto.UserUpdateDTO;
import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

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
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUsuarioLogado(@AuthenticationPrincipal User usuario) {
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(usuario);
    }



    @PostMapping
    public ResponseEntity<Object> create(@RequestBody User users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
    }


    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(
            @PathVariable String email,
            @RequestBody UserUpdateDTO userUpdateDTO) {

        User updatedUser = usersService.updateUser(email, userUpdateDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
