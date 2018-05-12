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
}
