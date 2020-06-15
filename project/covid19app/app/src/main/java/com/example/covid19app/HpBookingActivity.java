package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HpBookingActivity extends AppCompatActivity {
    EditText patient_Name,patient_phno,patient_Address,patient_uid,patient_symptoms,patient_problem;
    TextView tc_Name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp_booking);


        patient_Name=findViewById(R.id.hp_bk_patient);

        patient_phno=findViewById(R.id.hp_bk_phno);
        patient_Address=findViewById(R.id.hp_bk_address);
        patient_uid=findViewById(R.id.hp_bk_uniqueCode);
        patient_symptoms=findViewById(R.id.hp_bk_symptoms);
        patient_problem=findViewById(R.id.hp_bk_problem);

        patient_uid.setText(generateString().trim());




    }
    private String generateString(){
        char[] chars="abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        Random random = new Random();

        for(int i =0;i < 10;i++){
            char c=chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public void moveBack(View view) {
    }

    public void Book(View view) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        Date d = new Date();
        CharSequence s = DateFormat.format("yyyy-MM-dd hh:mm:ss", d.getTime());

        final String p_name = patient_Name.getText().toString().trim();
        final String p_address = patient_Address.getText().toString().trim();
        final String p_Phno = patient_phno.getText().toString().trim();

        final String p_uid = generateString().trim();
        final String p_symptoms = patient_symptoms.getText().toString().trim();
        final String p_problem = patient_problem.getText().toString().trim();

        final String p_Hp_Name = "Hospital Name";
        final String p_from = "Hospital";
        final String p_Date = s.toString().trim();



        if  (p_name.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter A Username", Toast.LENGTH_SHORT).show();
        } else if (p_address.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter A Address", Toast.LENGTH_SHORT).show();
        } else if (p_Phno.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter A Phone number", Toast.LENGTH_SHORT).show();
        } else if (p_uid.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter A Unique Id", Toast.LENGTH_SHORT).show();
        } else if (p_symptoms.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter A Symptom", Toast.LENGTH_SHORT).show();
        } else if (p_problem.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please Enter A Problem", Toast.LENGTH_SHORT).show();
        }else  {
            progressDialog.show();
            StringRequest request= new StringRequest(Request.Method.POST, "https://damitlucky.000webhostapp.com/AddBooking.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(getApplicationContext(),"Booked",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else {
                                Toast.makeText(getApplicationContext(),"Data didn't Inserted",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<String,String>();
                    params.put("placeName",p_address);
                    params.put("patientNumber",p_Phno);
                    params.put("patientAddress",p_address);
                    params.put("uid",p_uid);

                    params.put("Symptoms",p_symptoms);
                    params.put("problem",p_problem);
                    params.put("fromP",p_from);
                    params.put("time",p_Date);
                    params.put("patientName",p_name);


                    return params;
                }
            };

            RequestQueue requestQueue= Volley.newRequestQueue(HpBookingActivity.this);
            requestQueue.add(request);
        }

    }


    public void moveBackList(View view) {
        Intent intent=new Intent(getApplicationContext(),hospital_list.class);
        startActivity(intent);
    }
}
