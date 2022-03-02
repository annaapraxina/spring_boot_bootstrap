package com.example.spring_boot_bootstrap.service;

import com.example.spring_boot_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Long id);

    Role getRoleByUsername(String username);

    List<Role> getAllRoles();

    Set<Role> getRoleById(List<Long> rolesId);
}
