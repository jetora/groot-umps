package org.flow.utils.common.utils;

import java.io.Serializable;

public class LayuiResult<T> implements Serializable {
    private static final long serialVersionUID = -3371934618173052904L;
    private String code;
    private String msg;
    private T data;
    private Integer count;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
