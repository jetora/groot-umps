package org.flow.vo;

import org.flow.pojo.Role;

public class RoleVO extends Role {
    private static final long serialVersionUID = -2382317178261376734L;
    private String ordername;
    private String order;
    private int pageSize;
    private int offset;


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

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", name=").append(super.getName());
        sb.append(", description=").append(super.getDescription());
        sb.append(", enabled=").append(super.getEnabled());
        sb.append(", createTime=").append(super.getCreateTime());
        sb.append(", updateTime=").append(super.getUpdateTime());
        sb.append(", ordername=").append(ordername);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", offset=").append(offset);
        sb.append("]");
        return sb.toString();
    }
}
