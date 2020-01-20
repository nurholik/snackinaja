package com.amikom.two.room;

import android.content.Context;

import com.amikom.two.model.Favorit;
import com.amikom.two.model.SemuaResep;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SemuaResep.class, Favorit.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "amikom")
                .allowMainThreadQueries()
                .build();
    }

    public abstract SemuaResepRoom semuaresepRoom();
    public abstract FavoritRoom favoritRoom();
}
