package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}