package com.tjetc.domain;

public class Receiver {
    private int receiverId;
    private String receiverName;//收件人地址名
    private String receiverPhone;//收件人手机号
    private String receiverUserName;//收件人名称
    private User user;//下单账号

    public Receiver() {
    }

    public Receiver(int receiverId, String receiverName, String receiverPhone, String receiverUserName, User user) {
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverUserName = receiverUserName;
        this.user = user;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "receiverId=" + receiverId +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverUserName='" + receiverUserName + '\'' +
                ", user=" + user +
                '}';
    }
}
