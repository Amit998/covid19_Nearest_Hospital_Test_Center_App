package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailHospitalActivity extends AppCompatActivity {
    TextView tvHpId,tvHpName,tvHpCost,tvHpBeds,tvHpLocation,tvHpEmail,tvHPPhno,tvHPAdmited,tvHPRecover;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hospital);

        tvHpName=findViewById(R.id.tvtcName);
        tvHpCost=findViewById(R.id.hpCost);
        tvHpBeds=findViewById(R.id.hpBeds);
        tvHpLocation=findViewById(R.id.hpAddress);

        tvHpEmail=findViewById(R.id.hpMail);
        tvHPPhno=findViewById(R.id.hpPhno);
        tvHPAdmited=findViewById(R.id.hpAdmited);
        tvHPRecover=findViewById(R.id.hpRecovered);

        TextView tvAvailability=findViewById(R.id.hpAvailable);





        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");



        tvHpName.setText(hospital_list.hospitalArrayNames.get(position).getHp_name().trim());
        tvHpCost.setText(hospital_list.hospitalArrayNames.get(position).getCosts().trim()+" RS");
        tvHpBeds.setText(hospital_list.hospitalArrayNames.get(position).getBeds().trim());
        tvHpLocation.setText(hospital_list.hospitalArrayNames.get(position).getLocation().trim());
        tvHPRecover.setText(hospital_list.hospitalArrayNames.get(position).getRecovered().trim());
        tvHPAdmited.setText(hospital_list.hospitalArrayNames.get(position).getAdmitted().trim());
        tvHpEmail.setText(hospital_list.hospitalArrayNames.get(position).getEmail().trim());
        tvHPPhno.setText(hospital_list.hospitalArrayNames.get(position).getPhno().trim());

        tvAvailability.setText(hospital_list.hospitalArrayNames.get(position).getAvailability().trim());





    }

    public void BookNowFromHospital(View view) {
        Intent intent=new Intent(getApplicationContext(),HpBookingActivity.class);
        startActivity(intent);

    }

    public void GoBackHospital(View view) {
        Intent intent=new Intent(getApplicationContext(),hospital_list.class);
        startActivity(intent);
    }
}
