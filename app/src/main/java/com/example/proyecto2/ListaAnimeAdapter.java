package com.example.proyecto2;

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

import java.util.ArrayList;

public class ListaAnimeAdapter extends RecyclerView.Adapter<ListaAnimeAdapter.ViewHolder>{
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapter(ArrayList<AnimeResults> animeResultsArrayList,Context context){
        this.context = context;
        this.dataset = animeResultsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.nombreTextView.setText(a.getTitle());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.fotoImageView);
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }

//    public void adiccionarListaAnime(ArrayList<AnimeResults> listaAnimeResults) {
//        dataset.addAll(listaAnimeResults);
//        notifyDataSetChanged();
//    }
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
