package org.flow.utils.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PageUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageUtils.class);

    private int total = 0;
    private String ordername = "id";
    private String order = "asc";
    private Map params;

    public int getTotal() {
        return total;
    }

    public PageUtils(Map params) {
        this.params = params;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
