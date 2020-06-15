package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class loginActivity extends AppCompatActivity {
    EditText ed_email,ed_password;
    Spinner mySpinner;
    String url="https://damitlucky.000webhostapp.com/loginHospital.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email=findViewById(R.id.ed_email);
        ed_password=findViewById(R.id.ed_password);

        mySpinner=(Spinner) findViewById(R.id.mySpinner);

        String[] UserRole=getResources().getStringArray(R.array.role);
        ArrayAdapter adapterRole=new ArrayAdapter(this,android.R.layout.simple_spinner_item,UserRole);
        adapterRole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapterRole);


    }

    public void Login(View view) {




        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        if (ed_email.getText().toString().equals("")){
            Toast.makeText(this,"Enter Email Please",Toast.LENGTH_SHORT).show();
        }else if (ed_password.getText().toString().equals("")){
            Toast.makeText(this,"Enter Email Please",Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
            final String str_email=ed_email.getText().toString().trim();
            final String str_password=ed_password.getText().toString().trim();
            final String str_Role=mySpinner.getSelectedItem().toString().toLowerCase().trim();

            StringRequest request= new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ed_email.setText("");
                            ed_password.setText("");

//                            Log.i("response",response);

                            progressDialog.dismiss();



                            if (response.trim().equalsIgnoreCase("admin")){
//                                Toast.makeText(getApplicationContext(),"Admin",Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(getApplicationContext(),AdminView.class);
                                startActivity(intent);

                            }else if (response.trim().equalsIgnoreCase("user")){
                                Intent intent=new Intent(getApplicationContext(),TcAndHpView.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(getApplicationContext(),"You Need To Register YourSelf",Toast.LENGTH_SHORT).show();
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
                    params.put("email",str_email);
                    params.put("password",str_password);
                    params.put("role",str_Role);
                    return params;
                }
            };

            RequestQueue requestQueue= Volley.newRequestQueue(loginActivity.this);
            requestQueue.add(request);



        }
    }

    public void moveToRegistration(View view) {
        Intent intent=new Intent(getApplicationContext(),registrationActivity.class);
        startActivity(intent);
    }
}
