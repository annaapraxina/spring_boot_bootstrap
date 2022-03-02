package com.example.spring_boot_bootstrap.controller;


import com.example.spring_boot_bootstrap.model.Role;
import com.example.spring_boot_bootstrap.model.User;
import com.example.spring_boot_bootstrap.service.RoleService;
import com.example.spring_boot_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String userPage(@CurrentSecurityContext(expression = "authentication.principal") User user,
                           Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user";
    }

    @GetMapping(value = "/admin")
    public String adminPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping(value = "/admin/edit")
    public String editUser(@ModelAttribute User user, @RequestParam("updId") Long id, @RequestParam("rolesId") List<Long> rolesId) {
        Set<Role> roles = roleService.getRoleById(rolesId);
        userService.updateUser(user, id, roles);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/add")
    public String addNewUser(@ModelAttribute User user, @RequestParam("rolesId") List<Long> rolesId) {
        Set<Role> roles = roleService.getRoleById(rolesId);
        userService.addUser(user, roles);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/remove")
    public String removeUser(@RequestParam("delId") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

}