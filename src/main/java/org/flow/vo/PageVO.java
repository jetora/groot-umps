package org.flow.vo;

import java.io.Serializable;

public class PageVO implements Serializable {
    private static final long serialVersionUID = -232260336429554069L;
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
}
