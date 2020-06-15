package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class insertIntoList extends AppCompatActivity {

    EditText hp_name,cost,location,beds,admitted,phno,email,recovered,hp_death;
    Button btnInsert;
    private RadioGroup avaG;
    private RadioButton avaB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_list);

        hp_name=findViewById(R.id.hp_name);
        cost=findViewById(R.id.cost);
        beds=findViewById(R.id.beds);
        location=findViewById(R.id.location);

        admitted=findViewById(R.id.hp_admitted);
        phno=findViewById(R.id.hp_phno);
        email=findViewById(R.id.hp_ed_email);
        recovered=findViewById(R.id.hp_recovery);
        btnInsert=findViewById(R.id.btn_add);

        avaG=findViewById(R.id.HpAvailability);
        hp_death=findViewById(R.id.hp_death);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }


        });


    }

    private void insertData() {
        int selectedId = avaG.getCheckedRadioButtonId();
        avaB = (RadioButton) findViewById(selectedId);


        final String hospital_Name = hp_name.getText().toString().trim();
        final String TotalCost = cost.getText().toString().trim();
        final String address = location.getText().toString().trim();
        final String TBeds = beds.getText().toString().trim();

        final String hospital_admitted = admitted.getText().toString().trim();
        final String hospital_phno = phno.getText().toString().trim();
        final String hospital_email = email.getText().toString().trim();
        final String hospital_recovered = recovered.getText().toString().trim();

        final String total_Death = hp_death.getText().toString().trim();

        final String Hp_Availability = avaB.getText().toString().trim();


        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");



        if (hospital_Name.isEmpty()){
            Toast.makeText(getApplicationContext(),"Cant Empty Hospital Filed",Toast.LENGTH_SHORT).show();

        }else if (TotalCost.isEmpty()){
            Toast.makeText(getApplicationContext(),"Cant Empty Cost Filed",Toast.LENGTH_SHORT).show();

        }else if (address.isEmpty()){
            Toast.makeText(getApplicationContext(),"Cant Empty Address Filed",Toast.LENGTH_SHORT).show();

        }else if (hospital_admitted.isEmpty()){
            Toast.makeText(getApplicationContext()," Admited Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (hospital_phno.isEmpty()){
            Toast.makeText(getApplicationContext()," Phno Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (hospital_email.isEmpty()){
            Toast.makeText(getApplicationContext()," Email Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (hospital_recovered.isEmpty()){
            Toast.makeText(getApplicationContext()," Recovered Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (TBeds.isEmpty()){
            Toast.makeText(getApplicationContext()," Beds Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (total_Death.isEmpty()){
            Toast.makeText(getApplicationContext()," Death Filed Empty",Toast.LENGTH_SHORT).show();

        }else if (Hp_Availability.isEmpty()){
            Toast.makeText(getApplicationContext()," Have To Select Check Box Filed Empty",Toast.LENGTH_SHORT).show();

        }else


        {
            progressDialog.show();
            StringRequest request= new StringRequest(Request.Method.POST, "https://damitlucky.000webhostapp.com/hospital_insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
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
                    params.put("hp_name",hospital_Name);
                    params.put("total_cost",TotalCost);
                    params.put("beds",TBeds);
                    params.put("location",address);

                    params.put("admitted",hospital_admitted);
                    params.put("email",hospital_email);
                    params.put("phno",hospital_phno);
                    params.put("recovered",hospital_recovered);

                    params.put("total_death",total_Death);
                    params.put("availability",Hp_Availability);

                    return params;
                }
            };

            RequestQueue requestQueue= Volley.newRequestQueue(insertIntoList.this);
            requestQueue.add(request);
        }


    }

    public void moveToAdmin(View view) {
        Intent intent=new Intent(getApplicationContext(),AdminView.class);
        startActivity(intent);
    }
}
