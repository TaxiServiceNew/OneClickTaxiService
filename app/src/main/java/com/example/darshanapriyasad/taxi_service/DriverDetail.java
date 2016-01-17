package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.databaseconnection.DBConnection;
import com.example.darshanapriyasad.taxi_service.support.DownloadImageTask;

import org.json.JSONException;
import org.json.JSONObject;

public class DriverDetail extends AppCompatActivity {

    private String d_nic;
    private TextView first_name;
    private TextView last_Name;
    private TextView address;
    private TextView telephone;
    private String fName;
    private String lName;
    private String addresses;
    private String tel;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        telephone = (TextView) findViewById(R.id.telephoneText);
        address = (TextView) findViewById(R.id.addressText);
        first_name = (TextView) findViewById(R.id.firstNameText);
        last_Name = (TextView) findViewById(R.id.lastNameText);


        Button button = (Button) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                d_nic = ((TextView) findViewById(R.id.idText)).getText().toString();
                new DbDriverDetail().execute(new DBConnection());




            }
        });


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(DriverDetail.this,MainWindow.class);
                startActivity(intent);
            }
        });

    }

    private class DbDriverDetail extends AsyncTask<DBConnection,Long,JSONObject> {

        @Override
        protected JSONObject doInBackground(DBConnection... params) {
            return params[0].getDriverDetail(d_nic);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if(result!=null) {
                String user_id = null;
                try {
                    fName= result.getString("first_name");
                    lName = result.getString("last_name");
                    addresses = result.getString("address");
                    tel = result.getString("telephone_number");
                    String templocation = result.getString("imageLoc");
                    location = templocation.replace("\\/", "/");

                    System.out.println("D_NIC yyyyyyyyyyyyyy =" + fName);

                    first_name.setText(fName);
                    last_Name.setText(lName);
                    address.setText(addresses);
                    telephone.setText(tel);

                    System.out.println("sssssssssssssssssss00" + location);
                    System.out.println("lllllllllllllll" + fName );
                    new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
                            .execute(location);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }else{

                Toast t = Toast.makeText(getApplicationContext(), "Driver not Found", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }


    }


