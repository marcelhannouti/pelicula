package com.example.dam2a.pelicula;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pelicula {
    @PrimaryKey(autoGenerate = true)
    public int  id;


    public String title;
    public String year;
    public float rating;
}