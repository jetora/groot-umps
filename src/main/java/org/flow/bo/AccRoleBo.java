package org.flow.bo;

import java.io.Serializable;
import java.util.List;

public class AccRoleBo implements Serializable {
    private static final long serialVersionUID = 7680275101431882657L;
    private Long accountId;
    private List<Long> roleIds;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountid=").append(getAccountId());
        sb.append(", roleIds=").append(getRoleIds());
        sb.append("]");
        return sb.toString();
    }
}
