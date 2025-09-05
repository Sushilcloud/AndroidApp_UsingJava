package com.example.ch01_basicsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Prj01_BodyMassIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prj01_body_mass_index);
        EditText edtWeight,edtHeightFt,edtHeightIn;
        TextView txtResult;
        Button btnCalculate;

        //define variablefor layout
        LinearLayout liMain;

        //connect with them
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);

        // for color change accordingly weight
        liMain=findViewById(R.id.liMain);

        // now onclick method for button

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt= Integer.parseInt(edtWeight.getText().toString());
               int ft=Integer.parseInt(edtHeightFt.getText().toString());
               int in=Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn=ft*12+in;
               double totalCm=totalIn*2.53;
               double totalM=totalCm/100;
               double bmi=wt/(totalM*totalM);

               if(bmi>25)
               {
                   txtResult.setText("You are over weight");
                    liMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
               }else if(bmi<18){
                    txtResult.setText("You are Underweight");
                   liMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }else {
                   txtResult.setText("You are healthy");
                   liMain.setBackgroundColor(getResources().getColor(R.color.colorHL));
               }
            }
        });

    }
}