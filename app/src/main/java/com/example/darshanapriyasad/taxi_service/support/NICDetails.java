package com.example.darshanapriyasad.taxi_service.support;

import java.util.Scanner;

/**
 * Created by Darshana Priyasad on 12/16/2015.
 */

public class NICDetails {

    String id;
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getYear() {
        return (1900 + Integer.parseInt(id.substring(0, 2)));
    }

    public int getDays() {
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return (d - 500);
        } else {
            return d;
        }
    }

    public void setMonth() {
        int mo = 0, da = 0;
        int days = getDays();

        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                da = days;
                break;
            } else {
                days = days - month[i];
            }
        }
        System.out.println("Month : " + mo + "\nDate : " + da);

    }

    public String getSex() {
        String M = "Male", F = "Female";
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return F;
        } else {
            return M;
        }
    }
}
