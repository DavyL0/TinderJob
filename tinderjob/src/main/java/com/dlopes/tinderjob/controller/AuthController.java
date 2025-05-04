package com.dlopes.tinderjob.controller;

import com.dlopes.tinderjob.dto.LoginRequestDTO;
import com.dlopes.tinderjob.dto.RegisterRequestDTO;
import com.dlopes.tinderjob.dto.ResponseDTO;
import com.dlopes.tinderjob.infra.security.TokenService;
import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.controller
 * <p>
 * User: Davy Lopes
 * Email: davylopes866@gmail.com
 * Date: 02/05/2025
 * Time: 01:25
 * <p>
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final TokenService tokenService;

    public AuthController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.usersRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getId(), user.getUsername(), token, user.isAdmin()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        if (usersRepository.findByEmail(body.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        User newUser = new User();
        newUser.setUsername(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setAdmin(body.admin());

        User savedUser = usersRepository.save(newUser);

        String token = tokenService.generateToken(savedUser);
        return ResponseEntity.ok(new ResponseDTO(savedUser.getId(), savedUser.getUsername(), token, savedUser.isAdmin()));
    }
}
