package com.amikom.two.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favorit {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "judul")
    private String judul;
    @ColumnInfo(name = "resep")
    private String resep;


    public Favorit() {
    }

    public Favorit(int id, String judul, String resep) {
        this.id = id;
        this.judul = judul;
        this.resep = resep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getResep() {
        return resep;
    }

    public void setResep(String resep) {
        this.resep = resep;
    }




}
