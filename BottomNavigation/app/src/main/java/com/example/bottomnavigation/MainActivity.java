package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView=findViewById(R.id.botmView);

        // create fragment

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();

                if(id==R.id.nav_home){
                    loadFrag(new AFragment(),false);
                }else if(id==R.id.nav_contactus){
                    loadFrag(new BFragment(),false);
                }if(id==R.id.nav_contactus){
                    loadFrag(new CFragment(),false);
                }if(id==R.id.nav_search){
                    loadFrag(new AFragment(),false);
                }else{
                    loadFrag(new EFragment(),true);
                }


                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_myprofile);

    }

    public void loadFrag(Fragment fragment,boolean flag)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.cont, fragment);
       else
            ft.replace(R.id.cont, fragment);
            ft.commit();

    }
}