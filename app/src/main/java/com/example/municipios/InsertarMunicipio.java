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
import java.util.Random;


public class InsertarMunicipio extends Fragment {

    Button btnGuardar, btnCancelar, btnMasivo;
    TextView tvId, tvMunicipio, tvSignificado, tvCabecera, tvSuperficie, tvAltitud;
    Spinner spClima;
    MunicipiosController municipiosController;
    ZonasController zonasController;
    CheckBox cbInundacion, cbDeslave, cbSismica, cbIncendio, cbVolcanica, cbDerrumbes;
    public InsertarMunicipio() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insertar_municipio, container, false);
        btnGuardar= view.findViewById(R.id.btn_insertar_guardar);
        btnMasivo= view.findViewById(R.id.btnMasivo);
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
        btnMasivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Municipio municipio;
                ZonaRiesgo zonaRiesgo;
                ZonaRiesgo zonaRiesgo2;
                municipio=new Municipio(1,"Acambay", "Okha «Dios» y mbaye «peñasco»: «Peñascos de Dios».", "Acambay",465.7,465.7, "Cálido",19.9958,-99.8417); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(2,"Acolman", "Aculli «hombre», máitl «mano»: «Hombre con mano o brazo».", "Acolman de Nezahualcóyotl",83.95,83.95, "Semiárido",19.3998,-98.884); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(3,"Aculco", "Atl «agua», cóltic «torcido» y co «en»: «En el agua torcida».", "Aculco de Espinosa",453.26,453.26, "Seco",20.0990629,-99.8272712); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(4,"Almoloya de Alquisiras", "Atl «agua», molloni «manar» y yan «lugar»: «Lugar donde mana el agua». Nombrado en honor al insurgente Pedro Ascencio Alquisiras.", "Almoloya de Alquisiras",182.65,182.65, "Templado",18.8664837,-99.9001158); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(5,"Almoloya de Juárez", "Atl «agua», molloni «manar» y yan «lugar»: «Lugar donde mana el agua». Nombrado en honor al presidente Benito Juárez.", "Villa de Almoloya de Juárez",485.21,485.21, "Semifrio",18.8665041,-99.9001158); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(6,"Almoloya del Río", "Atl «agua», molloni «manar» y yan «lugar»: «Lugar donde mana el agua».", "Almoloya del Río",16.53,16.53, "Frio",19.16397,-99.4891727); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(7,"Amanalco", "Atl «agua», manalli «estar tendido» y co «en»: «En el estanque».", "Amanalco de Becerra",222.27,222.27, "Seco",19.2543187,-100.0239514); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(8,"Amatepec", "Amatl «amate o árbol de papel», tepetl «cerro» y co «en»: «En el cerro de los amates o árboles de papel».", "Amatepec",638.55,638.55, "Templado",18.6996269,-100.3862512); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(9,"Amecameca", "Amatl «papel», queme «señalar» y can «lugar»: «Lugar donde los papeles señalan».", "Amecameca de Juárez",189.48,189.48, "Semifrio",19.1257243,-98.7843978); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(10,"Apaxco", "Atl «agua» y patzca «exprimir»: «Donde se exprime o escurre el agua».", "Apaxco de Ocampo",75.73,75.73, "Frio",19.9833,-99.1667); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(11,"Atenco", "Atl «agua», entli «orilla» y co «en»: «En la orilla del agua».", "San Salvador Atenco",83.8,83.8, "Cálido",19.5514,-98.9161); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(12,"Atizapán", "Atl «agua», tizatl «tierra o cosa blanca» y pan «sobre»: «En el agua o tierra blanca».", "Santa Cruz Atizapán",6.92,6.92, "Semiárido",19.1770714,-99.4945791); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(13,"Atizapán de Zaragoza", "Atl «agua», tizatl «tierra o cosa blanca» y pan «sobre»: «En el agua o tierra blanca». Nombrado en honor al general Ignacio Zaragoza.", "Ciudad López Mateos",91.07,91.07, "Seco",19.517983,-99.3609684); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(14,"Atlacomulco", "Atlacomulli «pozo» y co «en»: «En los pozos».", "Atlacomulco de Fabela",267.89,267.89, "Templado",19.7980556,-99.89317); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(15,"Atlautla", "Atlautli «barranca», tla «abundancia»: «Donde abundan las barrancas».", "Atlautla de Victoria",162.06,162.06, "Semifrio",19.03012,-98.7894974); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(16,"Axapusco", "Atl «agua», xapochtli «aljibe»: «En el aljibe de agua».", "Axapusco",230.94,230.94, "Frio",19.7252565,-98.7621809); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(17,"Ayapango", "Ayáhuitl «neblina», pan «sobre» y co «lugar»: «Lugar de neblinas en las alturas».", "Ayapango de Gabriel Ramos Millán",36.41,36.41, "Cálido",19.1266022,-98.8136491); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(18,"Calimaya", "Calli «casa», máitl «mano» y yan «lugar»: «Lugar en que se construyen casas».", "Calimaya de Díaz González",101.19,101.19, "Semiárido",19.1687371,-99.635865); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(19,"Capulhuac", "Capulli «capulín» y apan «canal»: «En el canal de capulines».", "Capulhuac de Mirafuentes",32.25,32.25, "Seco",19.2169304,-99.4562818); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(20,"Coacalco de Berriozábal", "Coatl «serpiente», calli «casa» y co «lugar»: «En la casa de la serpiente». Nombrado en honor al gobernador Felipe Berriozábal.", "San Francisco Coacalco",35.1,35.1, "Templado",19.6262642,-99.1006278); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(21,"Coatepec Harinas", "Coatl «serpiente» y tepetl «cerro»: «Cerro de las serpientes». Se le denominó «Harinas» por la producción de este producto en el municipio.", "Coatepec Harinas",282.36,282.36, "Semifrio",18.9223599,-99.7676931); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(22,"Cocotitlán", "Cocoh «tórtola», titlán «junto o entre»: «Lugar de tórtolas».", "Cocotitlán",14.86,14.86, "Frio",19.232597,-98.8642108); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(23,"Coyotepec", "Coyotl «coyote», tepetl «cerro» y co «en»: «En el cerro del coyote».", "Coyotepec",49.32,49.32, "Cálido",19.7765924,-99.2092896); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(24,"Cuautitlán", "Cuáhutli «árbol» y titlán «junto o entre»: «Entre los árboles».", "Cuautitlán",26.32,26.32, "Semiárido",19.6726588,-99.1648692); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(25,"Chalco", "Challi «borde de lago» y co «en»: «En el borde del lago»", "Chalco de Díaz Covarrubias",219.22,219.22, "Seco",19.26244,-98.8969427); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(26,"Chapa de Mota", "Chía «semilla de chía», atl «agua» y pan «lugar»: «En el río de la chía». Nombrado en honor al conquistador Jerónimo Ruiz de la Mota.", "Chapa de Mota",292.32,292.32, "Templado",19.8140165,-99.5261662); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(27,"Chapultepec", "Chapulli «chapulín», tepetl «cerro» y co «en»: «En el cerro del chapulín».", "Chapultepec",12.62,12.62, "Semifrio",19.2030655,-99.5478784); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(28,"Chiautla", "Chiauac «grasa» y tla «abundancia»: «Abundancia de piedras grasosas».", "Chiautla",20.7,20.7, "Frio",19.5490592,-98.8831506); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(29,"Chicoloapan", "Chicoltic «Casa torcida», atl «agua» y pan «lugar»: «Lugar donde se tuerce el agua».", "Chicoloapan de Juárez",53.91,53.91, "Cálido",19.4143591,-98.9062442); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(30,"Chiconcuac", "Chicome «siete», coatl «serpiente» y co «en»: «En siete Serpientes»", "Chiconcuac de Juárez",6.82,6.82, "Semiárido",19.5610249,-98.8995504); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(31,"Chimalhuacán", "Chimalli «escudo o rodela», hua «poseer» y can «lugar»: «Lugar de escudo o rodela»", "Chimalhuacán",44.69,44.69, "Seco",19.4314047,-98.9582048); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(32,"Donato Guerra", "Nombrado así en honor al militar Donato Guerra.nota 3?", "Villa de Donato Guerra",192.03,192.03, "Templado",19.3110323,-100.1418032); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(33,"Ecatepec de Morelos", "Ecatl «viento, aire», tepetl «cerro» y co «en»: «En el cerro del viento o del aire». Nombrado en honor al insurgente José María Morelos.", "Ecatepec de Morelos",160.17,160.17, "Semifrio",19.571859,-99.0377048); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(34,"Ecatzingo", "Ecatl «viento, aire», tzintli «pequeño» y go «lugar»: «Lugar consagrado al viento».", "Ecatzingo de Hidalgo",50.77,50.77, "Frio",18.9683219,-98.7328567); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(35,"Huehuetoca", "Huehue «viejo» y toca «habla, lengua»: «Lugar de la lengua antigua».", "Huehuetoca",118.02,118.02, "Cálido",19.828228,-99.2033265); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(36,"Hueypoxtla", "Huei «grande», pochtecatl «comerciante» y tlan «abundancia»: «Lugar de grandes mercaderes».", "Hueypoxtla",233.91,233.91, "Semiárido",19.950774,-99.04255); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(37,"Huixquilucan", "Huitzquilitl «cardo comestible», can «lugar»: «Lugar lleno de cardos comestibles».", "Huixquilucan de Degollado",140.67,140.67, "Seco",19.371098,-99.3218243); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(38,"Isidro Fabela", "Nombrado así en honor al político y escritor Isidro Fabela.nota 4?", "Tlazala de Fabela",75.79,75.79, "Templado",19.5579234,-99.4168426); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(39,"Ixtapaluca", "Iztatl «sal», pallutl «mojadura» y can «lugar»: «Lugar donde se moja la sal».", "Ixtapaluca",327.4,327.4, "Semifrio",19.3176558,-98.901606); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(40,"Ixtapan de la Sal", "Iztatl «sal» y pan «sobre»: «Sobre la sal».", "Ixtapan de la Sal",110.75,110.75, "Frio",18.843579,-99.6787811); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(41,"Ixtapan del Oro", "Iztatl «sal» y pan «sobre»: «Sobre la sal». El término «Oro» alude a sus vetas de oro.", "Ixtapan del Oro",101.35,101.35, "Cálido",19.2631287,-100.265173); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(42,"Ixtlahuaca", "Ixtlahuacan: «Llanura, tierra despoblada de árboles».", "Ixtlahuaca de Rayón",335.85,335.85, "Semiárido",19.5715044,-99.7627696); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(43,"Xalatlaco", "Xalli «arena», Atlauhtli «barranca» y co «en»: «En la barranca de arena».", "Xalatlaco",116.47,116.47, "Seco",19.1797624,-99.4200318); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(44,"Jaltenco", "Xalli «arena», tentli «labio, orilla» y co «en»: «En la orilla de la arena».", "Jaltenco",4.73,4.73, "Templado",19.7542639,-99.0924713); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(45,"Jilotepec", "Xilotl «jilote», tepetl «cerro» y co «en»: «En el cerro de los jilotes».", "Jilotepec de Molina Enríquez",583.95,583.95, "Semifrio",19.9516945,-99.535162); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(46,"Jilotzingo", "Xilonen —diosa del maíz—, xin «venerar» y co «en»: «Donde se venera a Xilonen».", "Santa Ana Jilotzingo",119.7,119.7, "Frio",19.4976989,-99.3974672); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(47,"Jiquipilco", "Xiquipilli «costal, alforja» y co «en»: «Lugar de costales o alforjas».", "Jiquipilco",272.56,272.56, "Cálido",19.5560943,-99.6073306); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(48,"Jocotitlán", "Xocotl «fruta agridulce», titlan «entre»: «Entre árboles de fruta ágridulce».", "Jocotitlán",277.26,277.26, "Semiárido",19.7091485,-99.7885236); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(49,"Joquicingo", "Zoquitl «lodo, barro», tzintli «pequeño» y co «en»: «En el barrialito».", "Joquicingo",63.66,63.66, "Seco",19.0620844,-99.5168927); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(50,"Juchitepec", "Xóchitl «flor» y tepetl «cerro»: «Cerro de las flores».", "Juchitepec de Mariano Rivapalacio",140.11,140.11, "Templado",19.0911407,-98.881554); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(51,"Lerma", "Nombrado así en honor al Duque de Lerma.nota 5?", "Lerma de Villada",212.83,212.83, "Semifrio",19.2791137,-99.6826821); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(52,"Malinalco", "Mallinalli —una planta gramínea—, xóchitl «flor» y co «en»: «En donde se venera a Malinalxóchitl, la flor del malinalli».", "Malinalco",204.95,204.95, "Frio",18.9474124,-99.5141589); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(53,"Melchor Ocampo", "Nombrado así en honor al político Melchor Ocampo.nota 6?", "Melchor Ocampo",17.78,17.78, "Cálido",19.7067566,-99.1377217); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(54,"Metepec", "Metl «maguey», tepetl «cerro» y co «en»: «En el cerro de los magueyes».", "Metepec",67.52,67.52, "Semiárido",19.2621434,-99.5989735); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(55,"Mexicaltzingo", "Mexicatl «mexicano», tzintli «reverencia» y co «en»: «En donde habitan los mexicanos distinguidos».", "San Mateo Mexicaltzingo",11.47,11.47, "Seco",19.2124321,-99.5853272); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(56,"Morelos", "Nombrado así en honor al héroe de la independencia José María Morelos.nota 7?", "San Bartolo Morelos",236.32,236.32, "Templado",19.6833296,-99.6666683); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(57,"Naucalpan de Juárez", "Nahui «cuatro», calli «casa» y pan «en»: «En las cuatro casas». Nombrado así en honor al presidente Benito Juárez.", "Naucalpan de Juárez",156.63,156.63, "Semifrio",19.4697619,-99.2548994); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(58,"Nezahualcóyotl", "Nezahualo «ayunar» y coyotl «coyote»: «Coyote que ayuna». Nombrado así en honor al rey y poeta Nezahualcóyotl.", "Nezahualcóyotl",63.74,63.74, "Frio",19.4324945,-99.0169328); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(59,"Nextlalpan", "Nextli «ceniza», tlalli «tierra, suelo» y pan «sobre»: «Sobre el suelo de ceniza».", "Santa Ana Nextlalpan",54.51,54.51, "Cálido",19.7320396,-99.067544); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(60,"Nicolás Romero", "Nombrado así en honor al militar Nicolás Romero.nota 8?", "Villa Nicolás Romero",235.65,235.65, "Semiárido",19.6193,-99.3074185); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(61,"Nopaltepec", "Nopalli «nopal», tepetl «cerro» y co «en»: «En el cerro de los nopales».", "Nopaltepec",83.7,83.7, "Seco",19.7777903,-98.7140088); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(62,"Ocoyoacac", "Ocotl «ocote, pino», yácatl «nariz, principio» y co «en»: «Donde principian los ocotes o pinos».", "Ocoyoacac",134.72,134.72, "Templado",19.2699076,-99.4553661); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(63,"Ocuilan", "Oculi «gusano», tla «abundancia»: «Donde abundan los gusanos».", "Ocuilan de Arteaga",314.53,314.53, "Semifrio",19.0013496,-99.3993863); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(64,"El Oro", "Su nombre hace referencia a los yacimientos de oro en la región.nota 9?", "El Oro de Hidalgo",137.47,137.47, "Frio",19.8028386,-100.138199); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(65,"Otumba", "Otomitl «Jefe de Otomíes» y pan «en, sobre»: «Lugar de otomíes».", "Otumba de Gómez Farías",195.56,195.56, "Cálido",19.6996778,-98.7531575); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(66,"Otzoloapan", "Ocelotl «jaguar» y apan «río»: «Río de los jaguares».", "Otzoloapan",157.43,157.43, "Semiárido",19.1186115,-100.2972304); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(67,"Otzolotepec", "Ocelotl «jaguar», tepetl «cerro» y co «en»: «En el cerro del jaguar».", "Villa Cuauhtémoc",116.67,116.67, "Seco",19.4444342,-99.5338184); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(68,"Ozumba", "Atl «agua», tzontli «cabello» y pan «sobre»: «Sobre los cabellos del agua».", "Ozumba de Alzate",45.64,45.64, "Templado",19.0161301,-98.80821); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(69,"Papalotla", "Papalotl «mariposa», tla «abundancia, lugar»: «Lugar de mariposas».", "Papalotla",3.19,3.19, "Semifrio",19.5610826,-98.8590085); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(70,"La Paz", "Recibe este nombre dado que en la época prehispánica, los jefes militares se reunían aquí para firmar los acuerdos de paz.nota 10?", "Los Reyes Acaquilpan",36.36,36.36, "Frio",19.3637572,-98.9519549); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(71,"Polotitlán", "Polo —apellido español—, titlán «entre, lugar»: «Lugar de los Polo».nota 11?", "Polotitlán de la Ilustración",127.49,127.49, "Cálido",20.2189025,-99.8064108); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(72,"Rayón", "Nombrado así en honor al insurgente Ignacio López Rayón.nota 12?", "Santa María Rayón",23.4,23.4, "Semiárido",19.1444,-99.5836); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(73,"San Antonio la Isla", "Nombrado así en honor a San Antonio de Padua.nota 13?", "San Antonio la Isla",18.5,18.5, "Seco",19.1611,-99.5708); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(74,"San Felipe del Progreso", "Nombrado así en honor a San Felipe Apóstol. Se le denominó «del Progreso» después de que el pueblo alcanzó la categoría de villa.", "San Felipe del Progreso",368.15,368.15, "Templado",19.7128,-99.9519); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(75,"San Martín de las Pirámides", "Nombrado así en honor a San Martín de Tours. «De las Pirámides» hace referencia a la zona arqueológica que se ubica en su territorio.", "San Martín de las Pirámides",67.22,67.22, "Semifrio",19.7,-98.8333); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(76,"San Mateo Atenco", "Nombrado así en honor a San Mateo Apóstol. Atenco viene de Atl «agua», entli«orilla» y co «en»: «En la orilla del agua».", "San Mateo Atenco",27.38,27.38, "Frio",19.5474,-99.8516); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(77,"San Simón de Guerrero", "Nombrado así en honor a San Simón Apóstol y al presidente Vicente Guerrero.nota 14?", "San Simón de Guerrero",129.23,129.23, "Cálido",19.025,-100.0083); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(78,"Santo Tomás", "Nombrado así en honor a Tomás el Apóstol.nota 15?", "Santo Tomás de los Plátanos",104.25,104.25, "Semiárido",18.6833,-100.2778); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(79,"Soyaniquilpan de Juárez", "Tzatzayani «se rompe o hiende», quilit «hierba», atl «agua», pan «en»: «Lugar de agua donde la hierba se rompe o hiende». Nombrado en honor al presidente Benito Juárez.", "San Francisco Soyaniquilpan",128.8,128.8, "Seco",19.9833,-99.5); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(80,"Sultepec", "Zulli «codorniz», tepetl «cerro» y co «en»: «En el cerro de las codornices».", "Sultepec de Pedro Ascencio de Alquisiras",564.04,564.04, "Templado",18.8627911,-99.9750179); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(81,"Tecámac", "Tetl «piedra», camatl «boca» y co «en»: «En la boca de piedra».", "Tecámac de Felipe Villanueva",157.34,157.34, "Semifrio",19.7133413,-98.987542); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(82,"Tejupilco", "Texopill «dedos de los pies», co «en»: «En los dedos de los pies».", "Tejupilco de Hidalgo",669.13,669.13, "Frio",18.9090983,-100.1675205); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(83,"Temamatla", "Tetl «piedra», mamatlall «escalera» y tla «abundancia»: «Escalera de piedra».", "Temamatla",28.75,28.75, "Cálido",19.2049153,-98.8771393); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(84,"Temascalapa", "Temazcalli «baño de vapor», atl «agua» y pan «en»: «En los baños de vapor».", "Temascalapa",163.8,163.8, "Semiárido",19.8263377,-98.9194072); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(85,"Temascalcingo", "Temazcalli «baño de vapor», tzintli «pequeño», co «en»: «En el pequeño baño de vapor».", "Temascalcingo de José María Velasco",362.39,362.39, "Seco",19.9221175,-100.0239202); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(86,"Temascaltepec", "Temazcalli «baño de vapor», tepetl «cerro» y co «en»: «En el cerro de los baños de vapor».", "Temascaltepec de González",544.59,544.59, "Templado",19.0458271,-100.0525492); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(87,"Temoaya", "Temoa «bajar, descender» y yan «lugar»: «Lugar donde se desciende».", "Temoaya",190.34,190.34, "Semifrio",19.4685168,-99.6037575); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(88,"Tenancingo", "Tenamitl «muralla», tzintli «pequeño», co «en»: «Lugar de la pequeña muralla»", "Tenancingo de Degollado",163.15,163.15, "Frio",18.9632486,-99.6022614); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(89,"Tenango del Aire", "Tenamitl «muralla» y co «en»: «Lugar amurallado». «Del Aire» hace referencia a los fuertes vientos existentes en la estación seca.", "Tenango del Aire",37.77,37.77, "Cálido",19.1559552,-98.8677837); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(90,"Tenango del Valle", "Teotl «Dios», tenamitl «muralla» y co «en»: «En la muralla sagrada». «Del Valle» indica su ubicación en el Valle de Toluca.", "Tenango de Arista",207.54,207.54, "Semiárido",19.1109089,-99.6047508); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(91,"Teoloyucan", "Tehuilotl «vidrio, cristal de roca», yotl «plenitud» y can «lugar»: «Lugar lleno de vidrio o cristal de roca».", "Teoloyucan",53.04,53.04, "Seco",19.755485,-99.1893559); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(92,"Teotihuacán", "Teotl «Dios», hua «posesivo» y can «lugar»: «Lugar que tiene a nuestros dioses».", "Teotihuacán de Arista",83.16,83.16, "Templado",19.6880928,-98.8758635); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(93,"Tepetlaoxtoc", "Tepetl «tepetate», ozto «cueva» y co «en»: «En las cuevas de tepetate».", "Tepetlaoxtoc de Hidalgo",178.37,178.37, "Semifrio",19.5492495,-98.7625797); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(94,"Tepetlixpa", "Tepetl «cerro» e ixpan «en la cara o superficie»: «En la cara o superficie del cerro».", "Tepetlixpa",42.98,42.98, "Frio",19.0283173,-98.817753); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(95,"Tepotzotlán", "Tepotzotli «joroba» y tlan «entre»: «Entre jorobados».", "Tepotzotlán",187.82,187.82, "Cálido",19.7192648,-99.217524); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(96,"Tequixquiac", "Tequixquitl «tequesquite», atl «agua» y co «en»: «En el agua tequesquitosa».", "Santiago Tequixquiac",122.32,122.32, "Semiárido",19.9039067,-99.141374); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(97,"Texcaltitlán", "Texcalli «roca» y titlán «entre»: «Entre las rocas».", "Texcaltitlán",150.66,150.66, "Seco",18.9282503,-99.9417054); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(98,"Texcalyacac", "Texcalli «pedregal», yacátl «nariz, punta» y con «en»: «En la punta del pedregal».", "San Mateo Texcalyacac",24.78,24.78, "Templado",19.1270057,-99.494735); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(99,"Texcoco", "Texcalli «peñasco, risco», tlacolt «jarilla» y co «en»: «En la jarilla del risco».", "Texcoco de Mora",432.61,432.61, "Semifrio",19.5089289,-98.8862218); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(100,"Tezoyuca", "Tezontli «tezontle», yotl «plenitud» y can «lugar»: «Lugar lleno de tezontle».", "Tezoyuca",17.46,17.46, "Frio",19.5089289,-98.8862218); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(101,"Tianguistenco", "Tianquistli «mercado», tentli «labio, orilla» y co «en»: «En la orilla del mercado».", "Santiago Tianguistenco de Galeana",167.97,167.97, "Cálido",19.1745704,-99.4605193); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(102,"Timilpan", "Tetl «piedra», milli «sementera» y pan «sobre, en»: «En la sementera de piedra».", "San Andrés Timilpan",172.81,172.81, "Semiárido",19.8763977,-99.7356023); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(103,"Tlalmanalco", "Tlalli «tierra», manalli «aplanada» y co «lugar»: «Lugar de tierra aplanada».", "Tlalmanalco de Velázquez",161.57,161.57, "Seco",19.205735,-98.8011942); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(104,"Tlalnepantla de Baz", "Tlalli «tierra», nepantla «en medio»: «En medio de la tierra». Nombrado en honor al gobernador y médico Gustavo Baz Prada.", "Tlalnepantla",77.17,77.17, "Templado",19.5464134,-99.1648411); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(105,"Tlatlaya", "Tlatla «arder», yan «lugar»: «Tierra que arde».", "Tlatlaya",791.49,791.49, "Semifrio",18.6168681,-100.2077766); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(106,"Toluca", "Toloqui «inclinar la cabeza», co «en»: «En donde está el dios Tolo».", "Toluca de Lerdo",452.371,452.371, "Frio",19.294261,-99.7012546); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(107,"Tonatico", "Tonatiuh «sol», co «lugar»: «Lugar de sol».", "Tonatico",91.98,91.98, "Cálido",18.8057529,-99.6763218); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(108,"Tultepec", "Tollin «tule», tepetl «cerro» y co «en»: «En el cerro del tule».", "Tultepec",27.22,27.22, "Semiárido",19.6882413,-99.1372376); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(109,"Tultitlán", "Tollin «tule», titlán «entre»: «Lugar entre tules».", "Tultitlán de Mariano Escobedo",69.15,69.15, "Seco",19.6457412,-99.1825013); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(110,"Valle de Bravo", "Nombrado así en honor al presidente Nicolás Bravo.nota 16?", "Valle de Bravo",430.8,430.8, "Templado",19.1820952,-100.1634028); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(111,"Villa de Allende", "Nombrado así en honor al héroe de la independencia Ignacio Allende.nota 17?", "San José Villa de Allende",309.28,309.28, "Semifrio",19.3762014,-100.1537683); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(112,"Villa del Carbón", "Nombrado así en referencia a la producción de carbón en la cabecera municipal.", "Villa del Carbón",306.56,306.56, "Frio",19.7317654,-99.4837233); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(113,"Villa Guerrero", "Nombrado así en honor al insurgente y presidente Vicente Guerrero.nota 18?", "Villa Guerrero",209.96,209.96, "Cálido",18.9596724,-99.646487); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(114,"Villa Victoria", "Nombrado así en honor al primer presidente del país, Guadalupe Victoria.nota 19?", "Villa Victoria",419.35,419.35, "Semiárido",19.4349173,-100.0050714); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(115,"Xonacatlán", "Xonacatl «cebolla», tlan «entre»: «Entre las cebollas».", "Xonacatlán",65.85,65.85, "Seco",19.4096534,-99.5409503); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(116,"Zacazonapan", "Zacatzontetl «césped», atl «agua» y pan «sobre»: «Sobre agua de céspedes».", "Zacazonapan",66.67,66.67, "Templado",19.0742547,-100.2637905); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(117,"Zacualpan", "Tzacualli «pirámide» y pan «sobre»: «Sobre la pirámide».", "Real de Minas Zacualpan",301.47,301.47, "Semifrio",18.7142006,-99.9505567); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(118,"Zinacantepec", "Tzanacan «murciélago», tepetl «cerro» y co «en»: «En el cerro de los murciélagos».", "San Miguel Zinacantepec",308.62,308.62, "Frio",19.2836398,-99.760454); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(119,"Zumpahuacán", "Tzompantli «zompantli», hua «poseer» y can «lugar»: «Lugar para guardar los cráneos de los sacrificados».", "Zumpahuacán",201.18,201.18, "Cálido",18.8367998,-99.5900444); municipiosController.nuevoMunicipio(municipio);
                municipio=new Municipio(120,"Zumpango", "Tzompantli «zompantli», co «lugar»: «Lugar del zompantli».", "Zumpango de Ocampo",223.95,223.95, "Semiárido",19.7998188,-99.1246031); municipiosController.nuevoMunicipio(municipio);
              //  municipio=new Municipio(121,"Cuautitlán Izcalli", "Cuáhutli «árbol» y titlán «junto o entre»; iz «tu, tuyo» y calli «casa»: «Tu casa entre los árboles».", "Cuautitlán Izcalli",109.54,109.54, "Seco",19.657687,-99.2958126); municipiosController.nuevoMunicipio(municipio);
               // municipio=new Municipio(122,"Valle de Chalco Solidaridad", "Su nombre se refiere a su ubicación en el valle del antiguo lago de Chalco, y que el poblamiento de la zona se inició gracias al programa «Solidaridad».", "Xico",46.53,46.53, "Templado",19.2825545,-99.0138998); municipiosController.nuevoMunicipio(municipio);
               // municipio=new Municipio(123,"Luvianos", "Nombrado así en honor al fundador de Villa Luvianos, Cristóbal Lubiano.nota 20?", "Villa Luvianos",703,703, "Semifrio",18.91966,-100.3062969); municipiosController.nuevoMunicipio(municipio);
               // municipio=new Municipio(124,"San José del Rincón", "Nombrado así en honor a San José. «Del Rincón» hace referencia al difícil acceso y relativo aislamiento de su cabecera municipal.", "San José del Rincón",492.25,492.25, "Frio",19.6359544,-100.2813478); municipiosController.nuevoMunicipio(municipio);
                //municipio=new Municipio(125,"Tonanitla", "Tonantzin «Nuestra madre» y tlan «lugar»: «Lugar de nuestra madre».", "Santa María Tonanitla",8.47,8.47, "Cálido",19.6798286,-99.0763197); municipiosController.nuevoMunicipio(municipio);
                int i=1;
                while ( i<=120) {
                    String[] array = {"Inundación", "Deslave", "Zona sísmica", "Incendio forestal", "Zona volcánica", "Derrumbes"};
                    String randomStr = array[new Random().nextInt(array.length)];
                    String randomStr2 = array[new Random().nextInt(array.length)];
                    if (randomStr.equals(randomStr2)){
                         randomStr2 = array[new Random().nextInt(array.length)];
                        if (randomStr.equals(randomStr2)) {
                            randomStr2 = array[new Random().nextInt(array.length)];
                            zonaRiesgo = new ZonaRiesgo(i, randomStr);
                            zonaRiesgo2 = new ZonaRiesgo(i, randomStr2);
                            zonasController.nuevaZona(zonaRiesgo);
                            zonasController.nuevaZona(zonaRiesgo2);
                            i++;
                        }
                    }
                    else
                    {
                        zonaRiesgo = new ZonaRiesgo(i, randomStr);
                        zonaRiesgo2 = new ZonaRiesgo(i, randomStr2);
                        zonasController.nuevaZona(zonaRiesgo);
                        zonasController.nuevaZona(zonaRiesgo2);
                        i++;
                    }
                }
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



                Municipio municipio= new Municipio(idI, municipioS,significado, cabecera,
                        superficieD,altitudD,clima,0,0);
                long id = municipiosController.nuevoMunicipio(municipio);
                if (id == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(getContext(), "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    System.out.println("----------------------------Error Guardar Municipio");
                } else {
                    // Terminar
                    ;
                    Toast.makeText(getContext(), "Se guardó correctamente", Toast.LENGTH_SHORT).show();
                    if(cbInundacion.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Inundación");
                        zonasController.nuevaZona(zona);
                    }
                    if(cbDeslave.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Deslave");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbSismica.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Zona sísmica");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbIncendio.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Incendio forestal");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbVolcanica.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Zona volcánica");
                        long idZona = zonasController.nuevaZona(zona);
                    }
                    if(cbDerrumbes.isChecked()==true){
                        ZonaRiesgo zona = new ZonaRiesgo( idI, "Derrumbes");
                        long idZona = zonasController.nuevaZona(zona);
                    }


                    Intent intent = new Intent(getContext(), MapsActivity.class);
                    intent.putExtra("idmunicipio", municipio.getId());
                    intent.putExtra("municipio",municipio.getMunicipio());
                    intent.putExtra("significado",municipio.getSignificado());
                    intent.putExtra("cabecera",municipio.getCabecera());
                    intent.putExtra("superficie",municipio.getSuperficie());
                    intent.putExtra("altitud",municipio.getAltitud());
                    intent.putExtra("clima",municipio.getClima());
                    intent.putExtra("vista","insertar");
                    startActivity(intent);

                }

            }
        });
        return view;
    }


}
