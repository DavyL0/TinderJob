package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.Users;

import java.util.Optional;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.service
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 30/04/2025
 * Time: 00:06
 * <p>
 */
public interface IUsersService {
    Users save(Users users);
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);
    Users update(Users users);
    void deleteById(Long id);


}
