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
import android.widget.TextView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.databaseconnection.DBConnection;
import com.example.darshanapriyasad.taxi_service.model.User;

import org.json.JSONException;
import org.json.JSONObject;

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
                if(telHome != null || telMobile!= null){

                    if(telHome == null){
                        telHome = "no";
                    }else if(telMobile == null){
                        telMobile = "no";
                    }

                    if(password.equals(rePassword) && userName != null){
                        if(NIC != null && address != null && firstName != null && lastName != null){
                            // code here
                            new DbSignUp().execute(new DBConnection());

                        }else{
                            Toast t = Toast.makeText(getApplicationContext(), "Please fill every field", Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }else{
                        Toast t = Toast.makeText(getApplicationContext(), "Logging Failed", Toast.LENGTH_SHORT);
                        t.show();
                    }

                }else{
                    Toast t = Toast.makeText(getApplicationContext(), "Please enter at least one contact number", Toast.LENGTH_SHORT);
                    t.show();
                }



            }
        });
    }

    private class DbSignUp extends AsyncTask<DBConnection,Long,JSONObject> {

        @Override
        protected JSONObject doInBackground(DBConnection... params) {
            return params[0].setDbSignUp(firstName,lastName,NIC,password,address,telHome,telMobile,userName);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if(result!=null) {
                /*
                String user_id = null;
                try {
                    user_id= result.getString("C_NIC");
                    System.out.println(user_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                */

                Toast t = Toast.makeText(getApplicationContext(), "Successfully SignUp", Toast.LENGTH_SHORT);
                t.show();
                Intent intent = new Intent(SignUp.this, MainWindow.class);
                intent.putExtra("C_NIC",NIC);
                startActivity(intent);


            }else{

                Toast t = Toast.makeText(getApplicationContext(), "SignUp Failed", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }

}
