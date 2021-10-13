package com.example.proyecto2.Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.proyecto2.views.AnimeDetalle.AnimeDetalle;

import java.util.ArrayList;

public class ListaAnimeAdapterBest extends RecyclerView.Adapter<ListaAnimeAdapterBest.ViewHolder> {
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterBest(ArrayList<AnimeResults> animeResultsArrayListSpecial, Context context) {
        this.context = context;
        this.dataset = animeResultsArrayListSpecial;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_best, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.nombreTextView.setText(a.getTitle() + "\n" + "Score: " + a.getScore());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.carga4)
                .into(holder.fotoImageView);
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
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;
        private ImageView fotoImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
        }
    }

}
