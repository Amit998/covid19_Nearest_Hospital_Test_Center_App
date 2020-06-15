package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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

public class registrationActivity extends AppCompatActivity {

    EditText username,password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username=(EditText) findViewById(R.id.ed_username);
        password=(EditText) findViewById(R.id.ed_password);
        email=(EditText) findViewById(R.id.ed_email);





    }

    public void moveToLogin(View view) {
        Intent intent=new Intent(getApplicationContext(),loginActivity.class);
        startActivity(intent);
    }

    public void Register(View view) {
        final String RegUserName = username.getText().toString().trim();
        final String RegPassword = password.getText().toString().trim();
        final String RegEmail = email.getText().toString().trim();
        final String RegRole="user";
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");



        if (RegUserName.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter A Username",Toast.LENGTH_SHORT).show();
        }else if (RegEmail.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter A Email",Toast.LENGTH_SHORT).show();
        }else if (RegPassword.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter A Password",Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
        StringRequest request= new StringRequest(Request.Method.POST, "https://damitlucky.000webhostapp.com/insertReg.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Data Inserted")){
                            Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                            Intent intent=new Intent(getApplicationContext(),loginActivity.class);
                            startActivity(intent);
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
                params.put("username",RegUserName);
                params.put("role",RegRole);
                params.put("email",RegEmail);
                params.put("password",RegPassword);


                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(registrationActivity.this);
        requestQueue.add(request);
    }

    }

    public void moveToAdmin(View view) {
    }

    public void ADD(View view) {
    }


}
