package com.example.ch01_basicsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Prj03_Bundle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prj03_bundle);

        // data fetch from main activity throgh bundle
        Intent fromAct=getIntent();
        String title=fromAct.getStringExtra("title");
        String studentname=fromAct.getStringExtra("StudentName");
        int rollno=fromAct.getIntExtra("Roll No",0);

        TextView txtStudentinfo;
        txtStudentinfo=findViewById(R.id.txtStudentInfo);
        txtStudentinfo.setText("RollNo:"+rollno+"Name:"+studentname);
        getSupportActionBar().setTitle(title);
    }
}