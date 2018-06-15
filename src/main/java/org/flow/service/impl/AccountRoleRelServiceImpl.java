package org.flow.service.impl;

import org.flow.bo.AccRoleBo;
import org.flow.dao.mapper.AccountRoleRelationshipMapper;
import org.flow.dao.mapper.RoleMapper;
import org.flow.dto.AccountRoleDTO;
import org.flow.pojo.Account;
import org.flow.pojo.AccountRoleRelationship;
import org.flow.service.AccountRoleRelService;
import org.flow.utils.common.utils.StringUtils;
import org.flow.vo.AccRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("accountRoleRelService")
@Transactional
public class AccountRoleRelServiceImpl implements AccountRoleRelService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AccountRoleRelationshipMapper accountRoleRelationshipMapper;
    @Resource
    private RoleMapper roleMapper;

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
    public int createAccountRoleRel(AccRole accRole) {
        List<Long> accountids = new ArrayList<>();
        List<Long> roleids = new ArrayList<>();
        accountids = accRole.getAccountids();
        roleids = accRole.getRoleids();
        List<AccRoleBo> accList = new ArrayList<>();

        List<Map<String,Long>> ids = new ArrayList<>();
        int result = 0 ;

        if (accountids.size() != 0 && roleids.size() != 0) {
            for (Long aid : accountids){
                AccRoleBo accRoleBo = new AccRoleBo();
                accRoleBo.setAccountId(aid);
                accRoleBo.setRoleIds(roleids);
                accList.add(accRoleBo);
                //accountRoleRelationshipMapper.insertRel(accRoleBo);
            }
            try{
                result = accountRoleRelationshipMapper.insertRelBatch(accList);
            }catch (Exception ex){
                logger.info("record exist...",ex);
                return 0;
            }

        }
        return result;
    }

    @Override
    public int updateAccountRoleRel(AccRole accRole) {
        //return accountRoleRelationshipMapper.updateByPrimaryKey(account);
        List<Long> accountids = new ArrayList<>();
        List<Long> roleids = new ArrayList<>();
        accountids = accRole.getAccountids();
        roleids = accRole.getRoleids();
        List<AccRoleBo> accList = new ArrayList<>();
        int result = 0;
        if (accountids.size() != 0 && roleids.size() != 0) {
            for (Long aid : accountids){
                AccRoleBo accRoleBo = new AccRoleBo();
                accRoleBo.setAccountId(aid);
                accRoleBo.setRoleIds(roleids);
                accList.add(accRoleBo);
            }
            result = accountRoleRelationshipMapper.updateRelBatch(accList);
        }
        return result;
    }

    @Override
    public int deleteAccountRoleRelById(Long id) {
        return accountRoleRelationshipMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AccRole> findRelAll() {
        return accountRoleRelationshipMapper.selectRelAll();
    }

    @Override
    public List<AccRole> findRelPager(Map params) {
        return accountRoleRelationshipMapper.selectRelPager(params);
    }

    @Override
    public int findWhereTotal(Map params) {
        return accountRoleRelationshipMapper.selectByWhereCount(params);
    }

    @Override
    public List<AccountRoleDTO> findGrantRole(Long id) {

        List<AccountRoleDTO> accountRoleDTOList = new ArrayList<>();
        List<AccountRoleRelationship> accountRoleRelationshipList = new ArrayList<>();
        accountRoleRelationshipList = accountRoleRelationshipMapper.selectByAccountId(id);
        List<Long> roleids = new ArrayList<>();
        if (accountRoleRelationshipList.size()!=0){
            for (AccountRoleRelationship accountRoleRelationship : accountRoleRelationshipList){
                roleids.add(accountRoleRelationship.getRoleId());
            }
        }
        if (roleids.size() != 0) {
            accountRoleDTOList = roleMapper.selectRoleByAccountIds(roleids);
        }
        return accountRoleDTOList;
    }

    @Override
    public List<AccountRoleRelationship> findBothIdExist(Map params) {
        return accountRoleRelationshipMapper.selectBothId(params);
    }
}
