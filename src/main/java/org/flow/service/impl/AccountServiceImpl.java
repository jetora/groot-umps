package org.flow.service.impl;

import com.github.pagehelper.PageHelper;
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
    public List<Account> findAccountAll(int offset, int pageSize) {
        //使用分页插件,核心代码就这一行
        //PageHelper.startPage(pageNum, pageSize);
        return accountMapper.selectByPager(offset,pageSize);
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
}
