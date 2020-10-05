package com.tjetc.domain;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userIphone;//电话
    private String userImg;
    private List<Receiver> list;
    private int userStates;//状态（0：禁用，1：启用）

    public User() {
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(int userId, String userName, String userPwd, String userIphone, String userImg, List<Receiver> list, int userStates) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userIphone = userIphone;
        this.userImg = userImg;
        this.list = list;
        this.userStates = userStates;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserIphone() {
        return userIphone;
    }

    public void setUserIphone(String userIphone) {
        this.userIphone = userIphone;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public List<Receiver> getList() {
        return list;
    }

    public void setList(List<Receiver> list) {
        this.list = list;
    }

    public int getUserStates() {
        return userStates;
    }

    public void setUserStates(int userStates) {
        this.userStates = userStates;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userIphone='" + userIphone + '\'' +
                ", userImg='" + userImg + '\'' +
                ", list=" + list +
                ", userStates=" + userStates +
                '}';
    }
}
