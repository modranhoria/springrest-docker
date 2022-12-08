package com.unitbv.pst.springrest.service;

import com.unitbv.pst.springrest.entity.Authority;
import com.unitbv.pst.springrest.entity.User;
import com.unitbv.pst.springrest.repository.AuthorityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public List<Authority> getAllUsers() {
        return authorityRepository.findAll();
    }

    public Authority getUser(Integer id) {
        return authorityRepository.findById(id).get();
    }

    public Authority createUser(Authority authority) {
        User user = authority.getUser();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return authorityRepository.save(authority);
    }

    public void deleteUser(Integer id) {
        authorityRepository.deleteById(id);
    }
}
