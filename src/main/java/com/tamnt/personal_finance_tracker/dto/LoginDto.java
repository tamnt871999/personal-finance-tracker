package com.tamnt.personal_finance_tracker.dto;

public class LoginDto {

    private String userName;
    private String password;

    public LoginDto(){}

    public String getUserName() {
       return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
