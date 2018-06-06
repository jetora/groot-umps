package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.pojo.PrivilegeResourceRelationship;
@Mapper
public interface PrivilegeResourceRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrivilegeResourceRelationship record);

    PrivilegeResourceRelationship selectByPrimaryKey(Long id);

    List<PrivilegeResourceRelationship> selectAll();

    int updateByPrimaryKey(PrivilegeResourceRelationship record);
}