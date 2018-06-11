package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.dto.AccountRoleDTO;
import org.flow.pojo.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);
    List<Role> selectByRoleIds(List<Long> roleids);

    List<Role> selectAll();

    List<Role> selectByRelAccountId(Long id);

    int updateByPrimaryKey(Role record);

    List<Role> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize, @Param("ordername") String ordername, @Param("order") String order, @Param("rolename") String rolename, @Param("enabled") int enabled);

    int selectByWhereCount(@Param("ordername") String ordername,@Param("order") String order,@Param("rolename") String rolename,@Param("enabled") int enabled);

    int selectCount();

    List<AccountRoleDTO> selectRoleByAccountIds(List<Long> roleids);
}