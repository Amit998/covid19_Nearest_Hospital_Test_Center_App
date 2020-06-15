package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminView extends AppCompatActivity {
    Button hospital,testCenter,login,insertTC,insertHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        hospital = findViewById(R.id.btnHospital);
        testCenter = findViewById(R.id.btnTestCenter);
        login = findViewById(R.id.btnLogin);
        insertTC = findViewById(R.id.btn_Tc_insert);

        insertHP = findViewById(R.id.btn_HP_insert);
        insertHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),insertIntoList.class);
                startActivity(intent);

            }
        });


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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent);
            }
        });
        insertTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InsertIntoTestCenter.class);
                startActivity(intent);
            }
        });

    }
}
