package com.example.userservice.service;

import com.example.userservice.model.Role;

public interface RoleService {
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
