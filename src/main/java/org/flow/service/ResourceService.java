package org.flow.service;

import org.flow.pojo.Resource;
import org.flow.pojo.ResourceTree;

import java.util.List;

public interface ResourceService {
    List<Resource> findResourceAll();
    List<Resource> findResourceAll(int offset, int pageSize,String ordername,String order,String resource_name,int resource_type,int enabled);
    int findWhereTotal(String ordername,String order,String resource_name,int resource_type,int enabled);
    int findTotal();
    Resource findResourceById(Long id);
    int createResource(Resource resource);
    int updateResourceById(Resource resource);
    int deleteResourceById(Long id);
    List<ResourceTree> selecteResourceTree(Long id);
    List<ResourceTree> selecteMenuTree(Long id);
}
