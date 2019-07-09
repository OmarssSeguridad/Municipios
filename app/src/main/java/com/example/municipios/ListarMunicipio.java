package com.example.municipios;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.ArrayRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Controllers.ZonasController;
import com.example.municipios.Modelos.Municipio;

import java.util.ArrayList;


public class ListarMunicipio extends Fragment {
    MunicipiosController municipiosController;
    ZonasController zonasController;

    public ListarMunicipio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_municipio, container, false);
        ListView l = (ListView)view.findViewById(R.id.lv_municipios);

        municipiosController=new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());
        ArrayList<String> municipios = municipiosController.obtenerMunicipios();

       // ArrayList<String> zonas = zonasController.obtenerZonas(2);
       // ArrayList<String> reg = sqlite.getAnimal(cursor);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
        l.setAdapter(adaptador);

        return view;
    }

}
