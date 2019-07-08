package com.example.municipios;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.municipios.Controllers.MunicipiosController;
import com.example.municipios.Controllers.ZonasController;
import com.example.municipios.Modelos.Municipio;
import com.example.municipios.Modelos.ZonaRiesgo;

import java.util.ArrayList;
import java.util.List;


public class Modificar extends Fragment {
    Button btnModificar, btnCancelar, btnBuscar;
    TextView tvId, tvMunicipio, tvSignificado, tvCabecera, tvSuperficie, tvAltitud, tvBuscar;
    Spinner spClima;
    MunicipiosController municipiosController;
    ZonasController zonasController;
    CheckBox cbInundacion, cbDeslave, cbSismica, cbIncendio, cbVolcanica, cbDerrumbes;
    ZonaRiesgo dtInundacion, dtDeslave, dtSismica, dtIncendio, dtVolcanica, dtDerrumbes;


    public Modificar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_modificar, container, false);

        btnBuscar=view.findViewById(R.id.btn_mod_buscar);
        tvBuscar=view.findViewById(R.id.tv_mod_buscar);


        btnModificar= view.findViewById(R.id.btn_mod_guardar);
        tvId=view.findViewById(R.id.tv_mod_id);
        tvMunicipio=view.findViewById(R.id.tv_mod_municipio);
        tvSignificado=view.findViewById(R.id.tv_mod_significado);
        tvCabecera=view.findViewById(R.id.tv_mod_cabecera);
        tvSuperficie=view.findViewById(R.id.tv_mod_superficie);
        tvAltitud=view.findViewById(R.id.tv_mod_altitud);
        spClima=view.findViewById(R.id.sp_mod_clima);

        cbInundacion=view.findViewById(R.id.cb_mod_inundacion);
        cbDeslave=view.findViewById(R.id.cb_mod_deslave);
        cbSismica=view.findViewById(R.id.cb_mod_sismica);
        cbIncendio=view.findViewById(R.id.cb_mod_incendio);
        cbVolcanica=view.findViewById(R.id.cb_mod_volcanica);
        cbDerrumbes=view.findViewById(R.id.cb_mod_derrumbe);

        btnModificar.setVisibility(view.INVISIBLE);
        tvId.setVisibility(view.INVISIBLE);
        tvMunicipio.setVisibility(view.INVISIBLE);
        tvSignificado.setVisibility(view.INVISIBLE);
        tvCabecera.setVisibility(view.INVISIBLE);
        tvSuperficie.setVisibility(view.INVISIBLE);
        tvAltitud.setVisibility(view.INVISIBLE);
        spClima.setVisibility(view.INVISIBLE);
        cbInundacion.setVisibility(view.INVISIBLE);
        cbDeslave.setVisibility(view.INVISIBLE);
        cbSismica.setVisibility(view.INVISIBLE);
        cbIncendio.setVisibility(view.INVISIBLE);
        cbVolcanica.setVisibility(view.INVISIBLE);
        cbDerrumbes.setVisibility(view.INVISIBLE);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buscarS=tvBuscar.getText().toString();
                if("".equals(buscarS)){
                    tvBuscar.setError("Escribe el IGECEM");
                    tvBuscar.requestFocus();
                    return;
                }

                int idI;
                try {
                    idI = Integer.parseInt(tvBuscar.getText().toString());
                } catch (NumberFormatException e) {
                    tvBuscar.setError("Id es tipo entero");
                    tvBuscar.requestFocus();
                    return;
                }
                Municipio municipio= municipiosController.buscarMunicipio(idI);
                if(municipio==null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Error");
                    builder.setMessage("No se encontró el municipio");
                    builder.setPositiveButton("OK",null);
                    builder.create();
                    builder.show();


                }else {

                    List<String> climaList = new ArrayList<String>();
                    //cálido, semiárido, seco, templado, semifrio y frio)
                    climaList.add("Cálido");
                    climaList.add("Semiárido");
                    climaList.add("Seco");
                    climaList.add("Templado");
                    climaList.add("Semifrio");
                    climaList.add("Frio");

                    ArrayAdapter<String> adapterClima = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, climaList);
                    spClima.setAdapter(adapterClima);
                    spClima.setSelection(climaList.indexOf(municipio.getClima()));
                    btnModificar.setVisibility(view.VISIBLE);
                    tvId.setVisibility(view.VISIBLE);
                    tvMunicipio.setVisibility(view.VISIBLE);
                    tvSignificado.setVisibility(view.VISIBLE);
                    tvCabecera.setVisibility(view.VISIBLE);
                    tvSuperficie.setVisibility(view.VISIBLE);
                    tvAltitud.setVisibility(view.VISIBLE);
                    spClima.setVisibility(view.VISIBLE);
                    cbInundacion.setVisibility(view.VISIBLE);
                    cbDeslave.setVisibility(view.VISIBLE);
                    cbSismica.setVisibility(view.VISIBLE);
                    cbIncendio.setVisibility(view.VISIBLE);
                    cbVolcanica.setVisibility(view.VISIBLE);
                    cbDerrumbes.setVisibility(view.VISIBLE);

                    ArrayList<ZonaRiesgo> zonas = zonasController.obtenerZonas(municipio.getId());
                    for(int i=0; i<zonas.size();i++) {
                        switch (zonas.get(i).getDesastreNatural()) {
                            case ("Inundación"):
                                cbInundacion.setChecked(true);
                                dtInundacion = zonas.get(i);
                                break;
                            case ("Deslave"):
                                cbDeslave.setChecked(true);
                                dtDeslave = zonas.get(i);
                                break;
                            case ("Zona sísmica"):
                                cbSismica.setChecked(true);
                                dtSismica = zonas.get(i);
                                break;
                            case ("Incendio forestal"):
                                cbIncendio.setChecked(true);
                                dtIncendio = zonas.get(i);
                                break;
                            case ("Zona volcánica"):
                                cbVolcanica.setChecked(true);
                                dtVolcanica = zonas.get(i);
                                break;
                            case ("Derrumbes"):
                                cbDerrumbes.setChecked(true);
                                dtDerrumbes = zonas.get(i);
                                break;
                        }
                    }
                    tvId.setText(municipio.getId()+"");
                    tvMunicipio.setText(municipio.getMunicipio());
                    tvSignificado.setText(municipio.getSignificado());
                    tvCabecera.setText(municipio.getCabecera());
                    tvSuperficie.setText(municipio.getSuperficie()+"");
                    tvAltitud.setText(municipio.getAltitud()+"");
                    //spClima.setVisibility(view.VISIBLE);
                    //cbInundacion.setVisibility(view.VISIBLE);
                    //cbDeslave.setVisibility(view.VISIBLE);
                    //cbSismica.setVisibility(view.VISIBLE);
                    //cbIncendio.setVisibility(view.VISIBLE);
                    //cbVolcanica.setVisibility(view.VISIBLE);
                    //cbDerrumbes.setVisibility(view.VISIBLE);
                }

            }
        });

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
           /*   Municipio municipio= municipiosController.buscarMunicipio(4);
                System.out.println(municipio.getId()+"\n "+ municipio.getMunicipio()+"\n "+municipio.getSignificado()+municipio.getCabecera()
                        +"\n "+municipio.getSuperficie()+"\n "+municipio.getAltitud()+"\n "+municipio.getClima()+municipio.getLatitud()
                        +"\n "+municipio.getLongitud());

                ArrayList<ZonaRiesgo> zonas = zonasController.obtenerZonas(4);
                for(int i=0;i<zonas.size();i++){
                    System.out.println(zonas.get(i).getId()+"\n "+zonas.get(i).getIdMunicipio()+"\n "+zonas.get(i).getDesastreNatural());
                }
*/
            }


        });

        return view;
    }

}
