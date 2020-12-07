package com.example.Inventaris_kelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Inventaris_kelas";
    private static final String tb_Inventaris = "tb_Inventaris";
    private static final String tb_Inventaris_id = "id";
    private static final String tb_Inventaris_Jenis = "jenis";
    private static final String tb_Inventaris_jml = "jml";
    private static final String tb_Inventaris_nmr = "nmr";
    private static final String CREATE_TABLE_INVENTARIS = "CREATE TABLE " +
            tb_Inventaris + "("
            + tb_Inventaris_id + " INTEGER PRIMARY KEY ,"
            + tb_Inventaris_Jenis + " TEXT,"
            + tb_Inventaris_jml + " TEXT,"
            + tb_Inventaris_nmr + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_INVENTARIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Inventaris_id, mdNotif.get_id());
        values.put(tb_Inventaris_Jenis, mdNotif.getJenis());
        values.put(tb_Inventaris_jml, mdNotif.getJml());
        values.put(tb_Inventaris_nmr, mdNotif.getNmr());
        db.insert(tb_Inventaris, null, values);
        db.close();
    }

    public List<Barang> ReadBarang() {
        List<Barang> judulModelList = new ArrayList<Barang>();
        String selectQuery = "SELECT * FROM " + tb_Inventaris;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Barang mdKontak = new Barang();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.setJenis(cursor.getString(1));
                mdKontak.setJml(cursor.getString(2));
                mdKontak.setNmr(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Inventaris_Jenis, mdNotif.getJenis());
        values.put(tb_Inventaris_jml, mdNotif.getJml());
        values.put(tb_Inventaris_nmr, mdNotif.getNmr());
        return db.update(tb_Inventaris, values, tb_Inventaris_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_Inventaris, tb_Inventaris_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

