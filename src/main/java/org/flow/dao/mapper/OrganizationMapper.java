package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.entity.Organization;
import org.flow.entity.Resource;

@Mapper
public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    Organization selectByPrimaryKey(Long id);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);

    int selectCount();

    List<Organization> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize, @Param("ordername") String ordername, @Param("order") String order, @Param("search_org_name") String search_org_name, @Param("search_org_id") Long search_org_id, @Param("enabled") int enabled);

    int selectByWhereCount(@Param("ordername") String ordername,@Param("order") String order,@Param("search_org_name") String search_org_name,@Param("search_org_id") Long search_org_id,@Param("enabled") int enabled);
}