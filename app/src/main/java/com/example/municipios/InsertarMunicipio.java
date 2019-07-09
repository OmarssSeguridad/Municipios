package com.example.municipios;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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


public class InsertarMunicipio extends Fragment {

    Button btnGuardar, btnCancelar, btnMapa;
    TextView tvId, tvMunicipio, tvSignificado, tvCabecera, tvSuperficie, tvAltitud;
    Spinner spClima;
    MunicipiosController municipiosController;
    ZonasController zonasController;
    CheckBox cbInundacion, cbDeslave, cbSismica, cbIncendio, cbVolcanica, cbDerrumbes;
    Intent mapa;

    public InsertarMunicipio() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insertar_municipio, container, false);
        btnGuardar= view.findViewById(R.id.btn_insertar_guardar);
        btnMapa=view.findViewById(R.id.btn_insert_mapa);
        tvId=view.findViewById(R.id.tv_insert_id);
        tvMunicipio=view.findViewById(R.id.tv_insert_municipio);
        tvSignificado=view.findViewById(R.id.tv_insert_significado);
        tvCabecera=view.findViewById(R.id.tv_insert_cabecera);
        tvSuperficie=view.findViewById(R.id.tv_insert_superficie);
        tvAltitud=view.findViewById(R.id.tv_insert_altitud);
        spClima=view.findViewById(R.id.sp_insert_clima);

        cbInundacion=view.findViewById(R.id.cb_insert_inundacion);
        cbDeslave=view.findViewById(R.id.cb_insert_deslave);
        cbSismica=view.findViewById(R.id.cb_insert_sismica);
        cbIncendio=view.findViewById(R.id.cb_insert_incendio);
        cbVolcanica=view.findViewById(R.id.cb_insert_volcanica);
        cbDerrumbes=view.findViewById(R.id.cb_insert_derrumbe);

        municipiosController = new MunicipiosController(getContext());
        zonasController = new ZonasController(getContext());


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

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> lista = new ArrayList<String>();
                lista.add(tvId.getText().toString());
                lista.add(tvMunicipio.getText().toString());
                lista.add(tvSignificado.getText().toString());
                lista.add(tvCabecera.getText().toString());
                lista.add(tvSuperficie.getText().toString());
                lista.add(tvAltitud.getText().toString());
                lista.add(spClima.getSelectedItem().toString());
                //Lo envío al activity
                mapa =new Intent(view.getContext(), MapsActivity.class);
                mapa.putStringArrayListExtra("lista",lista);
                startActivity(mapa);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idS=tvId.getText().toString(), municipioS=tvMunicipio.getText().toString(), significado=tvSignificado.getText().toString(),
                        cabecera=tvCabecera.getText().toString(), superficie=tvSuperficie.getText().toString(), altitud=tvAltitud.getText().toString(),
                        clima=spClima.getSelectedItem().toString();

                if ("".equals(idS)) {
                    tvId.setError("Escribe el IGECEM");
                    tvId.requestFocus();
                    return;
                }
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
                int idI;
                try {
                    idI = Integer.parseInt(tvId.getText().toString());
                } catch (NumberFormatException e) {
                    tvId.setError("Id es tipo entero");
                    tvId.requestFocus();
                    return;
                }

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


                    Toast.makeText(getContext(), "Se guardó correctamente", Toast.LENGTH_SHORT).show();

                    tvId.setText("");
                    tvMunicipio.setText("");
                    tvSignificado.setText("");


            }
        });
        return view;
    }
    public void CargaZonas()
    {
        if(cbInundacion.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Inundación");
            zonasController.nuevaZona(zona);

        }
        if(cbDeslave.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Deslave");
            long idZona = zonasController.nuevaZona(zona);

        }
        if(cbSismica.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Zona sísmica");
            long idZona = zonasController.nuevaZona(zona);

        }
        if(cbIncendio.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Incendio forestal");
            long idZona = zonasController.nuevaZona(zona);

        }
        if(cbVolcanica.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Zona volcánica");
            long idZona = zonasController.nuevaZona(zona);

        }
        if(cbDerrumbes.isChecked()==true)
        {
            ZonaRiesgo zona = new ZonaRiesgo( idI, "Derrumbes");
            long idZona = zonasController.nuevaZona(zona);

        }    }

}
