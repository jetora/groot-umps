package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.flow.entity.Privilege;
@Mapper
public interface PrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Privilege record);

    Privilege selectByPrimaryKey(Long id);

    List<Privilege> selectAll();

    int updateByPrimaryKey(Privilege record);

    int selectCount();

    List<Privilege> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize, @Param("ordername") String ordername, @Param("order") String order, @Param("privilegename") String privilegename, @Param("enabled") int enabled);

    int selectByWhereCount(@Param("ordername") String ordername,@Param("order") String order,@Param("privilegename") String privilegename,@Param("enabled") int enabled);

}