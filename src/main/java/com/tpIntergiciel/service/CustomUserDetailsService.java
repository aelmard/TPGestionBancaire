package com.tpIntergiciel.service;

import com.tpIntergiciel.model.CustomUserDetails;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.repository.UserRepository;
import com.tpIntergiciel.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a602259 on 19/12/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            System.out.println("No user present with username: " + username);
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            System.out.println("Successfully ! connected with username: " + username);
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }
}
