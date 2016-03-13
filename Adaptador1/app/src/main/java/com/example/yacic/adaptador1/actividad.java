package com.example.yacic.adaptador1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yacic on 03/02/2016.
 */
public class actividad extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad);
        TextView titulo= (TextView)findViewById(R.id.tvTitulo);
        ImageView imagen= (ImageView) findViewById(R.id.ivImagen);
        TextView descripcion= (TextView) findViewById(R.id.tvDescripcion);

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();
        Zona zona= (Zona)bundle.getSerializable("zona");

        titulo.setText(zona.getNombre());
        imagen.setImageResource(zona.getImagen());
        descripcion.setText(zona.getDescripcion());

    }
}
