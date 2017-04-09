package com.miage.soorak.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean propositionClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bouton pour ajouter des Tâches (doit renvoyer vers une activiter d'ajout de tache
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ajout d'une Tuile", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Button buttonTache = (Button) findViewById(R.id.toggleButtonTaches);
        final Button buttonProposition = (Button) findViewById(R.id.toggleButtonProposition);

        // On gère l'appuis des deux boutons (ne fait rien pour le moment)
        buttonTache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(propositionClicked) {
                    propositionClicked = false;
                    buttonTache.setBackgroundColor(Color.parseColor("#8e0000"));
                    buttonProposition.setBackgroundColor(Color.parseColor("#e6e6e6"));
                }
            }
        });
        buttonProposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!propositionClicked) {
                    propositionClicked = true;
                    buttonProposition.setBackgroundColor(Color.parseColor("#8e0000"));
                    buttonTache.setBackgroundColor(Color.parseColor("#e6e6e6"));
                }
            }
        });

        final Tuile tuile1 = (Tuile) findViewById(R.id.tuile1);
        tuile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // C.F. classe Tuile
                tuile1.callOnClick();
            }
        });

        final Tuile tuile2 = (Tuile) findViewById(R.id.tuile2);
        tuile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // C.F. classe Tuile
                tuile2.callOnClick();
            }
        });
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

        if (id == R.id.nav_liste_taches) {
            // On créer l'ActivityMain (la liste des taches)
            Intent menuIntent = new Intent(this, MainActivity.class);
            // On switch vers cette vue
            startActivity(menuIntent);

            // /!\ ATTENTION : La création d'une nouvelle Activité semble de pas détruire l'ancienne et donc prends de plus en plus de RAM ! /!\
        } else if (id == R.id.nav_calendrier) {

        } else if (id == R.id.nav_liste_menus) {

        } else if (id == R.id.nav_liste_course) {

        } else if (id == R.id.nav_parametres) {

        } else if (id == R.id.nav_aide_commentaires) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
