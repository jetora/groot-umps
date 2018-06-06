package org.flow.service;

import org.flow.pojo.AccountRoleRelationship;

import java.util.List;

public interface AccountRoleRelService {
    List<AccountRoleRelationship> findAccountRoleRelAll();
    AccountRoleRelationship findAccountRoleRelById(Long id);
    List<AccountRoleRelationship> findAccountRoleRelByAccountId(Long id);
    int createAccountRoleRel(AccountRoleRelationship account);
    int updateAccountRoleRelById(AccountRoleRelationship account);
    int deleteAccountRoleRelById(Long id);
}
