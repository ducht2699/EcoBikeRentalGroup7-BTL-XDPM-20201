/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.Entity;


public class User {
    private String username, password;
    private int userId, status;
    private int isAdmin;
    
    public User() {
    	
    }

    public User(int userId, String username, int status, int isAdmin) {
        super();
    	this.userId = userId;
        this.username = username;
        this.status = status;
        this.isAdmin = isAdmin;
    }

    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
