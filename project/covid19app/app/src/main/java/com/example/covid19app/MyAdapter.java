package com.example.covid19app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<HospitalName>  {

    Context context;
    List<HospitalName> arrayHospitalName;

    public MyAdapter(@NonNull Context context, List<HospitalName> arrayHospitalName) {
        super(context, R.layout.custom_list_item,arrayHospitalName);
        this.context=context;
        this.arrayHospitalName=arrayHospitalName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID=view.findViewById(R.id.text_id);
        TextView tvName=view.findViewById(R.id.text_name);

        TextView tvFirst=view.findViewById(R.id.txt_first);
        TextView tvSecond=view.findViewById(R.id.txt_second);
        TextView tvThird=view.findViewById(R.id.txt_Third);

        tvID.setText(arrayHospitalName.get(position).getId());

        tvName.setText(arrayHospitalName.get(position).getHp_name());

        tvFirst.setText("Total Beds :"+arrayHospitalName.get(position).getBeds());

        tvSecond.setText("Total Recoverd :"+arrayHospitalName.get(position).getRecovered());

        tvThird.setText("Cost: "+arrayHospitalName.get(position).getCosts());




        return view;
    }
}
