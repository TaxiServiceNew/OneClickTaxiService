package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.darshanapriyasad.taxi_service.model.User;

public class SignUp extends AppCompatActivity {

    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private String password;
    private String rePassword;
    private String userName;
    private String telHome;
    private String telMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.submitButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                firstName = ((TextView) findViewById(R.id.firstNameText)).getText().toString();
                lastName = ((TextView) findViewById(R.id.lastNameText)).getText().toString();
                NIC = ((TextView) findViewById(R.id.idText)).getText().toString();
                password = ((TextView) findViewById(R.id.passwordText)).getText().toString();
                rePassword = ((TextView) findViewById(R.id.rePasswordText)).getText().toString();
                address = ((TextView) findViewById(R.id.AddressText)).getText().toString();
                telHome = ((TextView) findViewById(R.id.homeText)).getText().toString();
                telMobile = ((TextView) findViewById(R.id.mobileText)).getText().toString();
                userName = ((TextView) findViewById(R.id.userNameText)).getText().toString();

                User user = new User(firstName,lastName,NIC,address,telHome,telMobile,userName,password,rePassword);

                /*

                    Should insert into both the customer-telephone, customer ad customer-login


                 */



                Intent intent = new Intent(SignUp.this, HireTaxi.class);
                startActivity(intent);
            }
        });
    }

}
