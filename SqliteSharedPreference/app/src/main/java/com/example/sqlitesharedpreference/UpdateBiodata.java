package com.example.sqlitesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    Button btnSimpan, btnKembali;
    EditText Fnama, Fnomor, Ftgl, Fjkl, Falamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dataHelper = new DataHelper(this);
        Fnama = (EditText) findViewById(R.id.Fnama);
        Fnomor = (EditText) findViewById(R.id.Fnomor);
        Fjkl = (EditText) findViewById(R.id.Fjkl);
        Ftgl = (EditText) findViewById(R.id.Ftgl);
        Falamat= (EditText) findViewById(R.id.Falamat);

        SQLiteDatabase database = dataHelper.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            Fnomor.setText(cursor.getString(0).toString());
            Fnama.setText(cursor.getString(1).toString());
            Ftgl.setText(cursor.getString(2).toString());
            Fjkl.setText(cursor.getString(3).toString());
            Falamat.setText(cursor.getString(4).toString());
        }

        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dataHelper.getWritableDatabase();
                database.execSQL("UPDATE biodata SET nama = '"+
                        Fnama.getText().toString()+"', tgl='"+
                        Ftgl.getText().toString()+"', jk='"+
                        Fjkl.getText().toString()+"', alamat='"+
                        Falamat.getText().toString()+"' where no='"+
                        Fnomor.getText().toString()+"'");
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