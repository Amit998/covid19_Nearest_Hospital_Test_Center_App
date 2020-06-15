package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TestCenterList extends AppCompatActivity {
    TextView tvtcid,tvtcAvailable,tvtccost,tvtctested,tvtcemail,tvtcphno,tvtcaddress,tvtcsuccessRate;
    TextView tvtcName;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_center_list);

        tvtcName=findViewById(R.id.tvtcName);

        tvtccost=findViewById(R.id.tvtccost);
        tvtcAvailable=findViewById(R.id.tvtcavailable);

        tvtctested=findViewById(R.id.tvtcTested);

        tvtcaddress=findViewById(R.id.tvtclocation);

        tvtcemail=findViewById(R.id.tvtcemail);
        tvtcphno=findViewById(R.id.tvtcphno);


        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");


        tvtcName.setText(testCenterListView.testCenterNames.get(position).getTcName());

        tvtctested.setText(testCenterListView.testCenterNames.get(position).getTested());
        tvtccost.setText(testCenterListView.testCenterNames.get(position).getCost());
        tvtcAvailable.setText(testCenterListView.testCenterNames.get(position).getAvailability());
        tvtcemail.setText(testCenterListView.testCenterNames.get(position).getEmail());
        tvtcphno.setText(testCenterListView.testCenterNames.get(position).getPhno());
        tvtcaddress.setText(testCenterListView.testCenterNames.get(position).getAddress());





    }

    public void callTestCenter(View view) {
        Intent callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+testCenterListView.testCenterNames.get(position).getPhno()));
        startActivity(callIntent);
    }

    public void sendMail(View view) {
        Intent mailIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+testCenterListView.testCenterNames.get(position).getEmail()));
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,"Need More Suggestion");
        mailIntent.putExtra(Intent.EXTRA_TEXT,"Help Me ");

        startActivity(mailIntent);
    }

    public void BookForTestCenter(View view) {
        Intent intent=new Intent(getApplicationContext(),Tc_Booking_Activity.class);
        startActivity(intent);
    }

    public void GoBackTc(View view) {
        Intent intent=new Intent(getApplicationContext(),TestCenterList.class);
        startActivity(intent);
    }
}
