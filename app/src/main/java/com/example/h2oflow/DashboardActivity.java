package com.example.h2oflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final CardView meter_reading = findViewById(R.id.meter_reading);
        final CardView meter_history = findViewById(R.id.meter_history);
        final CardView bill_caculator = findViewById(R.id.bill_caculator);
        final CardView meter_zone = findViewById(R.id.meter_zone);
        final CardView about_us = findViewById(R.id.about_us);

        meter_reading.setOnClickListener(this);
        meter_history.setOnClickListener(this);
        bill_caculator.setOnClickListener(this);
        meter_zone.setOnClickListener(this);
        about_us.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.meter_reading:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.meter_history:
                Toast.makeText(this, "meter_history clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bill_caculator:
                Toast.makeText(this, "bill_caculator clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.meter_zone:
                Toast.makeText(this, "meter_zone clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_us:
                Toast.makeText(this, "about_us clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}