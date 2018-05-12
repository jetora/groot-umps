package org.flow.utils.common.utils;

public class Reqparams {
    private static final long serialVersionUID = -3371934618173052904L;
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
