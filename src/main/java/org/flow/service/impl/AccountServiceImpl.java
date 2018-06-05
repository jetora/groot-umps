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
    public List<Account> findAccountAll(int offset, int pageSize,String ordername,String order,String username,int enabled) {
        return accountMapper.selectByPager(offset,pageSize,ordername,order,username,enabled);
    }

    @Override
    public int findWhereTotal(String ordername, String order, String username, int enabled) {
        return accountMapper.selectByWhereCount(ordername,order,username,enabled);
    }

    @Override
    public int findTotal() {
        return accountMapper.selectCount();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountMapper.selectByUsername(name);
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

    @Override
    public int updateAccountEnabledById(Account account) {
        int result = 0;
        if (account.getEnabled()==1){
            result = accountMapper.updateDisabledByPrimaryKey(account);
        }else if (account.getEnabled()==2){
            result = accountMapper.updateEnabledByPrimaryKey(account);
        }
        return result;
    }
}
