package com.mendingrakit;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Package extends AppCompatActivity{
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_main);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View v){
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View v){
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickHome(View v){
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickPackage(View v){
        recreate();
    }

    public void ClickAbout(View v){
        MainActivity.redirectActivity(this, About.class);
    }

    public void ClickExit(View v){
        MainActivity.exit(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }

}