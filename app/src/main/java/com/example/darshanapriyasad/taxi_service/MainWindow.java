package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainWindow extends AppCompatActivity {

    private String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user_id = extras.getString("C_NIC");

        }
        Button button = (Button) findViewById(R.id.driverButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainWindow.this, HireTaxi.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

        Button detailButton = (Button) findViewById(R.id.detailButton);

        detailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainWindow.this, MyDetail.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

        Button historyButton = (Button) findViewById(R.id.historyButton);

        historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainWindow.this, HireDetail.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

        Button driverButton = (Button) findViewById(R.id.driverDButton);

        driverButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainWindow.this, DriverDetail.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

        Button buttons = (Button) findViewById(R.id.button);

        buttons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainWindow.this, CustomerReservation.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

    }

}
