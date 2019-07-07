package com.example.municipios;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Controllers.ZonasController;
import com.example.municipios.Modelos.Municipio;
import com.example.municipios.Modelos.ZonaRiesgo;


public class InsertarMunicipio extends Fragment {

    Button btnGuardar;
    MunicipiosController municipiosController;
    ZonasController zonasController;
    public InsertarMunicipio() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insertar_municipio, container, false);
        btnGuardar= view.findViewById(R.id.btn_insertar_guardar);
        municipiosController = new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Municipio municipio= new Municipio(4, "Metepec","Cerro de los magueyes", "Metepec",
                        123.23,134,"Cálido",1323,123);
                long id = municipiosController.nuevoMunicipio(municipio);
                if (id == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(getContext(), "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Error Guardar Municipio");
                } else {
                    // Terminar
                    ;
                    Toast.makeText(getContext(), "Se guardó correctamente", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Bien Guardar Municipio");

                }

                ZonaRiesgo zona = new ZonaRiesgo( 4, "Volcanes");
                long idZona = zonasController.nuevaZona(zona);
                if (idZona == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(getContext(), "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Error Guardar Zona");
                } else {
                    // Terminar
                    ;
                    Toast.makeText(getContext(), "Se guardó correctamente", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Bien Guardar Zona");

                }

            }
        });
        return view;
    }


}
