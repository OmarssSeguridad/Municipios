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

public class EliminarMunicipio extends Fragment {

    Button btnEliminar;
    MunicipiosController municipiosController;
    ZonasController zonasController;

    public EliminarMunicipio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_eliminar_municipio, container, false);
        btnEliminar= view.findViewById(R.id.btn_eliminar);
        municipiosController = new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long id = municipiosController.eliminarMunicipio(2);


            }
        });
        return view;
    }

}
