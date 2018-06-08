package org.flow.service;

import org.flow.pojo.AccountRoleRelationship;
import org.flow.vo.AccRole;

import java.util.List;
import java.util.Map;

public interface AccountRoleRelService {
    List<AccountRoleRelationship> findAccountRoleRelAll();
    AccountRoleRelationship findAccountRoleRelById(Long id);
    List<AccountRoleRelationship> findAccountRoleRelByAccountId(Long id);
    int createAccountRoleRel(AccountRoleRelationship account);
    int updateAccountRoleRelById(AccountRoleRelationship account);
    int deleteAccountRoleRelById(Long id);
    List<AccRole> findRelAll();
    List<AccRole> findRelPager(Map params);
}
