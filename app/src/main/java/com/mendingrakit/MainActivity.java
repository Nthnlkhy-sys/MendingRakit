package com.mendingrakit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View v){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View v){
        recreate();
    }

    public void ClickPackage(View v){
        redirectActivity(this, Package.class);
    }

    public void ClickAbout(View v){
        redirectActivity(this, About.class);
    }

    public void ClickExit(View v){
        exit(this);
    }

    public static void exit(final Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Exit");
        builder.setMessage("Are You Sure want to Exit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();

                System.exit(0);
            }
        });

        builder.setNegativeButton("No",((dialogInterface, i) -> {
            dialogInterface.dismiss();
        }));

        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass){
        Intent intent = new Intent(activity, aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }
}