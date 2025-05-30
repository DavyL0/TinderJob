package com.dlopes.tinderjob.infra.security;

import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.infra.security
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 02/05/2025
 * Time: 01:08
 * <p>
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
