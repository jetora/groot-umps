package org.flow.service.impl;

import org.flow.dao.mapper.AccountMapper;
import org.flow.dao.mapper.AccountRoleRelationshipMapper;
import org.flow.dao.mapper.RoleMapper;
import org.flow.pojo.Account;
import org.flow.pojo.AccountRoleRelationship;
import org.flow.pojo.Role;
import org.flow.service.AccountService;
import org.flow.utils.common.utils.BeanUtils;
import org.flow.vo.AccountVO;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private AccountRoleRelationshipMapper accountRoleRelationshipMapper;

    @Override
    public List<Account> findAccountAll() {
        return accountMapper.selectAll();
    }

    /*
    @Override
    public List<Account> findAccountAll(int offset, int pageSize,String ordername,String order,String username,int enabled) {
        //return accountMapper.selectByPager(offset,pageSize,ordername,order,username,enabled);
        List<Account> accountList = accountMapper.selectByPager(offset,pageSize,ordername,order,username,enabled);
        List<AccountVO> accountVOS=BeanUtils.copyList(accountList,AccountVO.class);


        for (AccountVO accountVO : accountVOS){
            List<AccountRoleRelService> accountRoleRelationshipList = null;
            Role role = null;
            List<Role> roles = new ArrayList<>();
            accountRoleRelationshipList = accountRoleRelationshipMapper.selectByAccountId(accountVO.getId());
            for (AccountRoleRelService accountRoleRelationship : accountRoleRelationshipList){
                role = roleMapper.selectByPrimaryKey(accountRoleRelationship.getRoleId());
                if (null!=role){
                    roles.add(role);
                }
            }
            accountVO.setRoles(roles);
        }

        return accountList;
    }
    */
    @Override
    public List<Account> findAccountAll(int offset, int pageSize,String ordername,String order,String username,int enabled) {
        //return accountMapper.selectByPager(offset,pageSize,ordername,order,username,enabled);
        List<Account> accountList = accountMapper.selectByPager(offset,pageSize,ordername,order,username,enabled);
        /*
        List<AccountVO> accountVOS=BeanUtils.copyList(accountList,AccountVO.class);
        for (AccountVO accountVO : accountVOS){
            List<Long> accountids = new ArrayList<>();
            accountids.add(accountVO.getId());
            List<Long> roleids = new ArrayList<>();
            roleids = accountRoleRelationshipMapper.selectByAccountIds(accountids);
            List<Role> roleList = new ArrayList<>();
            if (roleids.size()!=0){
                roleList = roleMapper.selectByRoleIds(roleids);
            }
            accountVO.setRoles(roleList);
        }*/
        return accountList;
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
