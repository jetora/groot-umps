package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.pojo.AccountGroupRelationship;

@Mapper
public interface AccountGroupRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountGroupRelationship record);

    AccountGroupRelationship selectByPrimaryKey(Long id);

    List<AccountGroupRelationship> selectAll();

    int updateByPrimaryKey(AccountGroupRelationship record);
}