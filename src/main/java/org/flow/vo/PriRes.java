package org.flow.vo;

import org.flow.pojo.PrivilegeResourceRelationship;

import java.util.List;

public class PriRes extends PrivilegeResourceRelationship {
    private static final long serialVersionUID = 2469035195844998742L;
    private String privilegename;
    private String resourcename;
    private List<Long> privilegeids;
    private List<Long> resourceids;

    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public List<Long> getPrivilegeids() {
        return privilegeids;
    }

    public void setPrivilegeids(List<Long> privilegeids) {
        this.privilegeids = privilegeids;
    }

    public List<Long> getResourceids() {
        return resourceids;
    }

    public void setResourceids(List<Long> resourceids) {
        this.resourceids = resourceids;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", privilegeId=").append(super.getPrivilegeId());
        sb.append(", privilegename=").append(getPrivilegename());
        sb.append(", resourceId=").append(super.getResourceId());
        sb.append(", resourcename=").append(getResourcename());
        sb.append(", privilegeids=").append(getPrivilegeids());
        sb.append(", resourceids=").append(getResourceids());
        sb.append(", enabled=").append(super.getEnabled());
        sb.append(", createTime=").append(super.getCreateTime());
        sb.append(", updateTime=").append(super.getUpdateTime());
        sb.append("]");
        return sb.toString();
    }
}
