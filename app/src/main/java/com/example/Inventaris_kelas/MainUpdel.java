package com.example.Inventaris_kelas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjenis, Sjml,Snmr;
    private EditText Ejenis, Ejml, Enmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjenis = i.getStringExtra("Ijenis");
        Sjml = i.getStringExtra("Ijml");
        Snmr = i.getStringExtra("Inmr");
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Ejml = (EditText) findViewById(R.id.updel_jml);
        Enmr = (EditText) findViewById(R.id.updel_nmr);
        Ejenis.setText(Sjenis);
        Ejml.setText(Sjml);
        Enmr.setText(Snmr);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Sjml = String.valueOf(Ejml.getText());
                Snmr = String.valueOf(Enmr.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjml.equals("")){
                    Ejml.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jumlah barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Snmr.equals("")){
                    Enmr.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nomor inventaris",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBarang(new Barang(Sid, Sjenis, Sjml, Snmr));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBarang(new Barang(Sid, Sjenis, Sjml, Snmr));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}