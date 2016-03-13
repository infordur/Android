package com.example.yacic.animales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvanimales;
    ArrayList<Animal> listaAnimales;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvanimales=(ListView) findViewById(R.id.listaAnimalitos);
        listaAnimales=new ArrayList<Animal>();

        listaAnimales.add(new Animal(R.drawable.cabra,R.drawable.perro,R.raw.cabra));
        listaAnimales.add(new Animal(R.drawable.perro,R.drawable.perro,R.raw.perro));
        listaAnimales.add(new Animal(R.drawable.gato,R.drawable.gato,R.raw.gato));
        listaAnimales.add(new Animal(R.drawable.vaca,R.drawable.vaca,R.raw.vaca));

        lvanimales.setAdapter(new adaptador(this, listaAnimales));

        lvanimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }

                mediaPlayer=mediaPlayer.create(getApplication(),listaAnimales.get(position).getSonido());
                mediaPlayer.start();

                ImageButton imagen=(ImageButton) view.findViewById(R.id.imageButton);
                imagen.setImageResource(listaAnimales.get(position).getImagen2());
            }
        });


    }
}
