package com.example.dam2a.pelicula;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class PeliculaRepositorio {
    private static PeliculaDAO mPelciculaDAO;

    public PeliculaRepositorio(Application application) {
        mPelciculaDAO = PeliculaRoomDatabase.getDatabase(application).poemDAO();
    }





    LiveData<List<Pelicula>> getAllPeliculas() {
        return mPelciculaDAO.getAllPeliculas();
    }






    public void insert(Pelicula pelicula) {
        new insertAsyncTask(mPelciculaDAO).execute(pelicula);
    }

    private static class insertAsyncTask extends AsyncTask<Pelicula, Void, Void> {

        private PeliculaDAO mAsyncTaskDao;

        insertAsyncTask(PeliculaDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Pelicula... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}



