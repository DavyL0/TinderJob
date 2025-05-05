package com.dlopes.tinderjob.repository;

import com.dlopes.tinderjob.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Project: tinderjob2
 * Package: com.dlopes.tinderjob.repository
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 29/04/2025
 * Time: 22:43
 * <p>
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
}
