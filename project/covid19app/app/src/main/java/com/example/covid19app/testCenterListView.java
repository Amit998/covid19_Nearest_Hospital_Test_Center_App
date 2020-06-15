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

public class testCenterListView extends AppCompatActivity {

    ListView listViewTC;
    MyAdapterTC adapterTC;

    public static ArrayList<TestCenterName> testCenterNames=new ArrayList<>();
    String urlTc="https://damitlucky.000webhostapp.com/viewTestCenter.php";

    TestCenterName testCenterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_center_list_view);


        listViewTC=findViewById(R.id.myTCListView);
        adapterTC = new MyAdapterTC(this,testCenterNames);

        listViewTC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());

                ProgressDialog progressDialog=new ProgressDialog(view.getContext());
                startActivity(new Intent(getApplicationContext(),TestCenterList.class).putExtra("position",position));

//                CharSequence[] dialogItem={"View Data","Edit Data","Delete Data"};
//                builder.setTitle(testCenterNames.get(position).getTcName());
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case 0:
////                                startActivity(new Intent(getApplicationContext(),TestCenterList.class).putExtra("position",position));
//                                break;
//                            case 1:
//                                break;
//                            case 2:
//                                break;
//                        }
//
//                    }
//                });
//
//                builder.create().show();
            }
        });


        retiveTCData();

        listViewTC.setAdapter(adapterTC);

    }

    private void retiveTCData(){
        StringRequest request=new StringRequest(Request.Method.POST, urlTc, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                testCenterNames.clear();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String success=jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")){
                        for(int i=0; i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);

                            String testCenterId=object.getString("testCenterId");
                            String tcName=object.getString("testCenterName");
                            String availability=object.getString("availability");
                            String cost=object.getString("cost");
                            String tested=object.getString("tested");

                            String email=object.getString("email");
                            String phno=object.getString("phno");
                            String address=object.getString("address");
                            String successRate=object.getString("successRate");

                            testCenterName=new TestCenterName(testCenterId,tcName,availability,cost,tested,email,phno,address,successRate);
                            testCenterNames.add(testCenterName);
                            adapterTC.notifyDataSetChanged();



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
