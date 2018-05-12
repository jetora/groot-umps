package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.RolePrivilegeRelationshp;
@Mapper
public interface RolePrivilegeRelationshpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePrivilegeRelationshp record);

    RolePrivilegeRelationshp selectByPrimaryKey(Long id);

    List<RolePrivilegeRelationshp> selectAll();

    int updateByPrimaryKey(RolePrivilegeRelationshp record);
}