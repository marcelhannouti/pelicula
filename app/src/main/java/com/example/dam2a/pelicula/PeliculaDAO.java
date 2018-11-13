package com.example.dam2a.pelicula;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PeliculaDAO {
    @Insert
    void insert(Pelicula pelicula);


    @Query("SELECT * FROM pelicula")
    LiveData<List<Pelicula>> getAllPeliculas();
}
