package com.example.eunoia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MotivationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    public FragmentManager fragmentManager;
    public String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            username = extras.getString("username");
        }else {
            username = "decoy";
        }

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        MenuMotivation MenuMotivation = new MenuMotivation();
        MenuMotivation.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameLayout, MenuMotivation).commit();

        drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intentHome = new Intent(getApplicationContext(), HomeActivity.class);
                intentHome.putExtra("username",username);
                startActivity(intentHome);
                finish();
                break;

            case R.id.nav_motivation:
                Toast.makeText(this, "Already in the motivation page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_tracker:
                Intent intentTrack = new Intent(getApplicationContext(), TrackerActivity.class);
                intentTrack.putExtra("username",username);
                startActivity(intentTrack);
                finish();
                break;

            case R.id.nav_help:

                break;

            case R.id.nav_recommendation:

                break;

            case R.id.nav_emergency:

                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}