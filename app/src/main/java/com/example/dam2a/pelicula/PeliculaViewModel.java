package com.example.dam2a.pelicula;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class PeliculaViewModel extends AndroidViewModel {

    private PeliculaRepositorio mRepository;

    public PeliculaViewModel(Application application) {
        super(application);
        mRepository = new PeliculaRepositorio(application);
    }


    public void insert(Pelicula pelicula) {
        mRepository.insert(pelicula);
    }


    LiveData<List<Pelicula>> getAllPeliculas() { return mRepository.getAllPeliculas(); }
}