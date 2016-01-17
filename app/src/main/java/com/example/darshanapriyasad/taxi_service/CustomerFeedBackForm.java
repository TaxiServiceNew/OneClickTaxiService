package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.model.FeedBack;

public class CustomerFeedBackForm extends AppCompatActivity {

    private String user_id;
    private RadioButton veryBadButton;
    private RadioButton badButton;
    private RadioButton fairButton;
    private RadioButton goodButton;
    private RadioButton veryGoodButton;
    private Button backButton;
    private Button submitButton;
    private TextView commentTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feed_back_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            user_id = extras.getString("C_NIC");
        }

        veryBadButton = (RadioButton) findViewById(R.id.veryBadButton);
        badButton = (RadioButton) findViewById(R.id.badButton);
        fairButton = (RadioButton) findViewById(R.id.fairButton);
        goodButton = (RadioButton) findViewById(R.id.goodButton);
        veryGoodButton = (RadioButton) findViewById(R.id.veryGoodButton);
        backButton = (Button) findViewById(R.id.backButton);
        submitButton = (Button) findViewById(R.id.submitButton);
        commentTextView = (TextView) findViewById(R.id.commentText);

        fairButton.setChecked(true);

        veryBadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton selected = isSelected();
                if (selected != null) {
                    selected.setChecked(false);
                    veryBadButton.setChecked(true);
                } else {
                    veryBadButton.setChecked(true);
                }
            }
        });


        badButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                RadioButton selected = isSelected();
                if(selected != null){
                    selected.setChecked(false);
                    badButton.setChecked(true);
                }else{
                    badButton.setChecked(true);
                }
            }
        });


        fairButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                RadioButton selected = isSelected();
                if(selected != null){
                    selected.setChecked(false);
                    fairButton.setChecked(true);
                }else{
                    fairButton.setChecked(true);
                }
            }
        });


        goodButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                RadioButton selected = isSelected();
                if(selected != null){
                    selected.setChecked(false);
                    goodButton.setChecked(true);
                }else{
                    goodButton.setChecked(true);
                }
            }
        });


        veryGoodButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                RadioButton selected = isSelected();
                if(selected != null){
                    selected.setChecked(false);
                    //System.out.println("not null");
                    veryGoodButton.setChecked(true);
                }else{
                    //System.out.println("null");
                    veryGoodButton.setChecked(true);
                }
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CustomerFeedBackForm.this, MainWindow.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

       submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                RadioButton selected = isSelected();
                if(selected == null){

                }else{
                    String text = selected.getText().toString();
                    String comment = commentTextView.getText().toString();
                    if(comment == null){
                        comment = " ";
                    }
                    FeedBack feedBack = new FeedBack(user_id,text,comment);


                    Toast t = Toast.makeText(getApplicationContext(), "Successfully  FeedBack Sent", Toast.LENGTH_SHORT);
                    t.show();
                    Intent intent = new Intent(CustomerFeedBackForm.this, MainWindow.class);
                    intent.putExtra("C_NIC",user_id);
                    startActivity(intent);
                }
            }
        });

    }


    public RadioButton isSelected(){
        if(veryBadButton.isChecked()){
            return veryBadButton;
        }else if(badButton.isChecked()){
            return badButton;
        }else if(fairButton.isChecked()){
            return fairButton;
        }else if(goodButton.isChecked()){
            return goodButton;
        }else if(veryGoodButton.isChecked()){
            return veryGoodButton;
        }else {
            return null;
        }
    }



}
