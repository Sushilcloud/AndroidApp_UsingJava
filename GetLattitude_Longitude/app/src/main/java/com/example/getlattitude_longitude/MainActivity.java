package com.example.getlattitude_longitude;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompatExtras;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION=1;

    Button getlocation;
    TextView showLocation;

    LocationManager locationManager;
    String latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add permission

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        showLocation=findViewById(R.id.show_location);
        getlocation=findViewById(R.id.get_location);

        getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

                // check gps is on or not
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                {
                    // write function to engable gps
                    onGPS();
                }
                else{
                    // GPS is already on then
                    getlocation();
                }
            }

            private void getlocation() {

                // check permission again
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                !=PackageManager.PERMISSION_GRANTED)
                {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                },REQUEST_LOCATION);


                }
                else{
                    Location LocationGPS=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    Location LocationNetwork=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    Location LocationPassive=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

                if(LocationGPS !=null)
                {
                    double lat=LocationGPS.getLatitude();
                    double longi=LocationGPS.getLongitude();

                    latitude=String.valueOf(lat);
                    longitude=String.valueOf(longi);

                    showLocation.setText("Your Location "+"\n"+"Latitude"+latitude+"\n"+"And"+"Longitude"+longitude);
                }
                else

                        if(LocationGPS !=null)
                        {
                            double lat=LocationNetwork.getLatitude();
                            double longi=LocationNetwork.getLongitude();

                            latitude=String.valueOf(lat);
                            longitude=String.valueOf(longi);

                            showLocation.setText("Your Location "+"\n"+"Latitude"+latitude+"\n"+"And"+"Longitude"+longitude);
                        }
                        else

                        if(LocationPassive !=null)
                        {
                            double lat=LocationPassive.getLatitude();
                            double longi=LocationPassive.getLongitude();

                            latitude=String.valueOf(lat);
                            longitude=String.valueOf(longi);

                            showLocation.setText("Your Location "+"\n"+"Latitude"+latitude+"\n"+"And"+"Longitude"+longitude);
                        }
                        else {

                            Toast.makeText(MainActivity.this,"Cant Get your location ",Toast.LENGTH_SHORT).show();
                        }
                    }
                }



            private void onGPS() {
            final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            final AlertDialog alertDialog=builder.create();
            alertDialog.show();

            }
        });
    }
}