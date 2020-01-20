package com.amikom.two.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SemuaResep {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public SemuaResep() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "harga")
    private String harga;

    @ColumnInfo(name = "resep")
    private String resep;

    public SemuaResep(String judul, String harga, String resep) {
        this.judul = judul;
        this.harga = harga;
        this.resep = resep;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getResep() {
        return resep;
    }

    public void setResep(String resep) {
        this.resep = resep;
    }


}
