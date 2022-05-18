package com.cg.Entities;

import com.cg.Services.TestService;

public class User {
    private Long userID;
    private String userName;
    private TestService userTestService;
    private boolean admin;
    private String userPassword;

    public User() {
    }

    public User(Long userID, String userName, TestService userTestService, boolean admin, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userTestService = userTestService;
        this.admin = admin;
        this.userPassword = userPassword;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TestService getUserTestService() {
        return userTestService;
    }

    public void setUserTestService(TestService userTestService) {
        this.userTestService = userTestService;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
