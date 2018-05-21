package org.flow.service.impl;

import org.flow.dao.mapper.ResourceMapper;
import org.flow.entity.Resource;
import org.flow.entity.ResourceTree;
import org.flow.service.ResourceService;
import org.flow.utils.common.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    ResourceMapper resourceMapper;

    @Override
    public List<Resource> findResourceAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public Resource findResourceById(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createResource(Resource resource) {
        return resourceMapper.insert(resource);
    }

    @Override
    public int updateResourceById(Resource resource) {
        return resourceMapper.updateByPrimaryKey(resource);
    }

    @Override
    public int deleteResourceById(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ResourceTree> selecteResourceTree(Long id) {
        List<Resource> resources = resourceMapper.selectAll();
        return this.getOraganizationTree(resources,id);
    }

    @Override
    public List<ResourceTree> selecteMenuTree(Long id) {
        List<Resource> resources = resourceMapper.selectMenuAll();
        return this.getOraganizationTree(resources,id);
    }

    /**
     * 构建资源树
     *
     * @param resources 资源
     * @param root  根节点
     * @return
     */
    private List<ResourceTree> getOraganizationTree(List<Resource> resources, Long root){
        //Long newroot = new Long((long)root);
        List<ResourceTree> trees = new ArrayList<>();
        ResourceTree node;
        for (Resource res:resources){
            //if (ora.getParentId().equals(ora.getId())){
            //    continue;
            //}
            node = new ResourceTree();
            node.setId(res.getId());
            node.setParentId(res.getParentId());
            node.setName(res.getName());
            node.setPermission(res.getPermission());
            node.setType(res.getType());
            trees.add(node);
        }
        return TreeUtil.buildByRecursive(trees,root);
    }
}
