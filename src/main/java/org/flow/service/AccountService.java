package org.flow.service;

import org.flow.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountAll();
    Account findAccountById(Long id);
    Account findAccountByName(String name);
    int createAccount(Account account);
    int updateAccountById(Account account);
    int deleteAccountById(Long id);
}
