package com.example.dam2a.pelicula;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.boton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewMovieActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.pelicula_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PeliculaRecyclerAdapter peliculaRecyclerAdapter = new PeliculaRecyclerAdapter();
        recyclerView.setAdapter(peliculaRecyclerAdapter);



        ViewModelProviders.of(this).get(PeliculaViewModel.class).getAllPeliculas().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(@Nullable List<Pelicula> peliculas) {
                peliculaRecyclerAdapter.setList(peliculas);
                peliculaRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }


}
