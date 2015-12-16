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

import com.example.darshanapriyasad.taxi_service.R;
import com.example.darshanapriyasad.taxi_service.support.DownloadImageTask;

public class DriverDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button button = (Button) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
                        .execute("http://findicons.com/files/icons/129/soft_scraps/128/user_executive_red_01.png");
            }
        });



    }


    }


