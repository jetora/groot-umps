package org.flow.service.impl;

import org.flow.dao.mapper.AccountRoleRelationshipMapper;
import org.flow.pojo.AccountRoleRelationship;
import org.flow.service.AccountRoleRelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("accountRoleRelService")
@Transactional
public class AccountRoleRelServiceImpl implements AccountRoleRelService {

    @Resource
    private AccountRoleRelationshipMapper accountRoleRelationshipMapper;

    @Override
    public List<AccountRoleRelationship> findAccountRoleRelAll() {
        return accountRoleRelationshipMapper.selectAll();
    }

    @Override
    public AccountRoleRelationship findAccountRoleRelById(Long id) {
        return accountRoleRelationshipMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AccountRoleRelationship> findAccountRoleRelByAccountId(Long id) {
        return accountRoleRelationshipMapper.selectByAccountId(id);
    }

    @Override
    public int createAccountRoleRel(AccountRoleRelationship account) {
        return accountRoleRelationshipMapper.insert(account);
    }

    @Override
    public int updateAccountRoleRelById(AccountRoleRelationship account) {
        return accountRoleRelationshipMapper.updateByPrimaryKey(account);
    }

    @Override
    public int deleteAccountRoleRelById(Long id) {
        return accountRoleRelationshipMapper.deleteByPrimaryKey(id);
    }
}
