package com.example.proyecto2.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyecto2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AnimeTv extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_tv);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.miHome:
                    // loadFragment(miHome);
                    Intent i = new Intent(AnimeTv.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.miSearch:
                    //  loadFragment(miSearch);
                    Intent irsearch = new Intent(AnimeTv.this, Animesearch.class);
                    startActivity(irsearch);
                    finish();
                    return true;
                case R.id.miTv:
                    //  loadFragment(miTv);
                    Intent irtv = new Intent(AnimeTv.this, AnimeTv.class);
                    startActivity(irtv);
                    finish();
                    return true;
                case R.id.miSetting:
                    //  loadFragment(miSetting);
                    Intent irconfig = new Intent(AnimeTv.this, AnimeSetting.class);
                    startActivity(irconfig);
                    finish();
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }
}