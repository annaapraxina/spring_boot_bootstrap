package com.example.spring_boot_bootstrap.service;



import com.example.spring_boot_bootstrap.model.Role;
import com.example.spring_boot_bootstrap.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void addUser(User user, Set<Role> roles);

    void updateUser(User user, Long id, Set<Role> roles);

    void removeUserById(Long id);

    User getUserByUsername(String username);

    User getUserById(Long id);

    List<User> getAllUsers();

}
