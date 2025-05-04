package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.dto.UserUpdateDTO;
import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.model.Vaga;
import com.dlopes.tinderjob.repository.UsersRepository;
import com.dlopes.tinderjob.repository.VagasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private VagasRepository vagasRepository;

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
    public User updateUser(String email, UserUpdateDTO userUpdateDTO) {
        User user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Atualiza apenas campos não nulos
        if (userUpdateDTO.getAdmin() != null) {
            user.setAdmin(userUpdateDTO.getAdmin());
        }
        if (userUpdateDTO.getDescription() != null) {
            user.setDescription(userUpdateDTO.getDescription());
        }
        if (userUpdateDTO.getPassword() != null) {
            user.setPassword(userUpdateDTO.getPassword());
        }
        if (userUpdateDTO.getUsername() != null) {
            user.setUsername(userUpdateDTO.getUsername());
        }
        if (userUpdateDTO.getVaga_id() != null) {
            Vaga vaga = vagasRepository.findById(userUpdateDTO.getVaga_id())
                    .orElseThrow(() -> new EntityNotFoundException("Vaga não encontrada"));
            user.setVaga(vaga);
        }

        return usersRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public User update(User users) {
        return usersRepository.save(users);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

}
