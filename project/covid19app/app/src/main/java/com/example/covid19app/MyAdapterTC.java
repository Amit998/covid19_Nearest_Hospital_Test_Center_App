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

public class MyAdapterTC extends ArrayAdapter<TestCenterName> {

    Context context;
    List<TestCenterName> arrayListTestCenter;

    public MyAdapterTC(@NonNull Context context, List<TestCenterName> arrayListTestCenter) {
        super(context, R.layout.custom_list_item,arrayListTestCenter);
        this.context=context;
        this.arrayListTestCenter=arrayListTestCenter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvTcId=view.findViewById(R.id.text_id);
        TextView tvTcName=view.findViewById(R.id.text_name);

        TextView tvFirst=view.findViewById(R.id.txt_first);
        TextView tvSecond=view.findViewById(R.id.txt_second);
        TextView tvThird=view.findViewById(R.id.txt_Third);

        tvTcId.setText(arrayListTestCenter.get(position).getTestCenterId());

        tvTcName.setText(arrayListTestCenter.get(position).getTcName());

        tvFirst.setText("No Of Test :"+arrayListTestCenter.get(position).getTested());

        tvSecond.setText("Total Cost :"+arrayListTestCenter.get(position).getCost());

        tvThird.setText("Currently: "+arrayListTestCenter.get(position).getAvailability());


        return view;
    }
}
