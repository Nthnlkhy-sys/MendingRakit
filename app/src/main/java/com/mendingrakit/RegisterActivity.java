package com.mendingrakit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.text.Html.fromHtml;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;

    private TextInputLayout textInputLayoutEmail, textInputLayoutPassword;

    private Button buttonRegister;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.register_activity);

        initView();
        registerUser();
        initTextViewLogin();
    }

    private void initView() {

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        auth = FirebaseAuth.getInstance();
    }

    private void registerUser() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailuser = editTextEmail.getText().toString().trim();
                String passworduser = editTextPassword.getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(emailuser).matches()) {
                    editTextEmail.setError("Email tidak Valid");
                } else if (passworduser.isEmpty()) {
                    editTextPassword.setError("Password tidak boleh kosong");
                } else if (passworduser.length() < 6) {
                    editTextPassword.setError("Password minimal terdiri dari 6 karakter");
                } else {
                    auth.createUserWithEmailAndPassword(emailuser, passworduser)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this,
                                                "Register gagal karena " + task.getException().getMessage(),
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }
                                }
                            });
                }
            }
        });
    }

    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}