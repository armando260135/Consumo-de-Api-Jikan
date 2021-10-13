package com.example.proyecto2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.proyecto2.R;

public class AnimeDemoDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_demo_detalle);

        ImageView imageView = findViewById(R.id.imageViewPrueba);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mantenimiento);

        imageView.setImageBitmap(getBlurImage(bitmap));
    }
    public Bitmap getBlurImage(Bitmap imagenRAW){
        Bitmap salidaBitmap = Bitmap.createBitmap(imagenRAW);

        final RenderScript renderScript = RenderScript.create(this);
        Allocation entradaTemp = Allocation.createFromBitmap(renderScript,imagenRAW);
        Allocation salidaTemp = Allocation.createFromBitmap(renderScript,salidaBitmap);

        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlur.setRadius(25f);
        scriptIntrinsicBlur.setInput(entradaTemp);
        scriptIntrinsicBlur.forEach(salidaTemp);

        salidaTemp.copyTo(salidaBitmap);
        return salidaBitmap;

    }
}