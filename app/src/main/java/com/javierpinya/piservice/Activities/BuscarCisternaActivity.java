package com.javierpinya.piservice.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.javierpinya.piservice.Fragments.BuscarCisternaFragment;
import com.javierpinya.piservice.Fragments.NuevaInspeccionFragment;
import com.javierpinya.piservice.R;

public class BuscarCisternaActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cisterna);
        setToolbar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setFragmentByDefault();


        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;
                Intent i = new Intent();

                switch (item.getItemId()){
                    case R.id.menu_dashboard:
                        i.setClass(BuscarCisternaActivity.this, DashboardActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new DashboardFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscari:
                        i.setClass(BuscarCisternaActivity.this, BuscarInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new BuscarInspeccionFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscarc:
                        fragment = new BuscarCisternaFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_buscart:
                        //fragment = new BuscarTractoraFragment();
                        //fragmentTransaction = true;
                        i.setClass(BuscarCisternaActivity.this, BuscarTractoraActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_nuevai:
                        i.setClass(BuscarCisternaActivity.this, NuevaInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_logout:
                        logOut();
                        return true;
                    case R.id.menu_forget_logout:
                        removeSharedPreferences();
                        logOut();
                        return true;
                }

                if(fragmentTransaction){
                    changeFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment( new BuscarCisternaFragment(), navigationView.getMenu().getItem(2));
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private void removeSharedPreferences(){
        prefs.edit().clear().apply();
    }
}
