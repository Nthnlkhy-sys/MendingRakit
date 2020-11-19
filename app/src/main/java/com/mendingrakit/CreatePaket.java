package com.mendingrakit;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePaket extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_paketname, edit_Harga;
    private Button btn_save;

    private data_Package data_package;

    DatabaseReference m_database;

    @Override
    public void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.create_main);

        m_database = FirebaseDatabase.getInstance().getReference();

        edit_paketname  = findViewById(R.id.edit_paketname);
        edit_Harga      = findViewById(R.id.edit_harga);
        btn_save        = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(this);

        data_package = new data_Package();
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.btn_save){
            savedataPaket();
        }
    }

    private void savedataPaket(){
        String namapaket    = edit_paketname.getText().toString().trim();
        String harga        = edit_Harga.getText().toString().trim();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(namapaket)){
            isEmptyFields = true;
            edit_paketname.setError("Field ini tidak boleh kosong");
        }

        if(TextUtils.isEmpty(harga)){
            isEmptyFields = true;
            edit_Harga.setError("Field ini tidak boleh kosong");
        }

        if(!isEmptyFields){
            Toast.makeText(CreatePaket.this, "Saving Data...", Toast.LENGTH_SHORT).show();

            DatabaseReference dbPackage = m_database.child("Package");

            String Key = dbPackage.push().getKey();
                    data_package.setKey(Key);
                    data_package.setNamapaket(namapaket);
                    data_package.setHarga(harga);
                    data_package.setPhoto("");
            //insert to db
            dbPackage.child(Key).setValue(data_package);

            finish();

        }
    }
}
