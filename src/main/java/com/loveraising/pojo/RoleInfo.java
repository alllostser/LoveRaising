package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("roleinfo")
public class RoleInfo {
    private Integer id;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
