package org.flow.vo;

import org.flow.pojo.AccountRoleRelationship;

import java.util.List;

public class AccRole extends AccountRoleRelationship {

    private static final long serialVersionUID = -3476677412549457836L;
    private String username;
    private String rolename;
    private List<Long> accountids;
    private List<Long> roleids;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Long> getAccountids() {
        return accountids;
    }

    public void setAccountids(List<Long> accountids) {
        this.accountids = accountids;
    }

    public List<Long> getRoleids() {
        return roleids;
    }

    public void setRoleids(List<Long> roleids) {
        this.roleids = roleids;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", accountId=").append(super.getAccountId());
        sb.append(", username=").append(getUsername());
        sb.append(", roleId=").append(super.getRoleId());
        sb.append(", rolename=").append(getRolename());
        sb.append(", accountids=").append(getAccountids());
        sb.append(", roleids=").append(getRoleids());
        sb.append(", createTime=").append(super.getCreateTime());
        sb.append(", updateTime=").append(super.getUpdateTime());
        sb.append("]");
        return sb.toString();
    }
}
