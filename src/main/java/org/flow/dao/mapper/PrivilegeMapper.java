package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.Privilege;
@Mapper
public interface PrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Privilege record);

    Privilege selectByPrimaryKey(Long id);

    List<Privilege> selectAll();

    int updateByPrimaryKey(Privilege record);
}