package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class InsertIntoTestCenter extends AppCompatActivity {
    private RadioGroup avaG;
    private RadioButton avaB;
    private EditText tc_td_name,tc_td_cost,tc_td_tested,tc_td_email,tc_td_phno,tc_td_successRate,tc_td_Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_test_center);
        avaG=findViewById(R.id.Availability);
        tc_td_name=findViewById(R.id.tc_ed_name);
        tc_td_tested=findViewById(R.id.tc_ed_Tested);
        tc_td_cost=findViewById(R.id.tc_ed_cost);
        tc_td_email=findViewById(R.id.tc_ed_email);


        tc_td_phno=findViewById(R.id.tc_ed_phno);
        tc_td_successRate=findViewById(R.id.tc_ed_successRate);
        tc_td_Address=findViewById(R.id.tc_ed_Address);




    }
    public void moveToAdmin(View view) {
        Intent intent=new Intent(getApplicationContext(),AdminView.class);
        startActivity(intent);
    }
    public void ADD(View view) {
        int selectedId = avaG.getCheckedRadioButtonId();
        avaB = (RadioButton) findViewById(selectedId);

        final String Test_Center_Name = tc_td_name.getText().toString().trim();
        final String Test_Center_Tested = tc_td_tested.getText().toString().trim();
        final String Test_Center_Cost = tc_td_cost.getText().toString().trim();
        final String Test_Center_Email = tc_td_email.getText().toString().trim();
        final String Test_Center_Phno = tc_td_phno.getText().toString().trim();
        final String Test_Center_SR = tc_td_successRate.getText().toString().trim();
        final String Test_Center_Address = tc_td_Address.getText().toString().trim();
        final String Test_Center_Available = avaB.getText().toString().trim();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if (Test_Center_Name.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Name",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_Tested.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Test Number",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_Cost.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Cost",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_Email.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Email",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_Phno.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Phone Number",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_SR.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Success Rate",Toast.LENGTH_SHORT).show();
        }else if (Test_Center_Address.isEmpty()){
            Toast.makeText(InsertIntoTestCenter.this,"You Need To Insert Address",Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.show();
            StringRequest request= new StringRequest(Request.Method.POST, "https://damitlucky.000webhostapp.com/TestCenter_Inser.php",
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
                    params.put("testCenterName",Test_Center_Name);
                    params.put("availability",Test_Center_Available);
                    params.put("cost",Test_Center_Cost);
                    params.put("tested",Test_Center_Tested);

                    params.put("email",Test_Center_Email);
                    params.put("phno",Test_Center_Phno);
                    params.put("address",Test_Center_Address);
                    params.put("successRate",Test_Center_SR);


                    return params;
                }
            };

            RequestQueue requestQueue= Volley.newRequestQueue(InsertIntoTestCenter.this);
            requestQueue.add(request);
        }

    }
}
