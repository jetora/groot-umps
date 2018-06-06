package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.pojo.Resource;

@Mapper
public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    List<Resource> selectAll();

    List<Resource> selectMenuAll();

    int updateByPrimaryKey(Resource record);

    int selectCount();

    List<Resource> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize, @Param("ordername") String ordername, @Param("order") String order, @Param("resource_name") String resource_name,@Param("resource_type") int resource_type, @Param("enabled") int enabled);

    int selectByWhereCount(@Param("ordername") String ordername,@Param("order") String order,@Param("resource_name") String resource_name,@Param("resource_type") int resource_type,@Param("enabled") int enabled);
}