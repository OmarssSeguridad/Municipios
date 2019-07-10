package com.example.municipios;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Controllers.ZonasController;
import com.example.municipios.Modelos.Municipio;

import java.util.ArrayList;

public class ConsultarMunicipio extends Fragment {
    TextView tvBuscar;
    Button btnBuscar, btnMostrar;
    TextView datos;
    MunicipiosController municipiosController;
    Municipio municipio;
    ZonasController zonasController;
   int id;
    public ConsultarMunicipio() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_consultar_municipio, container, false);
        tvBuscar= view.findViewById(R.id.tv_conmunicipio);
        btnBuscar = view.findViewById(R.id.btnMunicipio);
        datos= view.findViewById(R.id.tv_consultar_municipios);
        btnMostrar = view.findViewById(R.id.btnmostrarmapa);
        btnMostrar.setVisibility(view.INVISIBLE);
        municipiosController = new MunicipiosController(getContext());
        zonasController= new ZonasController(getContext());
        //municipio=new Municipio();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buscarS=tvBuscar.getText().toString();

                if("".equals(buscarS)){
                    tvBuscar.setError("Escribe el IGECEM o nombre del municipio");
                    tvBuscar.requestFocus();
                    return;
                }
               try {
                    id = Integer.parseInt(tvBuscar.getText().toString());
                } catch (NumberFormatException e) {
                    tvBuscar.setError("IGECEM es tipo entero");
                    tvBuscar.requestFocus();
                    return;
                }
                municipio=municipiosController.buscarMunicipio(id);
                if(municipio.getId()==0){
                    Toast.makeText(getContext(),"No se encontró el municipio",Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> listaZonas= municipiosController.obtenerZonas(id);
                    String zonas="";
                    for(int i=0;i<listaZonas.size();i++){
                        zonas+="\t\t\t\t\t*"+listaZonas.get(i);
                    }
                    datos.setText("\t\t\t\t\tIGECEM: "+municipio.getId()+"\r\n"+
                    "\t\t\t\t\tMunicipio: "+municipio.getMunicipio()+"\r\n"+
                     "\t\t\t\t\tSignificado: "+municipio.getSignificado()+"\r\n"+
                            "\t\t\t\t\tCabecera: "+municipio.getCabecera()+"\r\n"+
                            "\t\t\t\t\tSuperficie: "+municipio.getSuperficie()+"\r\n"+
                            " \t\t\t\t\tAltitud: "+municipio.getAltitud()+"\r\n"+
                            " \t\t\t\t\tClima: "+municipio.getClima()+"\r\n"+
                            " \t\t\t\t\tZonas de riesgo: \r\n"+zonas
                    );
                    btnMostrar.setVisibility(view.VISIBLE);
                }

                btnMostrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), MostrarMapa.class);
                        intent.putExtra("latitud",municipio.getLatitud());
                        intent.putExtra("longitud",municipio.getLongitud());
                        startActivity(intent);
                    }
                });
            }

        });


        return  view;
    }

}
