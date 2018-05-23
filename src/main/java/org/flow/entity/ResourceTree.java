package org.flow.entity;

public class ResourceTree extends TreeNode {
    private String name;
    private String permission;
    private Byte type;
    private String data_url;
    private String data_target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    
    public String getData_url() {
        return data_url;
    }

    public void setData_url(String data_url) {
        this.data_url = data_url;
    }

    public String getData_target() {
        return data_target;
    }

    public void setData_target(String data_target) {
        this.data_target = data_target;
    }
}
