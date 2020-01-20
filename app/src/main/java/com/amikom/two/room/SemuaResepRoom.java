package com.amikom.two.room;

import com.amikom.two.model.SemuaResep;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SemuaResepRoom {
    @Query("SELECT * FROM semuaresep WHERE id = :id")
    SemuaResep select(int id);

    @Query("SELECT * FROM semuaresep")
    List<SemuaResep> selectAll();

    @Insert
    void insert(SemuaResep semuaresep);

    @Update
    void update(SemuaResep semuaresep);

    @Delete
    void delete(SemuaResep semuaresep);
}

