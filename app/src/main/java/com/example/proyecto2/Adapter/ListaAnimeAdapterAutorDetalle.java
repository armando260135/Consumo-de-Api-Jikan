package com.example.proyecto2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto2.R;
import com.example.proyecto2.views.AnimeDetalle.AnimeDetalle;
import com.example.proyecto2.views.AnimeDetalle.AnimeDetallePrueba;

import java.util.ArrayList;

public class ListaAnimeAdapterAutorDetalle extends RecyclerView.Adapter<ListaAnimeAdapterAutorDetalle.ViewHolder> {
    private ArrayList<AnimeDetallePrueba> mainModels;
    Context context;

    public ListaAnimeAdapterAutorDetalle(Context context,ArrayList<AnimeDetallePrueba> mainModels) {
        this.context = context;
        this.mainModels = mainModels;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle_circulo_autor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAnimeAdapterAutorDetalle.ViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModels.get(position).getLangLogo());
        holder.textView.setText(mainModels.get(position).getLangName());

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ImageViewPersonaje);
            textView = itemView.findViewById(R.id.TextViewNmbreAutor);
        }
    }
}
