package com.amikom.two.room;

import com.amikom.two.model.Favorit;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FavoritRoom {
    @Query("SELECT * FROM favorit")
    List<Favorit> selectAll();
    @Query("SELECT * FROM favorit WHERE id=:id")
    Favorit select(int id);

    @Insert
    void insert(Favorit favorit);
    @Update
    void update(Favorit favorit);
    @Delete
    void delete(Favorit favorit);

}
