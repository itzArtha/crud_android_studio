package com.example.mobprob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "startups";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS details(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    long addData(Startup s) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put("name", s.getNama());

        long hasil = sql.insert("details", null, values);
        sql.close();

        return hasil;
    }

    long delData(String id) {
        SQLiteDatabase sql = this.getWritableDatabase();
        return sql.delete("details", "nim=?", new String[] { id });
    }

    ArrayList<Startup> allData() {
        ArrayList<Startup> all = new ArrayList<>();

        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor cursor = sql.query(
                "details",
                new String[] { "id", "name" },
                null,
                null,
                null,
                null,
                "id"
        );

        if(cursor != null) {
            if(cursor.moveToFirst()) {
                Startup data = new Startup(cursor.getString(cursor.getColumnIndex("name")));
                all.add(data);
            } while(cursor.moveToNext());
        }

        return all;
    }
}
