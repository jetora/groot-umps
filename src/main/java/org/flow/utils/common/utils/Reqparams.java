package org.flow.utils.common.utils;

import java.io.Serializable;

public class Reqparams implements Serializable {

    private static final long serialVersionUID = 7697888997987779020L;
    private String appId;
    private String appSecret;
    public Reqparams() {
    }
    public Reqparams(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getAppSecret() {
        return appSecret;
    }
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    @Override
    public String toString() {
        return "ResponseResult{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}
