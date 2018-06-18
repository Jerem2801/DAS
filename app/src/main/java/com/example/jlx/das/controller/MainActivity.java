package com.example.jlx.das.controller;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jlx.das.R;
import com.example.jlx.das.controller.fragment.CustomFragment;
import com.example.jlx.das.data.DataPool;
import com.google.common.collect.Maps;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;



    //FRAGMENTS
    private static final String PROFILE_FRAGMENT_ID = "profile";
    private static final String PROFILE_APPAREANCE_ID = "appareance";

    private Map<String,CustomFragment> fragmentById = Maps.newHashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configure all views
        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();

        //Get DataPool
        DataPool.initialize(this);
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.activity_main_drawer_profil:
                showFragment(PROFILE_FRAGMENT_ID,R.layout.sheet_profile,R.id.fragment_profile_rootview);
                break;
            case R.id.activity_main_drawer_appareance:
                showFragment(PROFILE_APPAREANCE_ID,R.layout.sheet_appareance,R.id.fragment_appareance_rootview);
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(String fragmentId,int layoutId,int linearId){
        CustomFragment fragment = this.fragmentById.get(fragmentId);
        if (fragment == null) {
            fragment = CustomFragment.newInstance(fragmentId,layoutId,linearId);
            this.fragmentById.put(fragmentId,fragment);
        }
        this.startTransactionFragment(fragment);
    }

    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_frame_layout, fragment).commit();
        }
    }

    private void configureToolBar(){
        this.toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    private void configureDrawerLayout(){
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView(){
        this.navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
