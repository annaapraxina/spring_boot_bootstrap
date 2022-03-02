package com.example.spring_boot_bootstrap.dao;

import com.example.spring_boot_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Long id);

    Role getRoleByUsername(String role);

    List<Role> getAllRoles();

    Set<Role> getRoleById(List<Long> rolesId);
}
