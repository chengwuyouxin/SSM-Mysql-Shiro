package com.lpq.personallibrary.entity;

public class Role {
    private int id;
    private String role;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Role(int id, String role, String desc) {
        this.id = id;
        this.role = role;
        this.desc = desc;
    }
}
