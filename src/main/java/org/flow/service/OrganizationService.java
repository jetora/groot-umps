package org.flow.service;


import org.flow.entity.Organization;
import org.flow.entity.OrganizationTree;

import java.util.List;

public interface OrganizationService {
    List<Organization> findOrganizationAll();
    Organization findOrganizationById(Long id);
    int createOrganization(Organization organization);
    int updateOrganizationById(Organization organization);
    int deleteOrganizationById(Long id);
    List<OrganizationTree> selectOrganiationTree(Long id);

    List<Organization> findOrganizationAll(int offset, int pageSize,String ordername,String order,String search_org_name,Long search_org_id,int enabled);
    int findWhereTotal(String ordername,String order,String search_org_name,Long search_org_id,int enabled);
    int findTotal();
}
