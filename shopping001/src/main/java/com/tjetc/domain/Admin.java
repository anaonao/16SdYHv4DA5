package com.tjetc.domain;


public class Admin {
    private int adminId;
    private String adminName;
    private String adminPwd;
    private String adminPhone;
    private int adminState;//管理员状态（0：禁用，1：启用）

    public Admin() {
    }

    public Admin(String adminName, String adminPwd) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
    }

    public Admin(int adminId, String adminName, String adminPwd, String adminPhone, int adminState) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminPhone = adminPhone;
        this.adminState = adminState;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public int getAdminState() {
        return adminState;
    }

    public void setAdminState(int adminState) {
        this.adminState = adminState;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminState=" + adminState +
                '}';
    }
}
