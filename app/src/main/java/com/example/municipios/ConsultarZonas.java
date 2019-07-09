package com.example.municipios;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Controllers.ZonasController;

import java.util.ArrayList;
import java.util.List;


public class ConsultarZonas extends Fragment {
    Spinner spnZonas;
    ListView lvZonas;
    MunicipiosController municipiosController;
    ZonasController zonasController;

    public ConsultarZonas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_consultar_zonas, container, false);

        spnZonas=view.findViewById(R.id.spn_consultar_zonas);
        lvZonas=view.findViewById(R.id.lv_consultar_zonas);

        zonasController= new ZonasController(getContext());
        List<String> zonasList = new ArrayList<String>();
        //cálido, semiárido, seco, templado, semifrio y frio)
        zonasList.add("Inundación");
        zonasList.add("Deslave");
        zonasList.add("Zona sísmica");
        zonasList.add("Incendio forestal");
        zonasList.add("Zona volcánica");
        zonasList.add("Derrumbes");


        ArrayAdapter<String> adapterClima = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, zonasList);
        spnZonas.setAdapter(adapterClima);

        spnZonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion = String.valueOf(spnZonas.getSelectedItemId());
                int op = Integer.parseInt(opcion);

                if(op==0){

                    ArrayList<String> municipios = zonasController.busquedaZonas("Inundación");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);
                }
                if(op==1){
                    ArrayList<String> municipios = zonasController.busquedaZonas("Deslave");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);

                }
                if(op==2){
                    ArrayList<String> municipios = zonasController.busquedaZonas("Zona sísmica");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);

                }
                if(op==3){
                    ArrayList<String> municipios = zonasController.busquedaZonas("Incendio forestal");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);

                }
                if(op==4){
                    ArrayList<String> municipios = zonasController.busquedaZonas("Zona volcánica");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);

                }
                if(op==5){
                    ArrayList<String> municipios = zonasController.busquedaZonas("Derrumbes");
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,municipios);
                    lvZonas.setAdapter(adaptador);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        // Inflate the layout for this fragment
        return view;
    }


}
