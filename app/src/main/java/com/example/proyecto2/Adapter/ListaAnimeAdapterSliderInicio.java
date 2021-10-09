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

public class ListaAnimeAdapterSliderInicio extends RecyclerView.Adapter<ListaAnimeAdapterSliderInicio.ViewHolder> {
    private ArrayList<AnimeResults> dataset;
    private Context context;

    public ListaAnimeAdapterSliderInicio(ArrayList<AnimeResults> animeResultsArrayListTop, Context context) {
        this.context = context;
        this.dataset = animeResultsArrayListTop;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_principal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeResults a = dataset.get(position);
        holder.TextViewNombreInicio.setText(a.getTitle());
        Glide.with(context)
                .load(a.getImage_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ImageViewSliderPrincipal);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ImageViewSliderPrincipal;
        private TextView TextViewNombreInicio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageViewSliderPrincipal = itemView.findViewById(R.id.ImageViewSliderPrincipal);
            TextViewNombreInicio = itemView.findViewById(R.id.TextViewNombrePrincipal);
        }
    }
}