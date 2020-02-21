package com.javierpinya.piservice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.javierpinya.piservice.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RenderizarImagenActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renderizar_imagen);

        iv = findViewById(R.id.iv_imagenrender);
        Picasso.get().load("https://www.actualidadmotor.com/wp-content/uploads/2011/01/homologar-ITV.jpg").into(iv);

    }
}
