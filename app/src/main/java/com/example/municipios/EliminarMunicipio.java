package com.example.municipios;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.municipios.Modelos.ZonaRiesgo;

public class EliminarMunicipio extends Fragment {

    Button btnEliminar;
    MunicipiosController municipiosController;
    ZonasController zonasController;

    Municipio municipio;
    TextView tvEliminar;
    int idI;
    public EliminarMunicipio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_eliminar_municipio, container, false);
        btnEliminar= view.findViewById(R.id.btn_eliminar);
        tvEliminar=view.findViewById(R.id.tv_Eliminar);
        municipio=new Municipio();

        municipiosController = new MunicipiosController(getContext());
      //  zonasController = new ZonasController(getContext());

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buscarS=tvEliminar.getText().toString();
                if("".equals(buscarS)){
                    tvEliminar.setError("Escribe el IGECEM");
                    tvEliminar.requestFocus();
                    return;
                }


                try {
                    idI = Integer.parseInt(tvEliminar.getText().toString());
                } catch (NumberFormatException e) {
                    tvEliminar.setError("Id es tipo entero");
                    tvEliminar.requestFocus();
                    return;
                }
                municipio= municipiosController.buscarMunicipio(idI);
                if(municipio.getId()==0){
                    Toast.makeText(getContext(),"No se encontró el municipio",Toast.LENGTH_SHORT).show();
                }else {

                    AlertDialog dialog = new AlertDialog
                            .Builder(getContext())
                            .setPositiveButton("Sí, eliminar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    municipiosController.eliminarMunicipio(idI);
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setTitle("Confirmar")
                            .setMessage("¿Eliminar el municipio de " + municipio.getMunicipio() + "?")
                            .create();
                    dialog.show();

                }
            }
        });
        return view;
    }

}
