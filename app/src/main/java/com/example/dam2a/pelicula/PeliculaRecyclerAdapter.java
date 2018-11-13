package com.example.dam2a.pelicula;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PeliculaRecyclerAdapter extends RecyclerView.Adapter<PeliculaRecyclerAdapter.PeliculaViewHolder>{

    List<Pelicula> list;

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pelicula, viewGroup, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder peliculaViewHolder, int i) {
        Pelicula pelicula = list.get(i);
        peliculaViewHolder.Peliculatitle.setText(pelicula.title);
        peliculaViewHolder.PeliculaYear.setText(pelicula.year);
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Pelicula> peliculas){
        list = peliculas;
    }

    class PeliculaViewHolder extends RecyclerView.ViewHolder{
        private TextView Peliculatitle;
        private TextView PeliculaYear;

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            Peliculatitle = itemView.findViewById(R.id.pelicula_title);
            PeliculaYear = itemView.findViewById(R.id.pelicula_year);
        }
    }
}
