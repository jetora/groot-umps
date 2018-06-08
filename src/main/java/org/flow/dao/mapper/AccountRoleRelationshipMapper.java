package org.flow.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.pojo.AccountRoleRelationship;
import org.flow.vo.AccRole;

@Mapper
public interface AccountRoleRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountRoleRelationship record);

    AccountRoleRelationship selectByPrimaryKey(Long id);

    List<AccountRoleRelationship> selectByAccountId(Long id);
    List<Long> selectByAccountIds(List<Long> accountids);

    List<AccountRoleRelationship> selectByRoleId(Long id);

    List<AccountRoleRelationship> selectAll();
    List<AccRole> selectRelAll();

    int updateByPrimaryKey(AccountRoleRelationship record);

    List<AccRole> selectRelPager(@Param("params") Map<String, Object> params);
}