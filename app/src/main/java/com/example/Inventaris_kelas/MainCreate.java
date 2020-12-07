package com.example.Inventaris_kelas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Inventaris_kelas.R;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejenis, Ejml, Enmr;
    private String Sjenis, Sjml, Snmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Ejml = (EditText) findViewById(R.id.create_jml);
        Enmr = (EditText) findViewById(R.id.create_nmr);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Sjml = String.valueOf(Ejml.getText());
                Snmr = String.valueOf(Enmr.getText());
                if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjml.equals("")) {
                    Ejml.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jumlah barang",
                            Toast.LENGTH_SHORT).show();
                }else if (Snmr.equals("")) {
                    Enmr.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nomor inventaris ",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Ejenis.setText("");
                    Ejml.setText("");
                    Enmr.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateBarang(new Barang(null, Sjenis, Sjml, Snmr));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

