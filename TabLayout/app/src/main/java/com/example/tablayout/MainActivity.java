package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id
        tab=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);

        // now create three fragment

        //setup viewpager
        // create a java file for viewpagerMessengerAdapter

        // use this class by object
        viewPagerMessengerAdapter adapter=new viewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        // tab and viewPager syncronization
        tab.setupWithViewPager(viewPager);
    }
}