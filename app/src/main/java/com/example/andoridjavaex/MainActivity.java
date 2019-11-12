package com.example.andoridjavaex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.andoridjavaex.databinding.ActivityMainBinding;
import com.example.andoridjavaex.mvpexample.loginex.MVPLoginActivity;
import com.example.andoridjavaex.mvpexample.quotexexample.MVPQuotesActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityMainBinding mBinding;
    TreeMap<String, Intent> intentHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setData();
    }

    String[] getListArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add("MVP Login Example");
        return list.toArray(new String[list.size()]);
    }

    void setData() {
        intentHashMap = new TreeMap<>();
        //map keys to list
        //List<String> keys = new ArrayList<>(intentHashMap.keySet());
        //map values to list
        //List<Intent> values = new ArrayList<>(intentHashMap.values());

        intentHashMap.put("1. MVP Login Example", new Intent(this, MVPLoginActivity.class));
        intentHashMap.put("2. MVP Quotes Example", new Intent(this, MVPQuotesActivity.class));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>(intentHashMap.keySet()).toArray(new String[intentHashMap.size()]));
        mBinding.listView.setAdapter(adapter);
        mBinding.listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(this, mBinding.listView.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
        startActivity(intentHashMap.get(mBinding.listView.getAdapter().getItem(position).toString()));
    }
}
