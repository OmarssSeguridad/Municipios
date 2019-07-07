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

import java.util.ArrayList;


public class Modificar extends Fragment {
    MunicipiosController municipiosController;
    ZonasController zonasController;
    Button btnModificar;
    Municipio municipio;

    public Modificar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_modificar, container, false);

        btnModificar= view.findViewById(R.id.btn_modificar);
        municipiosController = new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());
        btnModificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              /*  Municipio municipio=new Municipio(1,"MEtepexMod","s","sdfd",12,1123,"Frio",23,23);

                int filasModificadas = municipiosController.guardarCambios(municipio);
                if (filasModificadas != 1) {
                    // De alguna forma ocurrió un error porque se debió modificar únicamente una fila
                    Toast.makeText(getContext(), "Error guardando cambios. Intente de nuevo.", Toast.LENGTH_SHORT).show();
                } else {


                    // Si las cosas van bien, volvemos a la principal
                    // cerrando esta actividad
                    Toast.makeText(getContext(), "Se guardaron los cambios", Toast.LENGTH_SHORT).show();

                }

                */
              Municipio municipio= municipiosController.buscarMunicipio(4);
                System.out.println(municipio.getId()+"\n "+ municipio.getMunicipio()+"\n "+municipio.getSignificado()+municipio.getCabecera()
                        +"\n "+municipio.getSuperficie()+"\n "+municipio.getAltitud()+"\n "+municipio.getClima()+municipio.getLatitud()
                        +"\n "+municipio.getLongitud());

                ArrayList<ZonaRiesgo> zonas = zonasController.obtenerZonas(4);
                for(int i=0;i<zonas.size();i++){
                    System.out.println(zonas.get(i).getId()+"\n "+zonas.get(i).getIdMunicipio()+"\n "+zonas.get(i).getDesastreNatural());
                }

            }


        });

        return view;
    }

}
