package com.example.municipios;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Modelos.Municipio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private final int REQUEST_ACCESS_FINE = 0;
    Button guardar;
    Bundle registro;
    LatLng latLng;
    Intent intent;
    private ArrayList<String> lista;
    String lat, longt;
    MunicipiosController municipiosController;
    Municipio municipio;
    int idMunicipio;
    String municipioS;
    String significado;
    String cabecera;
    Double superficie;
    Double altitud;
    String clima;
    String vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        guardar = findViewById(R.id.btn_guadar_modTotal);

        // Recuperar datos que enviaron
        Bundle extras = getIntent().getExtras();
        // Si no hay datos (cosa rara) salimos
        if (extras == null) {
            finish();
            return;
        }
        // Instanciar el controlador de las mascotas
        municipiosController = new MunicipiosController(MapsActivity.this);

        // Rearmar la mascota
        // Nota: igualmente solamente podríamos mandar el id y recuperar la mascota de la BD
        idMunicipio = extras.getInt("idmunicipio");
        municipioS = extras.getString("municipio");
        significado = extras.getString("significado");
        cabecera = extras.getString("cabecera");
        superficie = extras.getDouble("superficie");
        altitud = extras.getDouble("altitud");
        clima = extras.getString("clima");
        vista= extras.getString("vista");
        //String lat


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        LatLng current = new LatLng(19.4839446, -99.6899716);

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
        if (myLocation != null) {
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
    public void onMapClick(final LatLng latLng) {
        //Este es el plus
        lat = String.valueOf(latLng.latitude);
        longt = String.valueOf(latLng.longitude);
        //Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        List<Address> address = null;
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng));

        if (address != null) {
            Address addr = address.get(0);
            Toast.makeText(this, "Resultado: " + addr.getAddressLine(0), Toast.LENGTH_SHORT).show();
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                municipio = new Municipio(idMunicipio, municipioS, significado, cabecera, superficie, altitud, clima, Double.parseDouble(lat), Double.parseDouble(longt));
               long id= municipiosController.guardarCambios(municipio);
                if (id == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(MapsActivity.this, "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                } else {
                    // Terminar
                    ;
                    Toast.makeText(MapsActivity.this, "Se guardó correctamente ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MapsActivity.this, MenuActivity.class);
                        startActivity(intent);
                }
            }
        });

    }

}
