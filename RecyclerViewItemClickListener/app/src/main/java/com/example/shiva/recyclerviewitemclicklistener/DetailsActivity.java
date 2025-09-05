package com.example.shiva.recyclerviewitemclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name,role;
    String imagename,brand;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView=findViewById(R.id.image);
        name=findViewById(R.id.name);
        role=findViewById(R.id.role);

        imagename=getIntent().getStringExtra("name");
        brand=getIntent().getStringExtra("role");
        image=getIntent().getIntExtra("image",0);
        name.setText(imagename);
        role.setText(brand);
        imageView.setImageResource(image);

    }
}
