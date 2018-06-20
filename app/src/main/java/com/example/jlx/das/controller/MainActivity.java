package com.example.jlx.das.controller;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jlx.das.R;
import com.example.jlx.das.controller.fragment.CustomFragment;
import com.example.jlx.das.controller.fragment.FragmentReference;
import com.example.jlx.das.controller.fragment.ModeType;
import com.example.jlx.das.data.DataPool;
import com.google.common.collect.Maps;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Map<String,CustomFragment> fragmentById = Maps.newHashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();

        DataPool.initialize(this);
        showFirstFragment();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        FragmentReference fragementReference = FragmentReference.getMode(id);
        showFragment(fragementReference, ModeType.MODE_DISPLAY);

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (visibleFragment == null){
            this.showFragment(FragmentReference.PROFIL, ModeType.MODE_DISPLAY);
        }
    }

    public void showFragment(FragmentReference fragmentReference,ModeType modeType){
        CustomFragment customFragment = getCustomFragment(fragmentReference, modeType);
        this.startTransactionFragment(customFragment);
    }

    public CustomFragment getCustomFragment(FragmentReference fragmentReference, ModeType modeType) {
        String name = fragmentReference.getName();
        CustomFragment fragment = this.fragmentById.get(name);
        if (fragment == null) {
            fragment = CustomFragment.newInstance();
            this.fragmentById.put(name,fragment);
        }
        Bundle bundle = getBundle(fragmentReference, modeType);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Bundle getBundle(FragmentReference fragmentReference,ModeType modeType) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomFragment.FRAGMENT_ID,fragmentReference.getMenuId());
        bundle.putString(CustomFragment.MODE, modeType.getId());
        return bundle;
    }

    private void startTransactionFragment(CustomFragment fragment){
       if (!fragment.isVisible()) {
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.activity_main_frame_layout, fragment).commit();
       }
    }

    // INITIALIZE NAVIGATION VIEW

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu_drawer, menu);
        return true;
    }


}
