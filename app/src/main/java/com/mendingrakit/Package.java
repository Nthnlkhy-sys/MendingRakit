package com.mendingrakit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Package extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    private ListView listView;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_main);

        drawerLayout    = findViewById(R.id.drawer_layout);
        listView        = findViewById(R.id.lv_list);
        btnadd          = findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);
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

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btn_add) {
            Intent intent = new Intent(Package.this, CreatePaket.class);
            startActivity(intent);
        }
    }



}