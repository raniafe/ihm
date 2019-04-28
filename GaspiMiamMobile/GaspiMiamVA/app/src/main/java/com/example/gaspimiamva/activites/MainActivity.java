package com.example.gaspimiamva.activites;

import android.app.FragmentManager;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.fragments.BoutiqueFragment;
import com.example.gaspimiamva.fragments.MapFragment;
import com.example.gaspimiamva.fragments.MesVentesFragment;
import com.example.gaspimiamva.fragments.MonCompteFragment;
import com.example.gaspimiamva.fragments.StockFragment;

import static com.example.gaspimiamva.R.id.toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_accueil) {
            openActivity() ;
        } else if (id == R.id.nav_boutique) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new BoutiqueFragment())
                    .commit();

        }  else if (id == R.id.nav_mesventes) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new MesVentesFragment())
                    .commit();


        }else if (id == R.id.nav_stock) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new StockFragment())
                    .commit();


        } else if (id == R.id.nav_moncompte) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new MonCompteFragment())
                    .commit();


        } else if (id == R.id.nav_map) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new MapFragment())
                    .commit();


        } else if (id == R.id.nav_deconnexion) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openActivity()
    {
        Intent intent = new Intent(this, MainActivity.class) ;
        startActivity(intent) ;
    }
}
