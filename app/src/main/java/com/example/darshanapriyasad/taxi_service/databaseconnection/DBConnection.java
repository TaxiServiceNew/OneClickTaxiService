package com.example.darshanapriyasad.taxi_service.databaseconnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Dimuthu on 2015-08-08.
 */
public class DBConnection {
    InputStream is;

    /*
    public JSONArray getUser(String un,String pw){


        String url="http://dbprojectg5.net16.net/userlogin.php?un="+un+"&pw="+pw+"&functionname=selectuser";

        HttpEntity httpEntity= null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity=httpResponse.getEntity();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = null;

        if(httpEntity!=null){

            String entityResponse;
            try {
                entityResponse = EntityUtils.toString(httpEntity);
                jsonArray = new JSONArray(entityResponse);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return jsonArray;

    }*/

    public JSONObject getUserDetail(String un, String pw){
        String url="http://dbprojectg5.net16.net/userlogin.php?un="+un+"&pw="+pw+"&functionname=selectuser";

        HttpEntity httpEntity= null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity=httpResponse.getEntity();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;

        if(httpEntity!=null){

            String entityResponse;
            try {
                entityResponse = EntityUtils.toString(httpEntity);
                jsonObject = new JSONObject(entityResponse);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return jsonObject;

    }

    /*public String saveUser(String[] userdata)
    {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        System.out.println(userdata[0]);
        nameValuePairs.add(new BasicNameValuePair("un",userdata[0].toString()));
        nameValuePairs.add(new BasicNameValuePair("pw",userdata[1].toString()));
        nameValuePairs.add(new BasicNameValuePair("addressOne",userdata[2].toString()));
        nameValuePairs.add(new BasicNameValuePair("addressTwo",userdata[3].toString()));
        nameValuePairs.add(new BasicNameValuePair("sleeves",userdata[4].toString()));
        nameValuePairs.add(new BasicNameValuePair("chest",userdata[5].toString()));
        nameValuePairs.add(new BasicNameValuePair("waist",userdata[6].toString()));
        nameValuePairs.add(new BasicNameValuePair("hip",userdata[7].toString()));
        nameValuePairs.add(new BasicNameValuePair("inseam",userdata[8].toString()));

        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.2.2/Fashion/usersignup.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            return "Success";
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
        return null;

    }*/


    public JSONObject setDbSignUp(String firstName, String lastName, String NIC, String password, String address, String telHome, String telMobile, String userName){
        String url="http://dbprojectg5.net16.net/userlogin.php?firstName="+firstName+"&lastName="+lastName+"&NIC="+NIC+"&password="+password+"&address="+address+"&telHome="+telHome+"&telMobile="+telMobile+"&userName="+userName+"&functionname=dbsignup";

        HttpEntity httpEntity= null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity=httpResponse.getEntity();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;

        if(httpEntity!=null){

            String entityResponse;
            try {
                entityResponse = EntityUtils.toString(httpEntity);
                System.out.println("qqqqqqqqqqqqqqqqqq" + entityResponse);
                jsonObject = new JSONObject(entityResponse);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return jsonObject;

    }


}
