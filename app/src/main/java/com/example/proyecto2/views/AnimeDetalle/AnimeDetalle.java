package com.example.proyecto2.views.AnimeDetalle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
<<<<<<< HEAD
import android.content.Intent;
import android.graphics.Color;
=======
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
>>>>>>> origin/master
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD
import com.bumptech.glide.Glide;
import com.example.proyecto2.R;
import com.example.proyecto2.views.AnimeBusquedad.AnimeViewBusquedad;
import com.example.proyecto2.views.Fragment.CuartoFragment;
=======

import com.bumptech.glide.Glide;
import com.example.proyecto2.Adapter.ListaAnimeAdapterAutorDetalle;
import com.example.proyecto2.Adapter.ListaAnimeAdapterSliderInicio;
import com.example.proyecto2.R;
import com.example.proyecto2.views.AnimeDemoDetalle;
import com.example.proyecto2.views.Fragment.CuartoFragment;
import com.example.proyecto2.views.Fragment.PrimerFragment;
import com.example.proyecto2.views.Fragment.SegundoFragment;
>>>>>>> origin/master
import com.example.proyecto2.views.Fragment.TercerFragment;
import com.example.proyecto2.views.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

<<<<<<< HEAD
public class AnimeDetalle extends AppCompatActivity {
    private TextView detalleTitulo, detalleSynopsis,detalleScore,detalleType,tablaAnimeType,tablaAnimeEpisode,tablaAnimeScore,tablaAnimeMembers,tablaAnimeStartDate;
    private ImageView detalleImage,detalleVolverInicio,irBack;
    private ImageButton favoritos;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton myFab;
=======
import java.util.ArrayList;

public class AnimeDetalle extends AppCompatActivity {
    private TextView detalleTitulo, detalleSynopsis, detalleEpisode,detalleScore,detalleType,tablaAnimeType,tablaAnimeEpisode,tablaAnimeScore,tablaAnimeMembers,tablaAnimeStartDate;
    private ImageView detalleImage,detalleVolverInicio,detalleFondo,irBack;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton myFab;
    private RecyclerView recyclerViewAutor;
    private ListaAnimeAdapterAutorDetalle listaAnimeAdapterAutorDetalle;
    private ArrayList<AnimeDetallePrueba> mainmodel;
    private ImageButton ImageViewirback;
    PrimerFragment miHome = new PrimerFragment();
    SegundoFragment miSearch = new SegundoFragment();
>>>>>>> origin/master
    TercerFragment miTv = new TercerFragment();
    CuartoFragment miSetting = new CuartoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detalle);
        irBack = findViewById(R.id.ImageViewBack);
        detalleImage = findViewById(R.id.detalleImageView);
        detalleTitulo = findViewById(R.id.detalleTitulo);
        detalleSynopsis = findViewById(R.id.detalleSynopsis);
<<<<<<< HEAD
=======
        //detalleEpisode = findViewById(R.id.detalleEpisode);
>>>>>>> origin/master
        detalleScore = findViewById(R.id.TextViewScore);
        detalleVolverInicio = findViewById(R.id.ImageViewBack);
        detalleType = findViewById(R.id.TextViewType);
        tablaAnimeType = findViewById(R.id.TextViewAnimeType);
        tablaAnimeEpisode = findViewById(R.id.TextViewAnimeNumber);
        tablaAnimeScore = findViewById(R.id.TextViewAnimeScore);
        tablaAnimeMembers = findViewById(R.id.TextViewAnimeMember);
        tablaAnimeStartDate = findViewById(R.id.TextViewAnimeStarDate);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
<<<<<<< HEAD
        favoritos = findViewById(R.id.imageView3);
=======
       // ImageViewirback = findViewById(R.id.ImageViewirback);
>>>>>>> origin/master
        myFab = findViewById(R.id.fab);
        myFab.setColorFilter(android.R.color.white);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
        myFab = findViewById(R.id.fab);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
<<<<<<< HEAD
        obtenerDetallesBestAnime();
    }

    public void marcarFavoritos(View view){
        favoritos.setBackgroundColor(Color.parseColor("#ff0038W"));
    }

    public void obtenerDetallesBestAnime(){
=======

        obtenerDetalles();
    }

    public void obtenerDetalles(){
>>>>>>> origin/master
        String type = getIntent().getStringExtra("Type");
        detalleType.setText(type);
        tablaAnimeType.setText(type);
        String score = getIntent().getStringExtra("Score");
        detalleScore.setText(score);
        tablaAnimeScore.setText(score);
        String imagen = getIntent().getStringExtra("Image");
        Glide.with(this)
                .load(imagen)
                .placeholder(R.drawable.ic_launcher_background)
                .into(detalleImage);
        String titulo = getIntent().getStringExtra("Titulo");
        detalleTitulo.setText(titulo);
        String synopsis = getIntent().getStringExtra("Synopsis");
        detalleSynopsis.setText(synopsis);
        String episode = getIntent().getStringExtra("Episode");
        //detalleEpisode.setText(episode);
        tablaAnimeEpisode.setText(episode);
        String members = getIntent().getStringExtra("Members");
        tablaAnimeMembers.setText(members);
        String starDate =  getIntent().getStringExtra("Start_Date");
        tablaAnimeStartDate.setText(starDate);
<<<<<<< HEAD
=======

>>>>>>> origin/master
    }

    public void irBack(View view){
        Intent irBack = new Intent(this, MainActivity.class);
        startActivity(irBack);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.miHome:
                    // loadFragment(miHome);
                    Intent i = new Intent(AnimeDetalle.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.miSearch:
<<<<<<< HEAD
//                    loadFragment(miSearch);
                    Intent irsearch = new Intent(AnimeDetalle.this, AnimeViewBusquedad.class);
                    startActivity(irsearch);
=======
                    loadFragment(miSearch);
//                    Intent irsearch = new Intent(MainActivity.this, Animesearch.class);
//                    startActivity(irsearch);
>>>>>>> origin/master
//                    finish();
                    return true;
                case R.id.miTv:
                    loadFragment(miTv);
//                    Intent irtv = new Intent(MainActivity.this, AnimeTv.class);
//                    startActivity(irtv);
//                    finish();
                    return true;
                case R.id.miSetting:
                       loadFragment(miSetting);
//                    Intent irconfig = new Intent(AnimeDetalle.this, AnimeDemoDetalle.class);
//                    startActivity(irconfig);
//                    finish();
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}