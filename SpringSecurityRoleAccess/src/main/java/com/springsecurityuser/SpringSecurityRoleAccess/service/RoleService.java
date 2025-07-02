package com.springsecurityuser.SpringSecurityRoleAccess.service;

import com.springsecurityuser.SpringSecurityRoleAccess.model.Role;
import com.springsecurityuser.SpringSecurityRoleAccess.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
