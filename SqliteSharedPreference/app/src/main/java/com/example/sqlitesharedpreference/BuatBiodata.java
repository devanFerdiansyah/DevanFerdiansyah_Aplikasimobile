package com.example.sqlitesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    Button btnSimpan, btnKembali;
    EditText Fnama, Fnomor, Ftgl, Fjkl, Falamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dataHelper = new DataHelper(this);
        Fnama = (EditText) findViewById(R.id.Fnama);
        Fnomor = (EditText) findViewById(R.id.Fnomor);
        Fjkl = (EditText) findViewById(R.id.Fjkl);
        Ftgl = (EditText) findViewById(R.id.Ftgl);
        Falamat= (EditText) findViewById(R.id.Falamat);

        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dataHelper.getWritableDatabase();
                database.execSQL("INSERT INTO biodata (nama, tgl, jk, alamat) values('"+
                        Fnama.getText().toString() + "','" +
                        Ftgl.getText().toString() + "','" +
                        Fjkl.getText().toString() + "','" +
                        Falamat.getText().toString() +"')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.mainActivity.RefreshList();
                finish();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}