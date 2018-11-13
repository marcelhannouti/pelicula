package com.example.dam2a.pelicula;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        final PeliculaViewModel peliculaViewModel = ViewModelProviders.of(this).get(PeliculaViewModel.class);

        findViewById(R.id.botonanadir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula = new Pelicula();
                pelicula.title = ((EditText) findViewById(R.id.titulo)).getText().toString();

                peliculaViewModel.insert(pelicula);

                finish();
            }

        });
    }
}


