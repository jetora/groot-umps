package org.flow.service.impl;

import org.flow.dao.mapper.OrganizationMapper;
import org.flow.pojo.OrganizationTree;
import org.flow.pojo.Organization;
import org.flow.service.OrganizationService;
import org.flow.utils.common.utils.TreeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public List<Organization> findOrganizationAll() {
        return organizationMapper.selectAll();
    }

    @Override
    public Organization findOrganizationById(Long id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createOrganization(Organization organization) {
        return organizationMapper.insert(organization);
    }

    @Override
    public int updateOrganizationById(Organization organization) {
        return organizationMapper.updateByPrimaryKey(organization);
    }

    @Override
    public int deleteOrganizationById(Long id) {
        return organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrganizationTree> selectOrganiationTree(Long id){
        List<Organization> organizations = organizationMapper.selectAll();
        return this.getOraganizationTree(organizations,id);
    }

    @Override
    public List<Organization> findOrganizationAll(int offset, int pageSize, String ordername, String order, String search_org_name, Long search_org_id, int enabled) {
        return organizationMapper.selectByPager(offset,pageSize,ordername,order,search_org_name,search_org_id,enabled);
    }

    @Override
    public int findWhereTotal(String ordername, String order, String search_org_name, Long search_org_id, int enabled) {
        return organizationMapper.selectByWhereCount(ordername,order,search_org_name,search_org_id,enabled);
    }

    @Override
    public int findTotal() {
            return organizationMapper.selectCount();
    }

    /**
     * 构建组织机构树
     *
     * @param organizations 组织机构
     * @param root  根节点
     * @return
     */
    private List<OrganizationTree> getOraganizationTree(List<Organization> organizations, Long root){
        //Long newroot = new Long((long)root);
        List<OrganizationTree> trees = new ArrayList<>();
        OrganizationTree node;
        for (Organization ora:organizations){
            //if (ora.getParentId().equals(ora.getId())){
            //    continue;
            //}
            node = new OrganizationTree();
            node.setId(ora.getOrganizationId());
            node.setParentId(ora.getParentId());
            node.setName(ora.getName());
            trees.add(node);
        }
        return TreeUtil.buildByRecursive(trees,root);
    }

}
