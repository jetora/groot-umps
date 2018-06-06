package org.flow.vo;

import org.flow.pojo.Account;
import org.flow.pojo.Role;

import java.util.List;

public class AccountVO extends Account {

    private static final long serialVersionUID = 3255086303798325228L;
    private String ordername;
    private String order;
    private int pageSize;
    private int offset;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", username=").append(super.getUsername());
        sb.append(", password=").append(super.getPassword());
        sb.append(", enabled=").append(super.getEnabled());
        sb.append(", createTime=").append(super.getCreateTime());
        sb.append(", updateTime=").append(super.getUpdateTime());
        sb.append(", ordername=").append(ordername);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", offset=").append(offset);
        sb.append(", roles=").append(roles);
        sb.append("]");
        return sb.toString();
    }
}
