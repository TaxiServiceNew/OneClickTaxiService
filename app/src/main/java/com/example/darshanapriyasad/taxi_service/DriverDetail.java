package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darshanapriyasad.taxi_service.R;
import com.example.darshanapriyasad.taxi_service.support.DownloadImageTask;

public class DriverDetail extends AppCompatActivity {

    private String d_nic;
    private TextView first_name;
    private TextView last_Name;
    private TextView address;
    private TextView telephone;



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


                new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
                        .execute("http://www.dbprojectg5.net16.net/pic1.jpg");
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


    }


