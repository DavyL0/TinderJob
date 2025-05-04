package com.dlopes.tinderjob.repository;

import com.dlopes.tinderjob.model.User;
import org.springframework.data.repository.CrudRepository;

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
public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
