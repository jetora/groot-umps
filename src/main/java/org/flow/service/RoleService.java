package org.flow.service;

import org.flow.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRoleAll();
    List<Role> findRoleAll(int pageNum, int pageSize,String ordername,String order,String rolename,int enabled);
    int findWhereTotal(String ordername,String order,String rolename,int enabled);
    int findTotal();
    Role findRoleById(Long id);
    int createRole(Role role);
    int updateRoleById(Role role);
    int deleteRoleById(Long id);
    List<Role> findRelByAccountId(Long id);
}
