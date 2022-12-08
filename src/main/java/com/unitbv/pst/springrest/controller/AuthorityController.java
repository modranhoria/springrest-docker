package com.unitbv.pst.springrest.controller;

import com.unitbv.pst.springrest.entity.Authority;
import com.unitbv.pst.springrest.service.AuthorityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthorityController {
    private AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping
    public List<Authority> getAllUsers(){
        return authorityService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Authority getUser(@PathVariable("id") Integer id) {
        return authorityService.getUser(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Authority createUser(@RequestBody Authority authority) {
        return authorityService.createUser(authority);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable("id") Integer id) {
        authorityService.deleteUser(id);
    }
}
