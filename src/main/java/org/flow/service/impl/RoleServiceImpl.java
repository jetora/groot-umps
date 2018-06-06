package org.flow.service.impl;

import org.flow.dao.mapper.RoleMapper;
import org.flow.pojo.Role;
import org.flow.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public List<Role> findRoleAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> findAccountAll(int offset, int pageSize, String ordername, String order, String rolename, int enabled) {
        return roleMapper.selectByPager(offset,pageSize,ordername,order,rolename,enabled);
    }

    @Override
    public int findWhereTotal(String ordername, String order, String rolename, int enabled) {
        return roleMapper.selectByWhereCount(ordername,order,rolename,enabled);
    }

    @Override
    public int findTotal() {
        return roleMapper.selectCount();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRoleById(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteRoleById(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
