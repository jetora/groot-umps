package org.flow.service;

import org.flow.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountAll();
    List<Account> findAccountAll(int offset, int pageSize,String ordername,String order,String username,int enabled);
    int findWhereTotal(String ordername,String order,String username,int enabled);
    int findTotal();
    Account findAccountById(Long id);
    Account findAccountByName(String name);
    int createAccount(Account account);
    int updateAccountById(Account account);
    int deleteAccountById(Long id);
    int updateAccountEnabledById(Account account);
}
