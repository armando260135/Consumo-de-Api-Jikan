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

public class ListaAnimeAdapterTop extends RecyclerView.Adapter<ListaAnimeAdapterTop.ViewHolder>{
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterTop(ArrayList<AnimeResults> animeResultsArrayListTop, Context context){
        this.context = context;
        this.dataset = animeResultsArrayListTop;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.TextViewTop.setText(a.getTitle());
        holder.TextViewTopSynopsis.setText(a.getSynopsis());
        //holder.textViewCapitulo.setText(a.getEpisodes());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ImageViewTop);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView TextViewTop,TextViewTopSynopsis;
        private ImageView ImageViewTop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewTop = itemView.findViewById(R.id.TextViewTop);
            ImageViewTop = itemView.findViewById(R.id.ImageViewTop);
            TextViewTopSynopsis = itemView.findViewById(R.id.TexViewTopSynopsis);
        }
    }
}
