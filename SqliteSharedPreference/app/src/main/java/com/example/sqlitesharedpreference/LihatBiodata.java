package com.example.sqlitesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    Button btnKembali;
    TextView Cnomor, Cnama, Ctgl, Cjkl, Calamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dataHelper = new DataHelper(this);
        Cnomor = (TextView) findViewById(R.id.Cnomor);
        Cnama = (TextView) findViewById(R.id.Cnama);
        Ctgl = (TextView) findViewById(R.id.Ctgl);
        Cjkl = (TextView) findViewById(R.id.Cjkl);
        Calamat = (TextView) findViewById(R.id.Calamat);

        SQLiteDatabase database = dataHelper.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            Cnomor.setText(cursor.getString(0).toString());
            Cnama.setText(cursor.getString(1).toString());
            Ctgl.setText(cursor.getString(2).toString());
            Cjkl.setText(cursor.getString(3).toString());
            Calamat.setText(cursor.getString(4).toString());
        }

        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}