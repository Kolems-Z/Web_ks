package com.zhangaoyun.pojo;

public class User {
    String email;
    int passId;
    String passWord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "mail='" + email + '\'' +
                ", passId=" + passId +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
