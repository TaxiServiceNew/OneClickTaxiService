package com.example.darshanapriyasad.taxi_service.model;

/**
 * Created by Darshana Priyasad on 12/16/2015.
 */

public class User {

    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private String password;
    private String rePassword;
    private String userName;
    private String telHome;
    private String telMobile;

    public User() {

    }

    public User(String firstName, String lastName, String NIC, String address,  String telHome, String telMobile , String userName,String password, String rePassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.NIC = NIC;
        this.address = address;
        this.password = password;
        this.rePassword = rePassword;
        this.userName = userName;
        this.telHome = telHome;
        this.telMobile = telMobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }
}
