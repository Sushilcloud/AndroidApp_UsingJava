package com.example.ch01_basicsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Android_Tutorial extends AppCompatActivity {

    Button btnFirst,btnBmi,btnTicTac,btnBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_tutorial);

        btnFirst=findViewById(R.id.btn_first);
        btnBmi=findViewById(R.id.btn_bmi);
        btnTicTac=findViewById(R.id.btn_tictac);
        btnBundle=findViewById(R.id.btn_bundle);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Android_Tutorial.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Android_Tutorial.this,Prj01_BodyMassIndex.class);
                startActivity(intent);
            }
        });

        btnTicTac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Android_Tutorial.this,Prj02_TicTac.class);
                startActivity(intent);
            }
        });



        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Android_Tutorial.this,Prj03_Bundle.class);
                intent.putExtra("title","Home");
                intent.putExtra("StudentName","Sushil Godiyal");
                intent.putExtra("Roll No",10);
                startActivity(intent);
            }
        });
    }
}