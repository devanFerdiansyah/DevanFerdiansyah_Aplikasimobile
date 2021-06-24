package com.example.sqlitesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText Fusername, Fpassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //deklarasi variable button
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //dekalrasi variable input
        Fusername = (EditText) findViewById(R.id.Fusername);
        Fpassword = (EditText) findViewById(R.id.Fpassword);

        //kalau btnRegister dipencet, pergi kehalaman register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }
    }

    private void validateInput(){
        Fusername.setError(null);
        Fpassword.setError(null);
        View view = null;
        boolean cancel = false;

        String username = Fusername.getText().toString();
        String password = Fpassword.getText().toString();

        //beri error jika fied kosong
        if (TextUtils.isEmpty(username)){
            Fusername.setError("This field is required");
            view = Fusername;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            Fpassword.setError("This field is required");
            view = Fpassword;
            cancel = true;
        }

        //beri error jika data yang diberikan tidak sama dengan yang ada di shared preference
        if (!validateUsername(username) || !validatePassword(password)){
            Fusername.setError("Username atau password salah");
            view = Fusername;
            cancel = true;
        }

        if (cancel){
            view.requestFocus();
        } else{
            login();
        }

    }

    public void login(){
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),MainActivity.class));finish();
    }


    private boolean validatePassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    private boolean validateUsername(String username){
        return username.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}