package com.example.proyecto2.Adapter;

import android.content.Context;
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

import java.util.ArrayList;

public class ListaAnimeAdapterBest extends RecyclerView.Adapter<ListaAnimeAdapterBest.ViewHolder>{
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterBest(ArrayList<AnimeResults> animeResultsArrayList, Context context){
        this.context = context;
        this.dataset = animeResultsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_best,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.nombreTextView.setText(a.getTitle()+"\n"+"Score: " + a.getScore());
        //holder.textViewCapitulo.setText(a.getEpisodes());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.fotoImageView);
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView,textViewCapitulo;
        private ImageView fotoImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
//            textViewCapitulo = itemView.findViewById(R.id.TextViewCapitulo);
        }
    }

}
