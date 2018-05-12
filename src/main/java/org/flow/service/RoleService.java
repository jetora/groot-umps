package org.flow.service;

import org.flow.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRoleAll();
    Role findRoleById(Long id);
    int createRole(Role role);
    int updateRoleById(Role role);
    int deleteRoleById(Long id);
}
