package com.example.darshanapriyasad.taxi_service.support;

import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.databaseconnection.DBConnection;
import com.example.darshanapriyasad.taxi_service.model.Reservation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Buddhi Ayesha on 1/17/2016.
 */

public class notifyToDriver {

    String tp[];// = {"0716943927","0719876162"};
    String smess;

    public void sendToAllDriver(Reservation mes){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        smess = "st" + dateFormat.format(date).replace(" ", "") + " Date: " + mes.getFromDate()
                + ", From: " + mes.getFrom() + ", To:" +mes.getTo() + ", Days: " + mes.getDayCount() + ", Charge: " + mes.getMoney() +",";
        new DbDriverTP().execute(new DBConnection());



    }

    public void sendSMSMessage(String phoneNo, String message) {

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            System.out.println("sms send.");

        }

        catch (Exception e) {
            //Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private class DbDriverTP extends AsyncTask<DBConnection,Long,JSONObject> {

        @Override
        protected JSONObject doInBackground(DBConnection... params) {
            return params[0].getDriverTP();
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if(result!=null) {
                try {
                    tp = result.get("Orders").toString().replace("[", "").replace("]", "").split(",");
                    System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrr=" + tp);


                    int num = tp.length;
                    for (int x=0; x<num; x++){
                        sendSMSMessage(tp[x].toString(), smess);
                        System.out.println(tp[x]);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }else{


            }
        }


    }



}
