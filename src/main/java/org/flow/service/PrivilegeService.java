package org.flow.service;


import org.flow.pojo.Privilege;

import java.util.List;

public interface PrivilegeService {
    List<Privilege> findPrivilegeAll();
    List<Privilege> findPrivilegeAll(int offset, int pageSize,String ordername,String order,String privilegename,int enabled);
    int findWhereTotal(String ordername,String order,String privilegename,int enabled);
    int findTotal();
    Privilege findPrivilegeById(Long id);
    int createPrivilege(Privilege privilege);
    int updatePrivilegeById(Privilege privilege);
    int deletePrivilegeById(Long id);

}
