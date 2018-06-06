package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.pojo.RoleGroupRelationship;
@Mapper
public interface RoleGroupRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleGroupRelationship record);

    RoleGroupRelationship selectByPrimaryKey(Long id);

    List<RoleGroupRelationship> selectAll();

    int updateByPrimaryKey(RoleGroupRelationship record);
}