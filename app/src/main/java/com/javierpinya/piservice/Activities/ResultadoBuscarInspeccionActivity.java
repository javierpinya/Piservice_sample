package com.javierpinya.piservice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.javierpinya.piservice.R;

public class ResultadoBuscarInspeccionActivity extends AppCompatActivity {

    private ImageView im1,im2,im3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_buscar_inspeccion);

        im1 = findViewById(R.id.iv1);
        im2 = findViewById(R.id.iv2);
        im3 = findViewById(R.id.iv3);
/*
        im1.setImageResource(R.mipmap.bocas);
        im2.setImageResource(R.mipmap.camion1);
        im3.setImageResource(R.mipmap.truck);


 */
        //Imagen de <a href="https://pixabay.com/es/users/OpenClipart-Vectors-30363/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=146319">OpenClipart-Vectors</a> en <a href="https://pixabay.com/es/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=146319">Pixabay</a>
    }

}
