package org.flow.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.pojo.PrivilegeResourceRelationship;
import org.flow.vo.PriRes;

@Mapper
public interface PrivilegeResourceRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrivilegeResourceRelationship record);

    PrivilegeResourceRelationship selectByPrimaryKey(Long id);

    List<PrivilegeResourceRelationship> selectAll();

    int updateByPrimaryKey(PrivilegeResourceRelationship record);

    List<PriRes> selectRelPager(@Param("params") Map<String, Object> params);

    int selectByWhereCount(@Param("params") Map<String, Object> params);

}