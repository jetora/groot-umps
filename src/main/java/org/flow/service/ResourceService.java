package org.flow.service;

import org.flow.entity.Resource;
import org.flow.entity.ResourceTree;

import java.util.List;

public interface ResourceService {
    List<Resource> findResourceAll();
    Resource findResourceById(Long id);
    int createResource(Resource resource);
    int updateResourceById(Resource resource);
    int deleteResourceById(Long id);
    List<ResourceTree> selecteResourceTree(Long id);
    List<ResourceTree> selecteMenuTree(Long id);
}
