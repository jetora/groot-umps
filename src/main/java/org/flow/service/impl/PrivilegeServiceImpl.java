package org.flow.service.impl;

import org.flow.dao.mapper.PrivilegeMapper;
import org.flow.pojo.Privilege;
import org.flow.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("privilegeService")
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findPrivilegeAll() {
        return privilegeMapper.selectAll();
    }

    @Override
    public List<Privilege> findPrivilegeAll(int offset, int pageSize, String ordername, String order, String privilegename, int enabled) {
        return privilegeMapper.selectByPager(offset,pageSize,ordername,order,privilegename,enabled);
    }

    @Override
    public int findWhereTotal(String ordername, String order, String privilegename, int enabled) {
        return privilegeMapper.selectByWhereCount(ordername,order,privilegename,enabled);
    }

    @Override
    public int findTotal() {
        return privilegeMapper.selectCount();
    }

    @Override
    public Privilege findPrivilegeById(Long id) {
        return privilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createPrivilege(Privilege privilege) {
        return privilegeMapper.insert(privilege);
    }

    @Override
    public int updatePrivilegeById(Privilege privilege) {
        return privilegeMapper.updateByPrimaryKey(privilege);
    }

    @Override
    public int deletePrivilegeById(Long id) {
        return privilegeMapper.deleteByPrimaryKey(id);
    }

}
