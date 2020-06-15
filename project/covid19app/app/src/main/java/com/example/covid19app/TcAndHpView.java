package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TcAndHpView extends AppCompatActivity {
    Button hospital,testCenter,login,insertTC,insertHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tc_and_hp_view);

        hospital = findViewById(R.id.btnHospital);
        testCenter = findViewById(R.id.btnTestCenter);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),hospital_list.class);
                startActivity(intent);
            }
        });

        testCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),testCenterListView.class);
                startActivity(intent);

            }
        });
    }
}
