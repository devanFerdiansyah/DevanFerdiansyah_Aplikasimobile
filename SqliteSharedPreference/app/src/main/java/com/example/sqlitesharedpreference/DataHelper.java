package com.example.sqlitesharedpreference;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table biodata " +
                "(`no` integer primary key AUTOINCREMENT, " +
                "nama text null, " +
                "tgl text null, " +
                "jk text null, " +
                "alamat text null);";
        Log.d("Data", "onCreate: " +sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (nama, tgl, jk, alamat) " +
                "VALUES ('figo', '1994-07-02', 'Laki-laki', 'trenggalek')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
