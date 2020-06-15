package com.example.covid19app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class hospital_list extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;

    public static ArrayList<HospitalName> hospitalArrayNames = new ArrayList<>();
    String url="https://damitlucky.000webhostapp.com/viewHospital.php";

    HospitalName hospitalName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);


        listView =findViewById(R.id.listView);
        adapter=new MyAdapter(this,hospitalArrayNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

//                Toast.makeText(this,"lol",Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),position,Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog=new ProgressDialog(view.getContext());
                startActivity(new Intent(getApplicationContext(),DetailHospitalActivity.class).putExtra("position",position));


//                CharSequence[] dialogItem={"view data","Edit Data","Delete Data"};
//                builder.setTitle(hospitalArrayNames.get(position).getHp_name());
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case 0:
//                                startActivity(new Intent(getApplicationContext(),DetailHospitalActivity.class).putExtra("position",position));
////                                Toast.makeText(getApplicationContext(),position,Toast.LENGTH_SHORT).show();
////                                Toast.makeText(getApplicationContext(),,Toast.LENGTH_SHORT).show();
//                                break;
//                            case 1:
//                                break;
//                            case 2:
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();

            }
        });
        retriveData();




    }
    public void retriveData(){
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hospitalArrayNames.clear();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String success=jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")){
                        for(int i=0; i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);

                            String id=object.getString("id");
                            String hospital_Name=object.getString("hp_name");
                            String TCost=object.getString("total_cost");
                            String Tbeds=object.getString("beds");
                            String Address=object.getString("location");

                            String hp_No_Admited=object.getString("admitted");
                            String hp_email=object.getString("email");
                            String hp_phno=object.getString("phno");
                            String hp_recovery=object.getString("recovered");

                            String total_death=object.getString("total_death");
                            String availability=object.getString("availability");

                            hospitalName = new HospitalName(id,hospital_Name,TCost,Tbeds,Address,hp_No_Admited,hp_email,hp_phno,hp_recovery,total_death,availability);

                            hospitalArrayNames.add(hospitalName);
                            adapter.notifyDataSetChanged();


                        }
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
