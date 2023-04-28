package com.example.h2oflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        getSupportActionBar().setTitle("Show Details");
        TextView meterNo = findViewById(R.id.meterNo);
        TextView name = findViewById(R.id.name);
        TextView status = findViewById(R.id.status);
        meterNo.setText(getIntent().getStringExtra("MeterNo"));
        name.setText(getIntent().getStringExtra("name"));
        status.setText(getIntent().getStringExtra("status"));


    }
}