package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.entity.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize, @Param("ordername") String ordername, @Param("order") String order, @Param("rolename") String rolename, @Param("enabled") int enabled);

    int selectByWhereCount(@Param("ordername") String ordername,@Param("order") String order,@Param("rolename") String rolename,@Param("enabled") int enabled);

    int selectCount();
}