package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.myrecyclerview);
        //create data set
        String names[]={
                        "John","Vimal","Xavier","Arul","David","Jonathan","Shana",
                        "Selvan","Jiju","Mavin","Biniga","Reshmika","Rithvik","Sevaraj",
                         "Suraj","Daniel","Bright","Sebastian","Vmax","Viswa","Raj",
                         "John","Vimal","Xavier","Arul","David","Jonathan","Shana",
                         "Selvan","Jiju","Mavin","Biniga","Reshmika","Rithvik","Sevaraj",
                          "Suraj","Daniel","Bright","Sebastian","Vmax","Viswa","Raj"
                       };
        final ArrayList<String> nameslist=new ArrayList<>(Arrays.asList(names));

        final MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(this,nameslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleAdapter.setClickListener(new MyRecycleAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"You clicked "+myRecycleAdapter.getItem(position),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(myRecycleAdapter);
    }
}