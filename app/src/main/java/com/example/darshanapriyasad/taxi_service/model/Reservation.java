package com.example.darshanapriyasad.taxi_service.model;

/**
 * Created by Darshana Priyasad on 1/16/2016.
 */
public class Reservation {

    private String user_id;
    private String from;
    private String to;
    private String fromDate;
    private String fromTime;
    private int dayCount;
    private double money;
    private int passCount;
    private String type;

    public Reservation(){

    }

    public Reservation(String user_id,String from, String to, String fromDate, String fromTime, int dayCount, double money,String type,int passCount) {
        this.user_id = user_id;
        this.from = from;
        this.to = to;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.dayCount = dayCount;
        this.money = money;
        this.passCount = passCount;
        this.type = type;
    }

    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
