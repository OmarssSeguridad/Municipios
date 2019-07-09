package com.example.municipios;

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
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
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
        String usuario;
        Bundle extras = getIntent().getExtras();
        usuario = extras.getString("usuario");



        int id = item.getItemId();
        if (id == R.id.nav_crear) {
            if (usuario.equals("admin")) {
                setTitle("Crear Municipio");
                InsertarMunicipio fragmento = new InsertarMunicipio();
                androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, fragmento, "fragmento");
                transaction.commit();
            }
            else
            {
                Toast.makeText(this,"Sin Privilegios suficientes",Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_modificar) {
            if (usuario.equals("admin")) {

                setTitle("Modificar Municipio");
            Modificar fragmento = new Modificar();
            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor,fragmento,"fragmento");
            transaction.commit();
            }
            else
            {
                Toast.makeText(this,"Sin Privilegios suficientes",Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.nav_eliminar) {
                if (usuario.equals("admin")) {
                    setTitle("Eliminar Municipio");
                    EliminarMunicipio fragmento = new EliminarMunicipio();
                    androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedor,fragmento,"fragmento");
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(this,"Sin Privilegios suficientes",Toast.LENGTH_SHORT).show();
                }

        } else if (id == R.id.nav_consultar) {
                    if (usuario.equals("admin")||usuario.equals("user")) {
                        setTitle("Consultar Municipio");
                        ConsultarMunicipio fragmento = new ConsultarMunicipio();
                        androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.contenedor,fragmento,"fragmento");
                        transaction.commit();
                    }
                    else
                    {
                        Toast.makeText(this,"Sin Privilegios suficientes",Toast.LENGTH_SHORT).show();
                    }

        } else if (id == R.id.nav_listar) {
                        if (usuario.equals("admin")||usuario.equals("user")) {
                            setTitle("Listar Municipios");
                            ListarMunicipio fragmento = new ListarMunicipio();
                            androidx.fragment.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.contenedor,fragmento,"fragmento");
                            transaction.commit();
                        }
                        else
                        {
                            Toast.makeText(this,"Sin Privilegios suficientes",Toast.LENGTH_SHORT).show();
                        }

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
