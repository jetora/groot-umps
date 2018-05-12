package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.AccountRoleRelationship;
@Mapper
public interface AccountRoleRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountRoleRelationship record);

    AccountRoleRelationship selectByPrimaryKey(Long id);

    List<AccountRoleRelationship> selectAll();

    int updateByPrimaryKey(AccountRoleRelationship record);
}