package com.example.darshanapriyasad.taxi_service.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darshana Priyasad on 12/16/2015.
 */
public class Validation {


    public boolean validNIC(String nic) {

        if(nic == null){
            return false;
        }else{
            CharSequence inputStr = nic;
            Pattern pattern = Pattern.compile(new String ("/^[0-9]{9}[vVxX]$/"));
            Matcher matcher = pattern.matcher(inputStr);
            return matcher.matches();
        }
    }

    public boolean isValidName(String name){
        if(name == null){
            return false;
        }else{
            CharSequence inputStr = name;
            Pattern pattern = Pattern.compile(new String ("^[a-zA-Z\\s]*$"));
            Matcher matcher = pattern.matcher(inputStr);
            return matcher.matches();
        }
    }

    public boolean isValidAge(String age){
        if(age==null){
            return false;
        }else{
            try {
                int corrected = Integer.valueOf(age);
                return true;
            }catch(Exception ex){
                return false;
            }
        }
    }

    public boolean isValidMoney(String amount){
        if(amount == null){
            return false;
        }else{
            CharSequence inputStr = amount;
            Pattern pattern = Pattern.compile(new String ("[0-9]+([,.][0-9]{1,2})?"));
            Matcher matcher = pattern.matcher(inputStr);
            return matcher.matches();
        }
    }

    public boolean isValidDate(String date){
        if(date == null){
            return false;
        }else {
            Date convertDate = null;
            String inputDate = date;
            try {
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                formatter.setLenient(false);
                convertDate = formatter.parse(inputDate);
                return true;
            } catch (ParseException e) {
                return false;
                //e.printStackTrace();
            }
        }
    }


    public boolean validateTelephoneNumber(String number){
        return true;
    }




}
