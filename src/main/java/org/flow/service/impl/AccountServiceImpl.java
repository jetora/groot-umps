package org.flow.service.impl;

import org.flow.dao.mapper.AccountMapper;
import org.flow.entity.Account;
import org.flow.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAccountAll() {
        return accountMapper.selectAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createAccount(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int updateAccountById(Account account) {
        return accountMapper.updateByPrimaryKey(account);
    }

    @Override
    public int deleteAccountById(Long id) {
        return accountMapper.deleteByPrimaryKey(id);
    }
}
