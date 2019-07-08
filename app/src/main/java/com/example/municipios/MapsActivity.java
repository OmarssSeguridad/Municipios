package com.example.municipios;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private final int REQUEST_ACCESS_FINE = 0;
    // private LatLngBounds MEX = new LatLngBounds(new LatLng(19.4839446,-99.6899716),new LatLng(19.4839446,-99.6899716));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        //mMap.setLatLngBoundsForCameraTarget(MEX);

        LatLng current = new LatLng(19.4839446,-99.6899716);

        mMap.addMarker(new MarkerOptions().position(current).title("Estoy aquí"));

        CameraPosition cameraPosition = CameraPosition.builder().target(current).zoom(8).build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_ACCESS_FINE
            );
            return;
        }
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);



        // Add a marker in Sydney and move the camera
        if(myLocation != null) {
            LatLng latlngMyLocation = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());


            mMap.addMarker(new MarkerOptions()
                    .position(latlngMyLocation)
                    .title("Mi ubicación")
                    .snippet("En clase")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            );
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlngMyLocation, 16));
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }

    }

    @Override
    public void onMapClick(LatLng latLng) {


        //Este es el plus
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        List<Address> address = null;
        try {
            address = geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(address != null){
            Address addr  = address.get(0);
            Toast.makeText(this,"Resultado: "+addr.getAddressLine(0),Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(this,"Latitud: "+latLng.latitude+" Longitud: "+ latLng.longitude,Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("Latitud",  String.valueOf(latLng.latitude));
        bundle.putString("Latitud",  String.valueOf(latLng.longitude));

        finish();
    }
}
