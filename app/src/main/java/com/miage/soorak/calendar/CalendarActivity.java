package com.miage.soorak.calendar;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class CalendarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
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

            // /!\ ATTENTION : La création d'une nouvelle Activité semble ne pas détruire l'ancienne et donc prends de plus en plus de RAM ! /!\
        } else if (id == R.id.nav_calendrier) {
            Intent menuIntent = new Intent(this, CalendarActivity.class);
            startActivity(menuIntent);
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
