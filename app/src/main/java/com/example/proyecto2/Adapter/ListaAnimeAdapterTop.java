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

import java.util.ArrayList;

public class ListaAnimeAdapterTop extends RecyclerView.Adapter<ListaAnimeAdapterTop.ViewHolder> {
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterTop(ArrayList<AnimeResults> animeResultsArrayListTop, Context context) {
=======

import java.util.ArrayList;

public class ListaAnimeAdapterTop extends RecyclerView.Adapter<ListaAnimeAdapterTop.ViewHolder>{
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterTop(ArrayList<AnimeResults> animeResultsArrayListTop, Context context){
>>>>>>> origin/master
        this.context = context;
        this.dataset = animeResultsArrayListTop;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
<<<<<<< HEAD
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top, parent, false);
=======
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top,parent,false);
>>>>>>> origin/master
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.TextViewTop.setText(a.getTitle());
        holder.TextViewTopSynopsis.setText(a.getSynopsis());
<<<<<<< HEAD
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.carga4)
                .into(holder.ImageViewTop);

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
        //holder.textViewCapitulo.setText(a.getEpisodes());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ImageViewTop);

>>>>>>> origin/master
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

<<<<<<< HEAD
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TextViewTop, TextViewTopSynopsis;
=======
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView TextViewTop,TextViewTopSynopsis;
>>>>>>> origin/master
        private ImageView ImageViewTop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewTop = itemView.findViewById(R.id.TextViewTop);
            ImageViewTop = itemView.findViewById(R.id.ImageViewTop);
            TextViewTopSynopsis = itemView.findViewById(R.id.TexViewTopSynopsis);
        }
    }
}
