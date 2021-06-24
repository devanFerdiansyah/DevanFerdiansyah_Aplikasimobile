package com.example.sqlitesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextPasswordConfirm;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = (EditText) findViewById(R.id.editTextPasswordConfirm);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });


    }

    private void validateInput(){
        editTextUsername.setError(null);
        editTextPassword.setError(null);
        editTextPasswordConfirm.setError(null);
        View view = null;
        boolean cancel = false;

        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String password_confirm = editTextPasswordConfirm.getText().toString();

        //beri error jika fied kosong
        if (TextUtils.isEmpty(username)){
            editTextUsername.setError("This field is required");
            view = editTextUsername;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            editTextPassword.setError("This field is required");
            view = editTextPassword;
            cancel = true;
        }

        if (TextUtils.isEmpty(password_confirm)){
            editTextPasswordConfirm.setError("This field is required");
            view = editTextPasswordConfirm;
            cancel = true;
        }

        //beri error jika username sudah dipakai
        if (validateUsername(username)){
            editTextUsername.setError("Username has ben oqupied");
            view = editTextUsername;
            cancel = true;
        }

        //confirmasi password
        if (!comfirmPassword(password, password_confirm)){
            editTextPasswordConfirm.setError("Password confirmasi salah");
            view = editTextPasswordConfirm;
            cancel = true;
        }

        if (cancel){
            view.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),username);
            Preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }

    }

    private boolean comfirmPassword(String password, String repassword){
        return password.equals(repassword);
    }

    private boolean validateUsername(String username){
        return username.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}