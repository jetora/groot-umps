package org.flow.pojo;

public class OrganizationTree extends TreeNode {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass() +
                "name='" + name + '\'' +
                ", id=" + id +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}
