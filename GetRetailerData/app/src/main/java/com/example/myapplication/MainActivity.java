package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.apache.commons.lang3.text.WordUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    EditText editTextRetailerName, editTextContactNumber, editTextPersonName;
    TextView textViewDisplayInfo;

    private TextView locationTextView,addressTextView;;
    private Button getLocationButton;
    private FusedLocationProviderClient fusedLocationClient;
    private Spinner dropdown;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRetailerName = findViewById(R.id.editTextRetailerName);
        editTextContactNumber = findViewById(R.id.editTextContactNumber);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        // textViewDisplayInfo = findViewById(R.id.locationTextView);

        // for town name
        dropdown = findViewById(R.id.spn_myTownName);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.townlist, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        // for Stockiest name
        dropdown = findViewById(R.id.spn_StockiestName);
        ArrayAdapter<CharSequence>adapterStockiestName=ArrayAdapter.createFromResource(this,R.array.stockiestname, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapterStockiestName);


        // for Stockiest Code
        dropdown = findViewById(R.id.spn_StockiestCode);
        ArrayAdapter<CharSequence>adapterStockiestCode=ArrayAdapter.createFromResource(this,R.array.stockiestcode, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapterStockiestCode);


        // for location
        locationTextView = findViewById(R.id.locationTextView);
        addressTextView = findViewById(R.id.address_text);
        getLocationButton = findViewById(R.id.getLocationButton);


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        getLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLocationPermission();
            }
        });
    }

    public void displayInformation(View view) {
        String retailerName = WordUtils.capitalizeFully(editTextRetailerName.getText().toString());
        String contactNumber = editTextContactNumber.getText().toString();
        String personName = WordUtils.capitalizeFully(editTextPersonName.getText().toString());


        String displayText = "Retailer Information:\n" +
                "Retailer Name: " + retailerName + "\n" +
                "Contact Number: " + contactNumber + "\n" +
                "Person Name: " + personName;

        textViewDisplayInfo.setText(displayText);
    }

    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE
            );
        } else {
            getLastLocation();
        }
    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String address = getAddress(location);
                            locationTextView.setText("Location: " + location.getLatitude() + ", " + location.getLongitude() );
                            addressTextView.setText("Address: " + address);
                        } else {
                            locationTextView.setText("Location not available");
                            addressTextView.setText("Address not available");
                        }
                    }
                });
    }




    private String getAddress(Location location) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                return address.getAddressLine(0) != null ? address.getAddressLine(0) : "No address found";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error getting address";
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            } else {
                locationTextView.setText("Location permission denied");
            }
        }
    }
}

