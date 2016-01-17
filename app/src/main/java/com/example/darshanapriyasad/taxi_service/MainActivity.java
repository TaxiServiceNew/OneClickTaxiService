package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.support.notifyToDriver;
import com.example.darshanapriyasad.taxi_service.databaseconnection.DBConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView passwordText;

    private String un;
    private String pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nameText = (TextView) findViewById(R.id.nameText);
        passwordText = (TextView) findViewById(R.id.passwordText);
        String name = nameText.getText().toString();

        Button button = (Button) findViewById(R.id.loginButton);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                /*String phoneNo = "0716943927";
                String message = "Android test";
                notifyToDriver testsms= new notifyToDriver();
                testsms.sendSMSMessage(phoneNo,message);*/

                un= nameText.getText().toString();
                pw = passwordText.getText().toString();
                new GetUserData().execute(new DBConnection());
            }
        });

        Button submitButton = (Button) findViewById(R.id.signButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetUserData extends AsyncTask<DBConnection,Long,JSONObject> {

        @Override
        protected JSONObject doInBackground(DBConnection... params) {
            return params[0].getUserDetail(un, pw);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if(result!=null) {
                String user_id = null;
                try {
                     user_id= result.getString("C_NIC");
                    System.out.println(user_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast t = Toast.makeText(getApplicationContext(), "Successfully Logged", Toast.LENGTH_SHORT);
                t.show();
                Intent intent = new Intent(MainActivity.this, MainWindow.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);


            }else{

                Toast t = Toast.makeText(getApplicationContext(), "Logging Failed", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }


}
