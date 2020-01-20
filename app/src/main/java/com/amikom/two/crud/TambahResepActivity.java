package com.amikom.two.crud;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amikom.two.R;
import com.amikom.two.model.SemuaResep;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.SemuaResepRoom;

public class TambahResepActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtJudul;
    EditText edtHarga;
    EditText edtResep;
    Button btnTambah;
    Button btnHapus;
    SemuaResepRoom semuaresepRoom;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_semuaresep);
        edtJudul = findViewById(R.id.semuaresep_tambah_judul);
        edtHarga = findViewById(R.id.semuaresep_tambah_harga);
        edtResep = findViewById(R.id.semuaresep_tambah_resep);
        btnTambah = findViewById(R.id.semuaresep_tambah);
        btnTambah.setOnClickListener(this);
        btnHapus = findViewById(R.id.semuaresep_hapus);

        semuaresepRoom = AppDatabase.db(this).semuaresepRoom();
        id = getIntent().getIntExtra("id", -1);
        if (id != -1) {
            SemuaResep semuaresep = semuaresepRoom.select(id);
            edtJudul.setText(semuaresep.getJudul());
            edtHarga.setText(semuaresep.getHarga());
            edtResep.setText(semuaresep.getResep());
            btnTambah.setText("Update Resep");
            btnHapus.setVisibility(View.VISIBLE);
            btnHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SemuaResep semuaresep = semuaresepRoom.select(id);
                    semuaresepRoom.delete(semuaresep);
                    Intent result = new Intent();
                    setResult(Activity.RESULT_OK, result);
                    finish();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        SemuaResep semuaresep = new SemuaResep();
        if (id != -1) {
            semuaresep = semuaresepRoom.select(id);
        }
        semuaresep.setJudul(edtJudul.getText().toString());
        semuaresep.setHarga(edtHarga.getText().toString());
        semuaresep.setResep(edtResep.getText().toString());

        if (id != -1) {
            semuaresepRoom.update(semuaresep);
        } else {
            semuaresepRoom.insert(semuaresep);
        }
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
