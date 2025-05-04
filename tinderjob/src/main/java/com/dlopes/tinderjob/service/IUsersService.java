package com.dlopes.tinderjob.service;

import com.dlopes.tinderjob.model.User;

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
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User update(User users);
    void deleteById(Long id);


}
