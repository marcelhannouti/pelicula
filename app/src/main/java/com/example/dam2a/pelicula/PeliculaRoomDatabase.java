package com.example.dam2a.pelicula;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Pelicula.class}, version = 1)

public abstract class PeliculaRoomDatabase extends RoomDatabase {

    public abstract PeliculaDAO poemDAO();

    private static volatile PeliculaRoomDatabase INSTANCE;

    static PeliculaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PeliculaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PeliculaRoomDatabase.class, "poem_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
