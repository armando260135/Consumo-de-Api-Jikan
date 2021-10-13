package com.example.proyecto2.Adapter;

import android.content.Context;
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> origin/master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.R;
<<<<<<< HEAD
import com.example.proyecto2.views.AnimeDetalle.AnimeDetalle;
=======
>>>>>>> origin/master

import java.util.ArrayList;

public class ListaAnimeAdapterSliderInicio extends RecyclerView.Adapter<ListaAnimeAdapterSliderInicio.ViewHolder> {
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterSliderInicio(ArrayList<AnimeResults> animeResultsArrayListTop, Context context) {
        this.context = context;
        this.dataset = animeResultsArrayListTop;
    }

<<<<<<< HEAD
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_principal, parent, false);
=======

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_principal,parent,false);
>>>>>>> origin/master
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.TextViewNombreInicio.setText(a.getTitle());
        Glide.with(context)
                .load(a.getImage_url())
<<<<<<< HEAD
                .placeholder(R.drawable.carga4)
                .into(holder.ImageViewSliderPrincipal);
        String imagen = a.getImage_url();
        String titulo = a.getTitle();
        String synopsis = a.getSynopsis();
        String episode = a.getEpisodes();
        String score = a.getScore();
        String type = a.getType();
        String start_date = a.getStart_date();
        String end_date = a.getEnd_date();
        String members = a.getMembers();
        String rated = a.getRated();

        holder.itemView.setOnClickListener(view -> {
            Intent irDetalle = new Intent(context, AnimeDetalle.class);
            irDetalle.putExtra("Image", imagen);
            irDetalle.putExtra("Titulo", titulo);
            irDetalle.putExtra("Synopsis", synopsis);
            irDetalle.putExtra("Episode", episode);
            irDetalle.putExtra("Score", score);
            irDetalle.putExtra("Type", type);
            irDetalle.putExtra("Start_Date", start_date);
            irDetalle.putExtra("End_Date", end_date);
            irDetalle.putExtra("Members", members);
            irDetalle.putExtra("Rated", rated);
            context.startActivity(irDetalle);
        });
=======
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ImageViewSliderPrincipal);
>>>>>>> origin/master
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
<<<<<<< HEAD

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImageViewSliderPrincipal;
        private TextView TextViewNombreInicio;

=======
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ImageViewSliderPrincipal;
        private TextView TextViewNombreInicio;
>>>>>>> origin/master
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageViewSliderPrincipal = itemView.findViewById(R.id.ImageViewSliderPrincipal);
            TextViewNombreInicio = itemView.findViewById(R.id.TextViewNombrePrincipal);
        }
    }
}
