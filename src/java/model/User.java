/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class User {
    private int userID;
    private String Name;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String mail;
    private String avatar;
    private int roleID;

    public User() {
    }

    public User(int userID, String Name, String username, String password, String phone, String address, String mail, String avatar, int roleID) {
        this.userID = userID;
        this.Name = Name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
        this.avatar = avatar;
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", Name=" + Name + ", username=" + username + ", password=" + password + ", phone=" + phone + ", address=" + address + ", mail=" + mail + ", avatar=" + avatar + ", roleID=" + roleID + '}';
    }

    
}