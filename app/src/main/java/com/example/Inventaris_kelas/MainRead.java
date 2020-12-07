package com.example.Inventaris_kelas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Inventaris_kelas.R;

import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Barang> listBarang = new ArrayList<Barang>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listBarang);
        mListView = (ListView) findViewById(R.id.list_barang);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listBarang.clear();
        List<Barang> contacts = db.ReadBarang();
        for (Barang cn : contacts) {
            Barang judulModel = new Barang();
            judulModel.set_id(cn.get_id());
            judulModel.setJenis(cn.getJenis());
            judulModel.setJml(cn.getJml());
            judulModel.setNmr(cn.getNmr());
            listBarang.add(judulModel);
            if ((listBarang.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Barang obj_itemDetails = (Barang) o;
        String Sid = obj_itemDetails.get_id();
        String Sjenis = obj_itemDetails.getJenis();
        String Sjml = obj_itemDetails.getJml();
        String Snmr = obj_itemDetails.getNmr();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Ijml", Sjml);
        goUpdel.putExtra("Inmr",Snmr);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listBarang.clear();
        mListView.setAdapter(adapter_off);
        List<Barang> contacts = db.ReadBarang();
        for (Barang cn : contacts) {
            Barang judulModel = new Barang();
            judulModel.set_id(cn.get_id());
            judulModel.setJenis(cn.getJenis());
            judulModel.setJml(cn.getJml());
            judulModel.setNmr(cn.getNmr());
            listBarang.add(judulModel);
            if ((listBarang.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}


