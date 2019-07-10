package com.example.municipios;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int tipoUsuario;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Créditos\n" +
                        "Desarrollo de aplicaciones móviles\n" +
                        "Alumna: Lourdes Cecilia Vega Mondragon\n" +
                        "Profesora: Rocio Elizabeth Pulido Alba\n", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Bundle extras = getIntent().getExtras();
        // Si no hay datos (cosa rara) salimos
        if (extras == null) {
            finish();
            return;
        }
        // Instanciar el controlador de las mascotas

        // Rearmar la mascota
        // Nota: igualmente solamente podríamos mandar el id y recuperar la mascota de la BD
        tipoUsuario = extras.getInt("tipoUsuario");
        if(tipoUsuario==1){

            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_crear).setVisible(false);
            nav_Menu.findItem(R.id.nav_eliminar).setVisible(false);
            nav_Menu.findItem(R.id.nav_modificar).setVisible(false);
        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_crear) {
            setTitle("Crear Municipio");
            InsertarMunicipio fragmento = new InsertarMunicipio();
            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor,fragmento,"fragmento");
            transaction.commit();
        } else if (id == R.id.nav_modificar) {
            setTitle("Modificar Municipio");
            Modificar fragmento = new Modificar();
            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor,fragmento,"fragmento");
            transaction.commit();

        } else if (id == R.id.nav_eliminar) {
            setTitle("Eliminar Municipio");
            EliminarMunicipio fragmento = new EliminarMunicipio();
            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor,fragmento,"fragmento");
            transaction.commit();

        } else if (id == R.id.nav_consultarmunicipios) {
            setTitle("Consultar Municipio");
            ConsultarMunicipio fragmento = new ConsultarMunicipio();
            androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor, fragmento, "fragmento");
            transaction.commit();
        }else if(id== R.id.nav_consultarzonas){
            setTitle("Consultar Zonas");
            ConsultarZonas fragmento = new ConsultarZonas();
            androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor, fragmento, "fragmento");
            transaction.commit();
        } else if (id == R.id.nav_listar) {
            setTitle("Listar Municipios");
            ListarMunicipio fragmento = new ListarMunicipio();
            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor,fragmento,"fragmento");
            transaction.commit();

        }else if (id == R.id.nav_salir){
            intent = new Intent(MenuActivity.this, MenuActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
