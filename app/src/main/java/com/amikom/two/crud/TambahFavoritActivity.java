package com.amikom.two.crud;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amikom.two.R;
import com.amikom.two.model.Favorit;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.FavoritRoom;

public class TambahFavoritActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edJudul;
    EditText edResep;
    Button btnTambah;
    Button btnHapus;
    FavoritRoom favoritRoom;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_favorit);

        edJudul = findViewById(R.id.favorit_tambah_judul);
        edResep = findViewById(R.id.favorit_tambah_resep);
        btnTambah = findViewById(R.id.favorit_tambah);
        btnHapus = findViewById(R.id.favorit_hapus);
        btnTambah.setOnClickListener(this);

        favoritRoom = AppDatabase.db(this).favoritRoom();

        id = getIntent().getIntExtra("id", -1);
        if (id != -1){
            Favorit favorit = favoritRoom.select(id);
            edJudul.setText(favorit.getJudul());
            edResep.setText(favorit.getResep());

            btnTambah.setText("Update Favorit");
            btnHapus.setVisibility(View.VISIBLE);
            btnHapus.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();

        Favorit favorit = new Favorit();
        if (id != -1) favorit.setId(id);
        favorit.setJudul(edJudul.getText().toString());
        favorit.setResep(edResep.getText().toString());

        switch (v.getId()){
            case R.id.favorit_tambah:
                if (id != -1) favoritRoom.update(favorit);
                else favoritRoom.insert(favorit);
                break;
            case R.id.favorit_hapus:
                favoritRoom.delete(favorit);
                break;
        }


        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
