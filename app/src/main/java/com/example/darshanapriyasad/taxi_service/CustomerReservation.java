package com.example.darshanapriyasad.taxi_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darshanapriyasad.taxi_service.model.Reservation;
import com.example.darshanapriyasad.taxi_service.support.Validation;
import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerReservation extends AppCompatActivity {

    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private String user_id;
    final TextView fromText = (TextView) findViewById(R.id.fromText);
    final TextView toText = (TextView) findViewById(R.id.toText);
    TextView dateText = (TextView) findViewById(R.id.dateTimeText);
    final TextView dayCountText = (TextView) findViewById(R.id.dayCountText);
    final TextView moneyText = (TextView) findViewById(R.id.maxMoneyText);
    Button submitButton = (Button) findViewById(R.id.submitButton);
    Button backButton = (Button) findViewById(R.id.backButton);


    private SlideDateTimeListener listener = new SlideDateTimeListener() {
        @Override
        public void onDateTimeSet(Date date)
        {
            dateText.setText(mFormatter.format(date));
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel()
        {
            Toast.makeText(CustomerReservation.this,
                    "Canceled", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user_id = extras.getString("C_NIC");

        }

        Button button = (Button) findViewById(R.id.buttonDateTime);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(listener)
                        .setInitialDate(new Date())
                                //.setMinDate(minDate)
                                //.setMaxDate(maxDate)
                                //.setIs24HourTime(true)
                                //.setTheme(SlideDateTimePicker.HOLO_DARK)
                                //.setIndicatorColor(Color.parseColor("#990000"))
                        .build()
                        .show();
            }
        });



        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CustomerReservation.this, MainWindow.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                String from = fromText.getText().toString();
                String to = toText.getText().toString();
                String money = moneyText.getText().toString();
                String dayCount = dayCountText.getText().toString();
                String date = dateText.getText().toString();

                String[] data = null;

                if(date != null){
                    data = date.split("\\s+");
                }

                Validation validation = new Validation();

                boolean validFrom = validation.isValidName(from);
                boolean validTo = validation.isValidName(to);
                boolean validMoney = validation.isValidMoney(money);
                boolean validCount = validation.isValidAge(dayCount);
                boolean validDate = true;
                if( date== null){
                    validDate = false;
                }

                if(validFrom & validDate & validCount & validTo & validMoney){
                    String fromDate = data[0];
                    String fromTime = data[1];

                    int days = Integer.valueOf(dayCount);
                    double moneyes = Double.valueOf(money);
                    Reservation reservation = new Reservation(user_id,from,to,fromDate,fromTime,days,moneyes);



                }


                Intent intent = new Intent(CustomerReservation.this, MainWindow.class);
                intent.putExtra("C_NIC",user_id);
                startActivity(intent);
            }
        });
        


    }

}
