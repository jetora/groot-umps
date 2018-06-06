package org.flow.vo;

import org.flow.pojo.Resource;

import java.io.Serializable;

public class ResourceVO  extends Resource {
    private static final long serialVersionUID = -4448563450774575297L;
    private String ordername;
    private String order;
    private int pageSize;
    private int offset;

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
        sb.append(", resource_id=").append(super.getResourceId());
        sb.append(", name=").append(super.getName());
        sb.append(", url=").append(super.getUrl());
        sb.append(", method=").append(super.getMethod());
        sb.append(", parent_id=").append(super.getParentId());
        sb.append(", parent_ids=").append(super.getParentIds());
        sb.append(", permission=").append(super.getPermission());
        sb.append(", data_target=").append(super.getDataTarget());
        sb.append(", icon=").append(super.getIcon());
        sb.append(", component=").append(super.getComponent());
        sb.append(", type=").append(super.getType());
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
