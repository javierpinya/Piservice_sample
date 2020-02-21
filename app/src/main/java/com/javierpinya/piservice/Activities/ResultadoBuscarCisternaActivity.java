package com.javierpinya.piservice.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.javierpinya.piservice.R;

import java.io.File;

public class ResultadoBuscarCisternaActivity extends AppCompatActivity {

    private Button btnCompartimentos,btnFichaTecnica,btnAdr,btnTablaCal,btnSimac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_buscar_cisterna);

        btnCompartimentos = findViewById(R.id.btn_compartimentos);
        btnAdr = findViewById(R.id.btn_adr);
        btnFichaTecnica = findViewById(R.id.btn_verfichatecnica);
        btnTablaCal = findViewById(R.id.btn_tablas_calibracion);
        btnSimac = findViewById(R.id.btn_simac);

        btnCompartimentos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ResultadoBuscarCisternaActivity.this, CompartimentosActivity.class);
                startActivity(intent);
            }
        });

        btnFichaTecnica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultadoBuscarCisternaActivity.this, RenderizarImagenActivity.class);
                startActivity(intent);

                //https://www.actualidadmotor.com/wp-content/uploads/2011/01/homologar-ITV.jpg

            }
        });
    }
}
