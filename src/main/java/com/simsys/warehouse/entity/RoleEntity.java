package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Integer roleID;

    @Column(name = "rolename", length = 255)
    private String roleName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;

    // Constructors
    public RoleEntity() {
    }

    public RoleEntity(Integer roleID, String roleName, String description) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.description = description;
    }

    // Getters và Setters
    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
