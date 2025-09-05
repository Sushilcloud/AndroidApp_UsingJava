package com.example.shiva.recyclerviewitemclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Model> main_list;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_list=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        main_list.add(new Model(R.drawable.orangeltr,"Orange Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.appleltr,"Apple  Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.mixltr,"Mix Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.mosambiltr,"Mosambi Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.apricotltr,"Apricot Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.cranberryltr,"Cranberry Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.grapeltr,"Grape Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.pineappleltr,"Pineapple Ltr", "Real Ltr"));
        main_list.add(new Model(R.drawable.pomegranateltr,"Pomegranate Ltr", "Real Ltr"));

        adapter=new CustomAdapter(main_list,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
