package org.flow.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.flow.entity.Account;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    Account selectByPrimaryKey(Long id);

    Account selectByUsername(String username);

    List<Account> selectAll();

    //List<Account> selectByPager(int pageNum, int pageSize);

    List<Account> selectByPager(@Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(Account record);
}