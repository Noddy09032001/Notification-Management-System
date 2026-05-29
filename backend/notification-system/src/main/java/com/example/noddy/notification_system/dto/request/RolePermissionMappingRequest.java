package com.example.noddy.notification_system.dto.request;

import java.util.List;

public class RolePermissionMappingRequest {

    private Integer roleId;   // role id of the role
    private List<Integer> permissionIdList;    // list of permissions assigned to the given role id

    public RolePermissionMappingRequest(){}

    public RolePermissionMappingRequest(Integer roleId, List<Integer> permissionIdList) {
        this.roleId = roleId;
        this.permissionIdList = permissionIdList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<Integer> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }
}
