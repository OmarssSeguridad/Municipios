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
    Button btnModificar, btnCancelar, btnBuscar, btnMapa;
    TextView tvId, tvMunicipio, tvSignificado, tvCabecera, tvSuperficie, tvAltitud, tvBuscar;
    Spinner spClima;
    MunicipiosController municipiosController;
    ZonasController zonasController;
    CheckBox cbInundacion, cbDeslave, cbSismica, cbIncendio, cbVolcanica, cbDerrumbes;
    ZonaRiesgo dtInundacion, dtDeslave, dtSismica, dtIncendio, dtVolcanica, dtDerrumbes;
    Municipio municipio;


    public Modificar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_modificar, container, false);

        btnBuscar=view.findViewById(R.id.btn_mod_buscar);
        btnMapa=view.findViewById(R.id.btn_mod_mapa);
        btnCancelar=view.findViewById(R.id.btn_mod_cancelar);


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
        btnCancelar.setVisibility(view.INVISIBLE);
        btnMapa.setVisibility(view.INVISIBLE);
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

        municipiosController = new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());

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
                 municipio= municipiosController.buscarMunicipio(idI);
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
                    btnCancelar.setVisibility(view.VISIBLE);
                    btnMapa.setVisibility(view.VISIBLE);


                    ArrayList<ZonaRiesgo> zonas = zonasController.obtenerZonas(municipio.getId());
                    for(int i=0; i<zonas.size();i++) {
                        switch (zonas.get(i).getDesastreNatural()) {
                            case ("Inundación"):

                                cbInundacion.setChecked(true);
                                dtInundacion = zonas.get(i);
                                System.out.println("------------id "+dtInundacion.getId()+dtInundacion.getIdMunicipio()+dtInundacion.getDesastreNatural());
                                break;
                            case ("Deslave"):
                                System.out.println("----------------------Deslave");
                                cbDeslave.setChecked(true);
                                dtDeslave = zonas.get(i);
                                break;
                            case ("Zona sísmica"):
                                System.out.println("----------------------Sismica");
                                cbSismica.setChecked(true);
                                dtSismica = zonas.get(i);
                                break;
                            case ("Incendio forestal"):
                                System.out.println("----------------------Forestal");
                                cbIncendio.setChecked(true);
                                dtIncendio = zonas.get(i);
                                break;
                            case ("Zona volcánica"):
                                System.out.println("----------------------Volcanica");
                                cbVolcanica.setChecked(true);
                                dtVolcanica = zonas.get(i);
                                break;
                            case ("Derrumbes"):
                                System.out.println("----------------------Derrumbes");
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
                    btnModificar.setVisibility(view.INVISIBLE);
                    btnCancelar.setVisibility(view.INVISIBLE);
                    btnMapa.setVisibility(view.INVISIBLE);
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
                }

            }
        });



        btnModificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String  municipioS=tvMunicipio.getText().toString(), significado=tvSignificado.getText().toString(),
                        cabecera=tvCabecera.getText().toString(), superficie=tvSuperficie.getText().toString(), altitud=tvAltitud.getText().toString(),
                        clima=spClima.getSelectedItem().toString();

                if ("".equals(municipioS)) {
                    tvMunicipio.setError("Escribe el Municipio");
                    tvMunicipio.requestFocus();
                    return;
                }
                if ("".equals(significado)) {
                    tvSignificado.setError("Escribe el Significado");
                    tvSignificado.requestFocus();
                    return;
                }
                if ("".equals(cabecera)) {
                    tvCabecera.setError("Escribe la Cabecera");
                    tvCabecera.requestFocus();
                    return;
                }
                if ("".equals(superficie)) {
                    tvSuperficie.setError("Escribe la Superficie");
                    tvSuperficie.requestFocus();
                    return;
                }
                if ("".equals(altitud)) {
                    tvAltitud.setError("Escribe la Altitud");
                    tvAltitud.requestFocus();
                    return;
                }

                double superficieD, altitudD;

                try {
                    superficieD= Double.parseDouble(tvSuperficie.getText().toString());
                } catch (NumberFormatException e) {
                    tvSuperficie.setError("Superficie es tipo número");
                    tvSuperficie.requestFocus();
                    return;
                }

                try {
                    altitudD = Double.parseDouble(tvAltitud.getText().toString());
                } catch (NumberFormatException e) {
                    tvAltitud.setError("Altitud es tipo número");
                    tvAltitud.requestFocus();
                    return;
                }



                Municipio municipioModificar= new Municipio(municipio.getId(), municipioS,significado, cabecera,
                        superficieD,altitudD,clima,0,0);
                long id = municipiosController.guardarCambios(municipioModificar);
                if (id == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(getContext(), "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Error Guardar Municipio");
                } else {
                    // Terminar
                    ;
                    Toast.makeText(getContext(), "Se guardó correctamente", Toast.LENGTH_SHORT).show();
                    if(cbInundacion.isChecked()==true && dtInundacion==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Inundación");
                        zonasController.nuevaZona(zona);
                    }
                    if(cbInundacion.isChecked()!=true && dtInundacion!=null){
                        zonasController.eliminarZona(dtInundacion);
                    }


                    if(cbDeslave.isChecked()==true && dtInundacion==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Deslave");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbDeslave.isChecked()!=true && dtInundacion!=null){
                        zonasController.eliminarZona(dtDeslave);
                    }


                    if(cbSismica.isChecked()==true && dtSismica==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Zona sísmica");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbSismica.isChecked()!=true && dtSismica!=null){
                        zonasController.eliminarZona(dtSismica);
                    }

                    if(cbIncendio.isChecked()==true && dtIncendio==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Incendio forestal");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbIncendio.isChecked()!=true && dtIncendio!=null){
                        zonasController.eliminarZona(dtIncendio);
                    }


                    if(cbVolcanica.isChecked()==true && dtVolcanica==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Zona volcánica");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbVolcanica.isChecked()!=true && dtVolcanica!=null){
                        zonasController.eliminarZona(dtVolcanica);
                    }


                    if(cbDerrumbes.isChecked()==true && dtDerrumbes==null){
                        ZonaRiesgo zona = new ZonaRiesgo( municipio.getId(), "Derrumbes");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbDerrumbes.isChecked()!=true && dtDerrumbes!=null){
                        zonasController.eliminarZona(dtDerrumbes);
                    }


                    tvId.setText("");
                    tvMunicipio.setText("");
                    tvSignificado.setText("");
                    tvCabecera.setText("");
                    tvSuperficie.setText("");
                    tvAltitud.setText("");
                    spClima.setSelection(0);

                }

            }



        });

        return view;
    }

}
