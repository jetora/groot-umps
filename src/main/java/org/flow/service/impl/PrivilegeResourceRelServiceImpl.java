package org.flow.service.impl;

import org.flow.dao.mapper.PrivilegeResourceRelationshipMapper;
import org.flow.service.PrivilegeResourceRelService;
import org.flow.vo.PriRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("privilegeResourceRelService")
@Transactional
public class PrivilegeResourceRelServiceImpl implements PrivilegeResourceRelService {
    @Resource
    private PrivilegeResourceRelationshipMapper privilegeResourceRelationshipMapper;

    @Override
    public List<PriRes> findRelPager(Map params) {
        return privilegeResourceRelationshipMapper.selectRelPager(params);
    }

    @Override
    public int findWhereTotal(Map params) {
        return privilegeResourceRelationshipMapper.selectByWhereCount(params);
    }
}
